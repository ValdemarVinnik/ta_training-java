package com.epam.training.student_Uladzimir_Vinnik.classes.student_servis;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    List<Student> students;

    public StudentsDataBase(List<Student> students) {
        this.students = students;
    }

    public StudentsDataBase() {
        this.students = new ArrayList<Student>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void addAllStudents(List<Student> studentList){
        students.addAll(studentList);
    }

    public List<Student> listOfStudentsFromFaculty(String faculty){
        List<Student> returnList = new ArrayList<Student>();

        for (Student each: students ) {
            if (each.getFaculty().equalsIgnoreCase(faculty)){
                returnList.add(each);
            }
        }
        return returnList;
    }

    public List<Student> listOfStudentsFromFacultyAndCurs(String faculty, String curse){
        List<Student> returnList = new ArrayList<Student>();

        for (Student each: students ) {
            if ((each.getFaculty().equalsIgnoreCase(faculty))&&
                    each.getCurse().equals(curse)){
                returnList.add(each);
            }
        }
        return returnList;
    }

    public List<Student> listOfStudentsFromCurs(String curse){
        List<Student> returnList = new ArrayList<Student>();

        for (Student each: students ) {
            if (each.getCurse().equals(curse)){
                returnList.add(each);
            }
        }
        return returnList;
    }

    public List<Student> listOfStudentsBornAfterDate(){
        return null;
    }
}
