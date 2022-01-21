package com.epam.training.student_Uladzimir_Vinnik.classes.student_servis;

import java.util.Date;

public class Student{
    private String id;
    private String name;
    private String secondName;
    private String patronymic;
    private Date dateOfBirth = new Date();
    private String fonNumber;
    private String faculty;
    private String curse;
    private String group;

    public Student(String id, String name, String secondName, String patronymic, Date dateOfBirth,
                   String fonNumber, String faculty, String curse, String group) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.fonNumber = fonNumber;
        this.faculty = faculty;
        this.curse = curse;
        this.group = group;
    }

    public Student() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFonNumber() {
        return fonNumber;
    }

    public void setFonNumber(String fonNumber) {
        this.fonNumber = fonNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", fonNumber='" + fonNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", curse='" + curse + '\'' +
                ", group='" + group + '\'' +
                '}';
    }



}
