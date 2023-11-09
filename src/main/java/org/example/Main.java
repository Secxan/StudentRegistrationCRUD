package org.example;

import za.studentRegistrationCRUD.entity.Student;
import za.studentRegistrationCRUD.serviceLayer.StudentService;
import za.studentRegistrationCRUD.serviceLayer.StudentServiceImpl;
import za.studentRegistrationCRUD.ui.Login;

public class Main {
    public static void main(String[] args) {

        //StudentService studentService = new StudentServiceImpl();
       // Student student = new Student(890,"John","Pistorius","jp@gmail.com");
       // studentService.ssSaveStudent(student);
         //Student student = null;
        //Student student =  studentService.ssGetStudentByNo(890);
         //System.out.println(student);

        //Student student = new Student(890,"Jan","Cecil","cecil@jan.com");
        //studentService.ssUpdateStudent(student);
        // studentService.ssDeleteStudentByNo(102);
        Login login = new Login();
        login.arrangeComponents();


    }
}