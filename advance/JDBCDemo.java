package advance;

import java.sql.*;

public abstract class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        simpleTest();
    }

    private static void simpleTest() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlAddr = "127.0.0.1:10336";
        String sqlUser = "root";
        String sqlPasswd = "root";
        String sqlDB = "test";
        String sqlURL = "jdbc:mysql://" + sqlAddr + "/" + sqlDB;
        try (Connection conn = DriverManager.getConnection(sqlURL, sqlUser, sqlPasswd);
                Statement state = conn.createStatement();
                ResultSet result = state.executeQuery("select * from test");) {
            while (result.next()) {
                System.out.println("---");
                System.out.println("id: " + result.getInt("Id"));
                System.out.println("name: " + result.getString("Name"));
            }
            System.out.println("********");
            System.out.println(state.executeUpdate("INSERT INTO test value (3, \"ljj\")"));
            while (result.next()) {
                System.out.println("---");
                System.out.println("id: " + result.getInt("Id"));
                System.out.println("name: " + result.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
