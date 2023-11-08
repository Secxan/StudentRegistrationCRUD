package za.studentRegistrationCRUD.dao;

import za.studentRegistrationCRUD.entity.Student;

public class studentDAOImpl implements studentDAO{


    @Override
    public int daoSaveStudent(Student student) {
        return 0;
    }

    @Override
    public Student daoGetStudentById(int studentId) {
        return null;
    }

    @Override
    public boolean daoUpdateStudent(Student student) {
        return false;
    }

    @Override
    public boolean daoDeleteStudentById(int studentId) {
        return false;
    }
}
