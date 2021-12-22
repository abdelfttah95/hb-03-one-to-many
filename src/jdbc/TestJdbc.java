package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author abdel
 */
public class TestJdbc {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to : " + url);
            Connection con = (Connection) DriverManager.getConnection(url,"root", "");
            
            System.out.println(con);
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
