package com.epam.training.student_Uladzimir_Vinnik.classes.student_servis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String secondName;
    private String patronymic;
    private Date dateOfBirth = new Date();
    private String fonNumber;
    private String faculty;
    private String curse;
    private String group;

    public Student(String id, String name, String secondName, String patronymic, String dateOfBirth,
                   String fonNumber, String faculty, String curse, String group) throws ParseException {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
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

    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        this.dateOfBirth = new SimpleDateFormat("dd.MM.YY").parse(dateOfBirth);
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

        return String.format("%s  %s  %s  %s  id: %s  Facultet:%s   Grup:%s     Curse: %s   f.:%s",
                name, secondName, patronymic, dateOfBirth, id, faculty, group, curse, fonNumber);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result += 3 * name.hashCode();
        result += 5 * secondName.hashCode();
        result += 7 * patronymic.hashCode();
        result += 11 * dateOfBirth.hashCode();
        result += 13 * fonNumber.hashCode();
        result += 17 * faculty.hashCode();
        result += 19 * curse.hashCode();
        result += 23 * group.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        if (!(obj instanceof Student)) return false;

        Student objToCompare = (Student) obj;

        if ((this.id != null) ? !this.id.equals(objToCompare.getId()) : objToCompare.getId() != null) {
            return false;
        }

        if ((this.secondName != null) ? !this.secondName.equals(objToCompare.getSecondName())
                : objToCompare.getSecondName() != null) {
            return false;
        }

        if ((this.name != null) ? !this.name.equals(objToCompare.getName())
                :objToCompare.getName() != null) {
            return false;
        }

        if ((this.patronymic != null) ? !this.patronymic.equals(objToCompare.getPatronymic())
                : objToCompare.getPatronymic() != null) {
            return false;
        }

        if ((this.dateOfBirth != null) ? !this.dateOfBirth.equals(objToCompare.getDateOfBirth())
                : objToCompare.getDateOfBirth() != null) {
            return false;
        }

        if ((this.fonNumber != null) ? !this.fonNumber.equals(objToCompare.getFonNumber())
                : objToCompare.getFonNumber() != null) {
            return false;
        }

        if ((this.faculty != null) ? !this.faculty.equals(objToCompare.getFaculty())
                : objToCompare.getFaculty() != null) {
            return false;
        }

        if ((this.group != null) ? !this.group.equals(objToCompare.getGroup())
                : objToCompare.getGroup() != null) {
            return false;
        }

        return (this.curse != null) ? this.group.equals(objToCompare.getGroup())
                : objToCompare.getCurse() == null;

    }
}

