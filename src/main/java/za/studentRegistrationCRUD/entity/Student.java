package za.studentRegistrationCRUD.entity;

public class Student {

    private int studentNo;
    private String firstname;
    private String lastname;
    private String email;

    public Student() {
    }

    public Student(int studentNo, String firstname, String lastname, String email) {
        this.studentNo = studentNo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentId(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo=" + studentNo +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

