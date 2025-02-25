
import java.sql.*;

public class App {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "Sapna@2003_4";

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("JDBC Connected Successfully");

        // String sql = "create table users(id int primary key auto_increment,name varchar(100),email varchar(100))";
        String sql = "INSERT INTO users(name,email) VALUES ('sapna','patil@gmail.com')";

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
    
}
