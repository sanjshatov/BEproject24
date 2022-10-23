package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.Student;

public class StudentFullNameComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
