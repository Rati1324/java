package task3;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public class ViewController {
    private DB db;
    public Button importBtn;
    @javafx.fxml.FXML
    private TextField nameInput;
    @javafx.fxml.FXML
    private DatePicker dateInput;
    @javafx.fxml.FXML
    private TextField quantityInput;
    @javafx.fxml.FXML
    private Button saveBtn;

    public ViewController() throws SQLException {
        this.db = new DB();
    }
    public void fill(Product p) {
        if (nameInput != null) {
            nameInput.setText(p.getProductName());
        }
        if (dateInput != null) {
            Date date = p.getExpirationDate();
//            LocalDate d = LocalDate.from(Instant.ofEpochMilli(date.getTime()));
            // NEED LOCALDATE FOR THIS
//            dateInput.setValue();
        }
        if (quantityInput != null) {
            quantityInput.setText(String.valueOf(p.getQuantity()));
        }
    }

    public void onClick() throws SQLException {
        db.insert(nameInput.getText(), Date.valueOf(dateInput.getValue()), Integer.parseInt(quantityInput.getText()));
    }

    public void onImportClick() throws IOException, SQLException {
        Parent p = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("View2.fxml")));
        Scene s = new Scene(p);
        Stage stage = new Stage();
        stage.setScene(s);
        stage.show();
    }
}
