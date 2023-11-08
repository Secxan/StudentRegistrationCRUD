package za.studentRegistrationCRUD.dao;

import za.studentRegistrationCRUD.entity.Student;

public interface studentDAO {
    int daoSaveStudent(Student student);
    Student daoGetStudentById(int studentId);
    boolean daoUpdateStudent(Student student);
    boolean daoDeleteStudentById(int studentId);



}
