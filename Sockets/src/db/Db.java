package db;

import java.sql.*;

public class Db {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/temp";
        try {
            Connection conn = DriverManager.getConnection(url, "rati", "123456");
            PreparedStatement prepSt = conn.prepareStatement("insert into person (f_name, l_name, p_number) VALUES(?,?,?)");
            prepSt.setString(1, "john");
            prepSt.setString(2, "johnson");
            prepSt.setString(3, "2324204");
            int rs = prepSt.executeUpdate();
            //while (rs.next()) {
            //    String name = rs.getString("f_name");
            //    System.out.println(name);
            //}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
