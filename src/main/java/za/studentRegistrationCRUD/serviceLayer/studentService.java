package za.studentRegistrationCRUD.serviceLayer;

import za.studentRegistrationCRUD.entity.Student;

import java.util.List;

public interface StudentService {

    int ssSaveStudent(Student student);
    Student ssGetStudentByNo(int studentNo);
    boolean ssUpdateStudent(Student student);
    boolean ssDeleteStudentByNo(int studentNo);
    List<Student> getAllStudents();
}
