package za.studentRegistrationCRUD.ui;

import za.studentRegistrationCRUD.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLandingPage extends JFrame {

    JMenuBar menuBar;
    Container contentPane;
    Student student;

    public MyLandingPage(){
        super("Student Services");
        contentPane = this.getContentPane();
        this.setSize(1300,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arrangeComponents();
        this.setVisible(true);
    }

    public MyLandingPage(Student student){

        super("Student Services");
        this.student = student;
        contentPane = this.getContentPane();
        this.setSize(1300,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arrangeComponents();
        this.setVisible(true);


    }

    public void arrangeComponents(){

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu options = new JMenu("student services ");
        JMenu reports = new JMenu("Student reports");
        JMenu sites = new JMenu("Student sites");
        menuBar.add(options);
        menuBar.add(reports);
        menuBar.add(sites);

        JMenuItem insertStudent = new JMenuItem("Insert Student");
        options.add(insertStudent);
        insertStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertStudent insertStudent = new InsertStudent(null,contentPane,"Submit");
                insertStudent.arrangeComponents();

                contentPane.removeAll();
                contentPane.add(insertStudent);
                contentPane.validate();
                contentPane.invalidate();
                contentPane.repaint();
                contentPane.setVisible(true);



            }
        });
        JMenuItem searchStudent = new JMenuItem("Search Student");
        options.add(searchStudent);
        JMenuItem exit          = new JMenuItem("Exit");
        options.add(exit);
       exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}

