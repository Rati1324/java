package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DB {
    private Connection con;
    private Statement st;
    public DB() {
        String url = "jdbc:mysql://localhost:3306/temp";
        try {
            con = DriverManager.getConnection(url, "rati", "123456");
            st = con.createStatement();
            System.out.println("asdasd");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(String phoneName, String releaseDate, String CPU, int RAM, int storage) throws SQLException {
        PreparedStatement prepst = con.prepareStatement("INSERT INTO smartphone(phoneName, releaseDate, CPU, RAM, storage) VALUES (?,?,?,?,?)");
        prepst.setString(1, phoneName);
        prepst.setString(2, releaseDate);
        prepst.setString(3, CPU);
        prepst.setInt(4, RAM);
        prepst.setInt(5, storage);
        prepst.executeUpdate();
    }
    public ObservableList<PhoneModel> select() {
        ObservableList<PhoneModel> output = null;
        try {
            String query = "SELECT * FROM smartphone";
            ResultSet rs = st.executeQuery(query);
            output = getBookObjects(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public void update(int id, String phoneName, String releaseDate, String CPU, int RAM, int storage) throws SQLException {
        PreparedStatement prepst = con.prepareStatement("UPDATE smartphone SET phoneName=?, releaseDate=?, CPU=?, RAM=?, storage=? WHERE id=?");

        prepst.setString(1, phoneName);
        prepst.setString(2, releaseDate);
        prepst.setString(3, CPU);
        prepst.setInt(4, RAM);
        prepst.setInt(5, storage);
        prepst.setInt(6, id);
        prepst.executeUpdate();
    }
    public void delete(int phoneId) throws SQLException {
        PreparedStatement prepSt = con.prepareStatement("DELETE FROM smartphone WHERE id=?");
        prepSt.setInt(1, phoneId);
        prepSt.executeUpdate();
    }
    public ObservableList<PhoneModel> getBookObjects(ResultSet rs) throws SQLException {
        ObservableList<PhoneModel> pList = FXCollections.observableArrayList();
        while (rs.next()) {
            PhoneModel p = new PhoneModel();
            p.setId(rs.getInt("id"));
            p.setPhoneName(rs.getString("phoneName"));
            p.setReleaseDate(rs.getString("releaseDate"));
            p.setCPU(rs.getString("CPU"));
            p.setRAM(rs.getInt("RAM"));
            p.setStorage(rs.getInt("storage"));
            pList.add(p);
        }
        return pList;
    }
}
