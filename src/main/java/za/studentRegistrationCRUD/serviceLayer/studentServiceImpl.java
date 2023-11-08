package za.studentRegistrationCRUD.serviceLayer;

import za.studentRegistrationCRUD.dao.studentDAO;
import za.studentRegistrationCRUD.dao.studentDAOImpl;
import za.studentRegistrationCRUD.entity.Student;

public class studentServiceImpl implements studentService {
    @Override
    public int ssSaveStudent(Student student) {
        studentDAO dao = new studentDAOImpl();
        int noOfQueries =dao.daoSaveStudent(student);
        return noOfQueries;
    }

    @Override
    public Student ssGetStudentById(int studentId) {

        studentDAO dao = new studentDAOImpl();
       return dao.daoGetStudentById(studentId);

    }

    @Override
    public boolean ssUpdateStudent(Student student) {
        studentDAO dao = new studentDAOImpl();
        dao.daoUpdateStudent(student);
        return true;
    }

    @Override
    public boolean ssDeleteStudentById(int studentId) {
        studentDAO dao = new studentDAOImpl();
        dao.daoDeleteStudentById(studentId);
        return true;
    }
}
