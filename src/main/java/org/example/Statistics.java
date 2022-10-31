package org.example;

public class Statistics {
    private StudyProfile profile;
    private float avgExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
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
