package za.studentRegistrationCRUD.ui;

import za.studentRegistrationCRUD.entity.Student;
import za.studentRegistrationCRUD.serviceLayer.StudentService;
import za.studentRegistrationCRUD.serviceLayer.StudentServiceImpl;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class InsertStudent extends JPanel {

    private JLabel studentNoLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel emailLabel;

    private  JTextField studentNoText;
    private JTextField firstnameText;
    private JTextField lastnameText;
    private JTextField emailText;

    private JButton resetButton;
    private JButton submitButton;
    private JButton cancelButton;
    private JButton updateButton;
    private JButton deleteButton;

    private Container contentPane;
    JPanel tablePanel;
    private JTable jTable;
    private JScrollPane sp;
    DefaultTableModel model;
    private Student student;
    String data [][];





    public InsertStudent(Student stud, Container contentPane, String actionName){
        this.contentPane = contentPane;
        studentNoLabel = new JLabel("Student No");
       firstnameLabel = new JLabel("Firstname");
       lastnameLabel = new JLabel("Lastname");
       emailLabel = new JLabel("Email");

       studentNoText = new JTextField(20);
       firstnameText = new JTextField(20);
       lastnameText = new JTextField(20);
       emailText = new JTextField(20);

       submitButton = new JButton("Submit");
       resetButton = new JButton("Reset");
       cancelButton = new JButton("Cancel");
       updateButton = new JButton("Update");
       deleteButton = new JButton("Delete");


           student = stud;
           if(student!=null){
              studentNoText.disable();

       }
        if(stud ==null) {
            submitButton = new JButton(actionName);
            tablePanel = new JPanel();
            tablePanel.setLayout(null);
            Border bline = BorderFactory.createTitledBorder("Added Students");
            tablePanel.setBorder(bline);


            data = getAllStudents();

            String column[] = {"Student ID", "Firstname", "LastName", "Email"};
            jTable = new JTable();
            jTable.setAutoCreateRowSorter(true);
            model = new DefaultTableModel(data, column);
            jTable.setModel(model);

            jTable.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int selectedRow = jTable.getSelectedRow();
                    Student selectedStudent = new Student();
                    selectedStudent.setStudentNo(Integer.parseInt(model.getValueAt(selectedRow, 0).toString()));
                    selectedStudent.setFirstname(model.getValueAt(selectedRow, 1).toString());
                    selectedStudent.setLastname(model.getValueAt(selectedRow, 2).toString());
                    selectedStudent.setEmail(model.getValueAt(selectedRow, 3).toString());


                    InsertStudent insertStudent = new InsertStudent(selectedStudent, contentPane, "update");
                    insertStudent.getStudentNoText().setText("" + selectedStudent.getStudentNo());
                    insertStudent.getFirstnameText().setText(selectedStudent.getFirstname());
                    insertStudent.getLastnameText().setText(selectedStudent.getLastname());
                    insertStudent.getEmailText().setText(selectedStudent.getEmail());

                    insertStudent.arrangeComponents();
                    contentPane.removeAll();
                    contentPane.add(insertStudent);
                    contentPane.invalidate();
                    contentPane.validate();
                    contentPane.repaint();
                    setVisible(true);

                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            submitButton.setBounds(220, 240, 80, 25);
            this.add(resetButton);
            sp = new JScrollPane(jTable);
            sp.setBounds(20, 40, 560, 100);

            tablePanel.add(sp);
            tablePanel.setBounds(10, 300, 600, 160);
            this.add(tablePanel);
            //this.setVisible(true);


        }else {
            if(actionName.equalsIgnoreCase("update")){
                updateButton = new JButton("Update");
                cancelButton.setBounds(100,240,80,25);
                updateButton.setBounds(220,240,80,25);
                deleteButton.setBounds(340,240,80,25);
                this.add(deleteButton);
                this.add(cancelButton);
                this.add(updateButton);
            }else if(actionName.equalsIgnoreCase("delete")){
                submitButton = new JButton("Delete");
            }

            student = new Student();
        }

    }

    public void arrangeComponents(){

        studentNoLabel.setBounds(100,100,100,25);
        studentNoText.setBounds(220,100,100,25);
        firstnameLabel.setBounds(100,135,100,25);
        firstnameText.setBounds(220,135,100,25);
        lastnameLabel.setBounds(100,170,100,25);
        lastnameText.setBounds(220,170,100,25);
        emailLabel.setBounds(100,205,100,25);
        emailText.setBounds(220,205,100,25);
        resetButton.setBounds(100,240,80,25);
       updateButton.setBounds(220,240,80,25);



        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                studentNoText.setText("");
                firstnameText.setText("");
                lastnameText.setText("");
                emailText.setText("");


            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Student student = new Student();
                student.setStudentNo(Integer.parseInt(studentNoText.getText()));
                studentNoText.setText("");
                student.setEmail(emailText.getText());
                emailText.setText("");
                student.setFirstname(firstnameText.getText());
                firstnameText.setText("");
                student.setLastname(lastnameText.getText());
                lastnameText.setText("");
                StudentService studentService =  new StudentServiceImpl();
              studentService.ssSaveStudent(student);

                InsertStudent  insertStudent = new InsertStudent (null,contentPane,"Submit");
                insertStudent.arrangeComponents();
                contentPane.removeAll();
                contentPane.add(insertStudent);

                setVisible(true);
                contentPane.invalidate();
                contentPane.validate();
                contentPane.repaint();
                JOptionPane.showMessageDialog(contentPane,"Record added successfully!!!!!!!!");

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertStudent insertStudent =new InsertStudent(null,contentPane,"Submit");
                insertStudent.arrangeComponents();
                contentPane.removeAll();
                contentPane.add(insertStudent);

                setVisible(true);
                contentPane.invalidate();
                contentPane.validate();
                contentPane.repaint();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setStudentNo(Integer.parseInt(studentNoText.getText()));
                studentNoText.setText("");
                student.setEmail(emailText.getText());
                emailText.setText("");
                student.setFirstname(firstnameText.getText());
                firstnameText.setText("");
                student.setLastname(lastnameText.getText());
                lastnameText.setText("");
                StudentService studentService =  new StudentServiceImpl();
                studentService.ssUpdateStudent(student);



                InsertStudent  insertStudent = new InsertStudent (null,contentPane,"Submit");
                insertStudent.arrangeComponents();
                contentPane.removeAll();
                contentPane.add(insertStudent);

                setVisible(true);
                contentPane.invalidate();
                contentPane.validate();
                contentPane.repaint();
                JOptionPane.showMessageDialog(contentPane,"Record updated successfully!!!!!!!!");

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reply = JOptionPane.showConfirmDialog(contentPane,"Do you want to delete this record?","Delete record",JOptionPane.YES_NO_OPTION);
                if(reply==JOptionPane.YES_OPTION){
                    StudentService studentService = new StudentServiceImpl();
                  studentService.ssDeleteStudentByNo(Integer.parseInt(studentNoText.getText()));

                    InsertStudent insertStudent = new InsertStudent(null,contentPane,"Submit");
                   insertStudent.arrangeComponents();
                    contentPane.removeAll();
                    contentPane.add(insertStudent);

                    setVisible(true);
                    contentPane.invalidate();
                    contentPane.validate();
                    contentPane.repaint();
                    JOptionPane.showMessageDialog(contentPane,"Record deleted successfully!!!!!!!!");
                }
            }
        });

        this.setLayout(null);
        Border borderline = BorderFactory.createTitledBorder("Insert Student Details");
        this.setBorder(borderline);
        this.setBounds(50,50,400,50);
        this.add(studentNoLabel);
        this.add(firstnameLabel);
        this.add(lastnameLabel);
        this.add(emailLabel);

        this.add(studentNoText);
        this.add(firstnameText);
        this.add(lastnameText);
        this.add(emailText);


        this.add(submitButton);

        this.setVisible(true);

    }

    private String [][] getAllStudents(){

        StudentService studentService = new StudentServiceImpl();
        List<Student> student = studentService.getAllStudents();
        data = new String[student.size()] [4];

        int i=0;
        for(Student stud : student){
            data[i][0] = ""+stud.getStudentNo();
            data[i][1] = stud.getFirstname();
            data[i][2] = stud.getLastname();
            data[i][3] = stud.getEmail();
            i++;
        }

        return data;
    }

    public JTextField getStudentNoText() {
        return studentNoText;
    }

    public void setStudentNoText(JTextField studentNoText) {
        this.studentNoText = studentNoText;
    }

    public JTextField getFirstnameText() {
        return firstnameText;
    }

    public void setFirstnameText(JTextField firstnameText) {
        this.firstnameText = firstnameText;
    }

    public JTextField getLastnameText() {
        return lastnameText;
    }

    public void setLastnameText(JTextField lastnameText) {
        this.lastnameText = lastnameText;
    }

    public JTextField getEmailText() {
        return emailText;
    }

    public void setEmailText(JTextField emailText) {
        this.emailText = emailText;
    }
}
