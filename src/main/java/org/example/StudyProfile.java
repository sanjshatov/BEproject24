package org.example;

public enum StudyProfile {
    MEDICINE("МЕДИЦИНА"),
    BUILDING("СТРОИТЕЛЬСТВО"),
    LANGUAGES("ИНОСТРАННЫЕ ЯЗЫКИ"),
    CHEMISTRY("ХИМИЯ");

    private final String profileName;


    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}