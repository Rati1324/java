package task3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.text.TableView;
import java.sql.*;
import java.time.LocalTime;

public class DB {
    private Connection con;
    public DB() {
        String url = "jdbc:mysql://localhost:3306/Temp";
        try {
            con = DriverManager.getConnection(url, "rati", "123456");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String productName, Date date, int quantity) throws SQLException {
        try {
            Statement st = con.createStatement();
            PreparedStatement prep = con.prepareStatement("INSERT INTO Product(productName, expirationDate, quantity) VALUES (?,?,?)");
            prep.setString(1, productName);

            java.sql.Date D = new java.sql.Date(date.getTime());
            prep.setDate(2, date);
            prep.setInt(3, quantity);
            prep.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ObservableList<Product> select() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM Product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            products = getProductObjects(rs);
            return products;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // with OOP
    public void insert(Product p) throws SQLException {
        Statement st = con.createStatement();
        PreparedStatement prepst = con.prepareStatement("INSERT INTO product(productName, expirationDate, quantity) VALUES (?,?,?)");
        prepst.setString(2, p.getExpirationDate());
        prepst.setInt(3, p.getQuantity());
        prepst.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement prepSt = con.prepareStatement("DELETE FROM Product WHERE id=?");
        prepSt.setInt(1, id);
        prepSt.executeUpdate();
    }

    public ObservableList<Product> getProductObjects(ResultSet rs) throws SQLException {
        ObservableList<Product> pList = FXCollections.observableArrayList();
        while (rs.next()) {
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setProductName(rs.getString("productName"));
            p.setExpirationDate(rs.getString("expirationDate"));
            p.setQuantity(rs.getInt("quantity"));
            pList.add(p);
        }
        return pList;
    }
}
