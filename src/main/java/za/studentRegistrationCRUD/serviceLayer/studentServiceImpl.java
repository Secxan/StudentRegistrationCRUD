package za.studentRegistrationCRUD.serviceLayer;

import za.studentRegistrationCRUD.dao.studentDAO;
import za.studentRegistrationCRUD.dao.studentDAOImpl;
import za.studentRegistrationCRUD.entity.Student;

public class StudentServiceImpl implements StudentService {
    @Override
    public int ssSaveStudent(Student student) {
        studentDAO dao = new studentDAOImpl();
        return dao.daoSaveStudent(student);

    }

    @Override
    public Student ssGetStudentByNo(int studentNo) {

        studentDAO dao = new studentDAOImpl();
       return dao.daoGetStudentByNo(studentNo);

    }

    @Override
    public boolean ssUpdateStudent(Student student) {
        studentDAO dao = new studentDAOImpl();
        return dao.daoUpdateStudent(student);

    }

    @Override
    public boolean ssDeleteStudentByNo(int studentNo) {
        studentDAO dao = new studentDAOImpl();
        return dao.daoDeleteStudentByNo(studentNo);

    }
}
