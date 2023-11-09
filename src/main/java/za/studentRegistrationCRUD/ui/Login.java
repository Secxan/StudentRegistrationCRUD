package za.studentRegistrationCRUD.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    JLabel usernameLabel;
    JLabel passwordLabel;

    JTextField usernameText;
    JPasswordField passwordText;

    JButton resetButton;
    JButton submitButton;

    JPanel panel;

    public Login(){

        this.setSize(1300,800);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");

        usernameText = new JTextField(20);
        passwordText = new JPasswordField(20);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameText.setText("");
                passwordText.setText("");
            }
        });
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usernameText.getText().equals("lesedi")&& passwordText.getText().equals("pass"))
                    dispose();
                else
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
            }
        });

        panel = new JPanel();



    }

    public void arrangeComponents(){
        panel.setLayout(null);
        Border borderline = BorderFactory.createTitledBorder("Login");
        panel.setBorder(borderline);
        panel.setVisible(true);

        usernameLabel.setBounds(50,50,100,25);
        passwordLabel.setBounds(50,85,100,25);

        usernameText.setBounds(120,50,100,25);
        passwordText.setBounds(120,85,100,25);

        resetButton.setBounds(50,120,80,25);
        submitButton.setBounds(140,120,80,25);

        panel.setBounds(450,250,300,200);

        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(usernameText);
        panel.add(passwordText);
        panel.add(resetButton);
        panel.add(submitButton);
        this.add(panel);
        this.setVisible(true);

    }

}
