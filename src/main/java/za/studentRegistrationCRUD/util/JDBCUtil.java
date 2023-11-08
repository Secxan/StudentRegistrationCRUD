package za.studentRegistrationCRUD.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCUtil {
    public JDBCUtil() {
    }
    public Statement getStatement(){
        Statement statement =null;
        try {
            Class.forName("org.postgresql.Driver");  // declare database you are going to connect to
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesedi_lessons",
                    "postgres","admin");

            statement=connection.createStatement();

        }catch(Exception e)  {
            e.printStackTrace();
        }


        return statement;
    }

}
