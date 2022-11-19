package org.example;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile profile;
    @XmlElement(name = "avgScore")
    private float avgExamScore;
    @XmlTransient
    private int numberOfStudents;
    @XmlTransient
    private int numberOfUniversities;
    @XmlTransient
    private String fullName;


    public Statistics() {

    }

    public StudyProfile getStudyProfile() {
        return profile;
    }

    public Statistics setStudyProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Statistics setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        return this;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public Statistics setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Statistics setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
