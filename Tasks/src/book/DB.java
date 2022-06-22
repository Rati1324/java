package book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DB {
    private Connection con;
    public DB() {
        String url = "jdbc:mysql://localhost:3306/library";
        try {
            con = DriverManager.getConnection(url, "rati", "123456");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(BookModel b) throws SQLException {
        Statement st = con.createStatement();
        PreparedStatement prepst = con.prepareStatement("INSERT INTO book(name, author, releaseDate, price) VALUES (?,?,?,?,?)");
        prepst.setString(2, b.getBookName());
        prepst.setString(3, b.getAuthorName());
        prepst.setString(3, b.getReleaseDate());
        prepst.setFloat(3, b.getPrice());
        prepst.executeUpdate();
    }
    public ObservableList<BookModel> select() {
        ObservableList<BookModel> output = null;
        try {
            String query = "SELECT * FROM book";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            output = getBookObjects(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public ObservableList<BookModel> getBookObjects(ResultSet rs) throws SQLException {
        ObservableList<BookModel> pList = FXCollections.observableArrayList();
        while (rs.next()) {
            BookModel p = new BookModel();
            p.setId(rs.getInt("id"));
            p.setBookName(rs.getString("name"));
            p.setAuthorName(rs.getString("author"));
            p.setReleaseDate(rs.getString("releaseDate"));
            p.setPrice(rs.getFloat("price"));
            pList.add(p);
        }
        return pList;
    }
}
