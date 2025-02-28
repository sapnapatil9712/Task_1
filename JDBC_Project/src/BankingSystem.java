import java.sql.*;

public class BankingSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/accounts";
    private static final String USER = "root";
    private static final String PASSWORD = "Sapna@2003_4";
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            try {
                performTransaction(conn, 1, 2, 500);
                conn.commit();
                System.out.println("Transaction committed successfully.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            }
            batchInsertAccounts(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void performTransaction(Connection conn, int fromAccount, int toAccount, double amount) throws SQLException {
        String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        
        try (PreparedStatement withdrawStmt = conn.prepareStatement(withdrawSQL);
             PreparedStatement depositStmt = conn.prepareStatement(depositSQL)) {
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, fromAccount);
            withdrawStmt.executeUpdate();
            
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, toAccount);
            depositStmt.executeUpdate();
        }
    }

    private static void batchInsertAccounts(Connection conn) throws SQLException {
        String sql = "INSERT INTO accounts (id, name, balance) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);
            
            pstmt.setInt(1, 101);
            pstmt.setString(2, "Alice");
            pstmt.setDouble(3, 5000);
            pstmt.addBatch();
            
            pstmt.setInt(1, 102);
            pstmt.setString(2, "Bob");
            pstmt.setDouble(3, 7000);
            pstmt.addBatch();
            
            pstmt.setInt(1, 103);
            pstmt.setString(2, "Charlie");
            pstmt.setDouble(3, 6000);
            pstmt.addBatch();
            
            pstmt.executeBatch();
            conn.commit();
            System.out.println("Batch insert completed successfully.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Batch insert rolled back due to error: " + e.getMessage());
        }
    }
}
