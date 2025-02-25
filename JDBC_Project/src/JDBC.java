import java.sql.*;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Sapna@2003_4";

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            insertStudent(conn, 1, "John Doe", 22);
            updateStudent(conn, 1, "John Smith", 23);
            deleteStudent(conn, 1);
            retrieveStudents(conn);
            callEmployeeProcedure(conn, 101);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted successfully.");
        }
    }

    private static void updateStudent(Connection conn, int id, String name, int age) throws SQLException {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Student updated successfully.");
        }
    }

    private static void deleteStudent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Student deleted successfully.");
        }
    }

    private static void retrieveStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
        }
    }

    private static void callEmployeeProcedure(Connection conn, int empId) throws SQLException {
        String sql = "CALL GetEmployeeDetails(?)";
        try (CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, empId);
            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Employee ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Department: " + rs.getString("department"));
                }
            }
        }
    }
}
