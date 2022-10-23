package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities = Reader.readUniversity("D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\universityInfo.xlsx");
        UniversityComparator universityComparator = UtilClass.getUniversityComparator(UniversityComparatorOption.ID);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students = Reader.readStudent("D:\\java_projects\\sources\\BEproject\\src\\main\\resources\\universityInfo.xlsx");
        StudentComparator studentComparator = UtilClass.getStudentComparator(StudentComparatorOption.COURSE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

    }
}
