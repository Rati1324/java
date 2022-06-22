package book;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class InsertViewController {

    @javafx.fxml.FXML
    private TextField priceInput;
    @javafx.fxml.FXML
    private TextField authorInput;
    @javafx.fxml.FXML
    private TextField nameInput;
    @javafx.fxml.FXML
    private DatePicker dateInput;
    public DB db = new DB();
    public void onInsertClick() throws SQLException {
        BookModel b = new BookModel();
        b.setBookName(nameInput.getText());
        b.setAuthorName(authorInput.getText());
        b.setReleaseDate(String.valueOf(Date.valueOf(dateInput.getValue())));
        b.setPrice(Float.valueOf(priceInput.getText()));
        db.insert(b);
    }
}
