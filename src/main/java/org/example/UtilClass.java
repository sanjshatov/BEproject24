package org.example;

import org.example.comparator.*;

public class UtilClass {
    private UtilClass() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorOption studentComparatorOption) {

        switch (studentComparatorOption) {

            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                //noinspection duplicates
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorOption universityComparatorType) {

        switch (universityComparatorType) {

            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                //noinspection duplicates
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case YEAR:
                return new UniversityYearComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
