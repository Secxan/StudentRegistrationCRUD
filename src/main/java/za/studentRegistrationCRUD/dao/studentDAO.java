package za.studentRegistrationCRUD.dao;

import za.studentRegistrationCRUD.entity.Student;

import java.util.List;

public interface studentDAO {
    int daoSaveStudent(Student student);
    Student daoGetStudentByNo(int studentNo);
    boolean daoUpdateStudent(Student student);
    boolean daoDeleteStudentByNo(int studentNo);
    List < Student > getAllStudents();



}
