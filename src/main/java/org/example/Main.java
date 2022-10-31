package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities = Reader.readUniversity("D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator = UtilClass.getUniversityComparator(UniversityComparatorOption.ID);
        universities.sort(universityComparator);
        String universitiesToJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesToJson);
        List<University> universitiesFromJson = JsonUtil.universityListFromJson(universitiesToJson);
        universitiesFromJson.forEach(university -> {
            String universityToJson = JsonUtil.universityToJson(university);
            System.out.println(universityToJson);
            University universityFromJson = JsonUtil.universityFromJson(universityToJson);
            System.out.println(universityFromJson);
        });
        System.out.println(universities.size() == universitiesFromJson.size());

        List<Student> students = Reader.readStudent("D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\universityInfo.xlsx");
        StudentComparator studentComparator = UtilClass.getStudentComparator(StudentComparatorOption.COURSE);
        students.sort(studentComparator);
        String studentsToJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsToJson);
        List<Student> studentsFromJson = JsonUtil.studentListFromJson(studentsToJson);
        studentsFromJson.forEach(student -> {
            String studentToJson = JsonUtil.studentToJson(student);
            System.out.println(studentToJson);
            Student studentFromJson = JsonUtil.studentFromJson(studentToJson);
            System.out.println(studentFromJson);
        });
        System.out.println(students.size() == studentsFromJson.size());

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.createTable(statisticsList, "D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\statistics.xlsx");
    }
}
