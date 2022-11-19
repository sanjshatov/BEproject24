package org.example;

import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Structure {
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universityList;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticsList;
    @XmlElement(name = "processedAt")
    private Date processDate;

    public Structure() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Structure setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public Structure setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public Structure setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public Structure setProcessDate(Date processDate) {
        this.processDate = processDate;
        return this;
    }
}
