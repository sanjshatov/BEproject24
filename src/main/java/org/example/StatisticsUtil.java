package org.example;



import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {
    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();
        //  С помощью Java Stream API собираем статистику.

        Set<StudyProfile> profiles = universities.stream()
                // метод getMainProfile для каждого элемента University
                .map(University::getMainProfile)
                // собираем эл-ты в множество
                .collect(Collectors.toSet());
        //  Для каждого профиля обучения, по которому есть хотя бы один университет,
        //  создаем экземпляр класса org.example.Statistics. Заполняем все его поля.
        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);
            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumberOfUniversities(profileUniversityIds.size());
            statistics.setFullName(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullName -> statistics.setFullName(statistics.getFullName() + fullName + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore((float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });


        return statisticsList;
    }

}
