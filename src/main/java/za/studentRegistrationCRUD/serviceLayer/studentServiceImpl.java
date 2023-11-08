package za.studentRegistrationCRUD.serviceLayer;

import za.studentRegistrationCRUD.entity.Student;

public class studentServiceImpl implements studentService {
    @Override
    public int ssSaveStudent(Student student) {
        return 0;
    }

    @Override
    public Student ssGetStudentById(int studentId) {
        return null;
    }

    @Override
    public boolean ssUpdateStudent(Student student) {
        return false;
    }

    @Override
    public boolean ssDeleteStudentById(int studentId) {
        return false;
    }
}
