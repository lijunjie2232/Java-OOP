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
        try (Connection conn = DriverManager.getConnection(sqlURL, sqlUser, sqlPasswd);) {
            Statement state = conn.createStatement();
            ResultSet result = state.executeQuery("select Id,Name from test");
            while (result.next()) {
                System.out.println("---");
                System.out.println("id: " + result.getInt("Id"));
                System.out.println("name: " + result.getString("Name"));
            }
            if (result != null)
                result.close();
            System.out.println("********");
            PreparedStatement pstate = conn.prepareStatement("INSERT INTO test value (?, ?)");
            pstate.setInt(1, 5);
            pstate.setString(2, "ljj");
            System.out.println(pstate.executeUpdate());
            result = state.executeQuery("select * from test");
            while (result.next()) {
                System.out.println("---");
                System.out.println("id: " + result.getInt("Id"));
                System.out.println("name: " + result.getString("Name"));
            }
            if (result != null)
                result.close();
            if (state != null)
                state.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
