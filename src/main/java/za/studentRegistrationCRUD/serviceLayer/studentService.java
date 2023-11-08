package za.studentRegistrationCRUD.serviceLayer;

import za.studentRegistrationCRUD.entity.Student;

public interface studentService {

    int ssSaveStudent(Student student);
    Student ssGetStudentById(int studentId);
    boolean ssUpdateStudent(Student student);
    boolean ssDeleteStudentById(int studentId);
}
