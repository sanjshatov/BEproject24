package org.example;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

public class University {
    @SerializedName("ID")
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("Full name")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("Short name")
    @XmlTransient
    private String shortName;
    @SerializedName("Year of foundation")
    @XmlTransient
    private int yearOfFoundation;

    public University() {

    }

    @SerializedName("profile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return String.format("id = %s, fullName = %s, shortName = %s, yearOfFoundation = %s, mainProfile = %s",
                this.id,
                this.fullName,
                this.shortName,
                this.yearOfFoundation,
                this.mainProfile.getProfileName());
    }
}
