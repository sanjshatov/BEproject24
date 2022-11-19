package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        logger.log(Level.INFO, "Application started. Logger configured");

        List<University> universities = Reader.readUniversity("D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator = UtilClass.getUniversityComparator(UniversityComparatorOption.ID);
        universities.sort(universityComparator);
//        String universitiesToJson = JsonUtil.universityListToJson(universities);
//        System.out.println(universitiesToJson);
//        List<University> universitiesFromJson = JsonUtil.universityListFromJson(universitiesToJson);
//        universitiesFromJson.forEach(university -> {
//            String universityToJson = JsonUtil.universityToJson(university);
//            System.out.println(universityToJson);
//            University universityFromJson = JsonUtil.universityFromJson(universityToJson);
//            System.out.println(universityFromJson);
//        });
//        System.out.println(universities.size() == universitiesFromJson.size());

        List<Student> students = Reader.readStudent("D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\universityInfo.xlsx");
        StudentComparator studentComparator = UtilClass.getStudentComparator(StudentComparatorOption.COURSE);
        students.sort(studentComparator);
//        String studentsToJson = JsonUtil.studentListToJson(students);
//        System.out.println(studentsToJson);
//        List<Student> studentsFromJson = JsonUtil.studentListFromJson(studentsToJson);
//        studentsFromJson.forEach(student -> {
//            String studentToJson = JsonUtil.studentToJson(student);
//            System.out.println(studentToJson);
//            Student studentFromJson = JsonUtil.studentFromJson(studentToJson);
//            System.out.println(studentFromJson);
//        });
//        System.out.println(students.size() == studentsFromJson.size());

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.createTable(statisticsList, "D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\statistics.xlsx");

        Structure structure = new Structure()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        org.example.XmlWriter.generateXmlReq(structure);
        org.example.JsonWriter.writeJsonReq(structure);


        logger.log(Level.INFO, "Application finished");

    }
}
