package za.studentRegistrationCRUD.dao;

import za.studentRegistrationCRUD.entity.Student;
import za.studentRegistrationCRUD.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class studentDAOImpl implements studentDAO {


    @Override
    public int daoSaveStudent(Student student) {

        JDBCUtil util = new JDBCUtil();
        Statement statement = null;
        int noOfQueries = 0;

        try {

            statement = util.getStatement();
            String sql = "insert into student(student_no,first_name,last_name,email)" + "values(\'" + student.getStudentNo() + "\',\'" + student.getFirstname() + "\',\'" + student.getLastname() + "\',\'" + student.getEmail() + "\')";
            noOfQueries = statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return noOfQueries;
    }

    @Override
    public Student daoGetStudentByNo(int studentNo) {

        JDBCUtil util = new JDBCUtil();
        Statement statement = null;
        Student student = null;

        try {
            statement = util.getStatement();
            String sql = "select * from student where student_no =" + studentNo;
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                student = new Student();

                student.setStudentNo(rs.getInt("student_no"));
                student.setFirstname(rs.getString("first_name"));
                student.setLastname(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean daoUpdateStudent(Student student) {

        JDBCUtil util = new JDBCUtil();
        Statement statement = null;

        try {

            statement = util.getStatement();
            String sql = "update student set first_name=\'" + student.getFirstname() + "\', last_name=\'" + student.getLastname() + "\', email=\'" + student.getEmail() + "\' where student_no=" + student.getStudentNo();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public boolean daoDeleteStudentByNo(int studentNo) {
        JDBCUtil util = new JDBCUtil();
        Statement statement = null;

        try {

            statement = util.getStatement();
            String sql = "delete from student where student_no=" + studentNo;
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Student> getAllStudents() {

        JDBCUtil util = new JDBCUtil();
        Statement statement = null;
        Student student = null;
        List<Student> list = new ArrayList<>();

        try {

            statement = util.getStatement();
            String sql = "select * from student";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                student = new Student();

                student.setStudentNo(rs.getInt("student_no"));
                student.setFirstname(rs.getString("first_name"));
                student.setLastname(rs.getString("last_name"));
                student.setEmail(rs.getString("email"));
                list.add(student);

            }
            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;
    }
}
