package com.epam.tests.classes_test.students_servis_test;

import com.epam.training.student_Uladzimir_Vinnik.classes.student_servis.Student;
import com.epam.training.student_Uladzimir_Vinnik.classes.student_servis.StudentsDataBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsDataBaseTest {

    private StudentsDataBase dataBase;
    private List<Student> studentList;

    @BeforeEach

    public void initialisation() throws ParseException {
        this.dataBase = new StudentsDataBase();
        this.studentList = new ArrayList<>();

        studentList.add(new Student("01","Alexandr","Sergeevich","Pushkin",
                "06.06.1799","+375293344555","Lit","2","1l"));
        studentList.add(new Student("02","Michail","Jurievich","Lermontov",
                "03.10.1814","+375293366555","Lit","2","2l"));
        studentList.add(new Student("03","Lev","Nikolaevich","Tolstoy",
                "28.08.1828","+375291244555","Lit","2","2l"));
        studentList.add(new Student("04","Ivan","Konstantinovich","Ajvazovskiy",
                "17.07.1817","+375293345678","Paint","1","1p"));
        studentList.add(new Student("05","Ivan","Ivanovich","Shihkin",
                "13.01.1832","+375293344987","Paint","1","1p"));
        studentList.add(new Student("06","Ilija","Efimovich","Repin",
                "24.07.1844","+375291234567","Paint","2","2p"));


    }

    @Test
    public void creationStudentBaseTest(){
        dataBase.addAllStudents(studentList);

        Assertions.assertTrue(dataBase.getBase().equals(studentList),"List in StudentsDataBase isn't full...");
    }

}
