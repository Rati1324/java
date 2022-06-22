package book;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class MainPageController {
    @FXML
    public Button importBtn;
    public TableView booksTable;
    @FXML
    public TableColumn<BookModel, String> nameCol;
    @FXML
    public TableColumn<BookModel, Integer> authorCol;
    @FXML
    public TableColumn<BookModel, Date> releaseDateCol;
    @FXML
    public TableColumn<BookModel, Float> priceCol;

    private DB db = new DB();

    public void initialize() {
    }
    public void onImportClick() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        releaseDateCol.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        var books = db.select();
        booksTable.setItems(books);
    }

}
