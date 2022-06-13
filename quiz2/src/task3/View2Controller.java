package task3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public class View2Controller {
    @FXML
    public Button delete;
    @FXML
    public Button edit;
    private DB db = new DB();
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, String> productNameCol;
    @FXML
    private TableColumn<Product, Integer> quantityCol;
    @FXML
    private TableColumn<Product, Date> expirationDateCol;

    ObservableList<Product> Products = FXCollections.observableArrayList();

    public void initialize() {
        productNameCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        expirationDateCol.setCellValueFactory(new PropertyValueFactory<>("expirationDate"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        Products = db.select();
        productsTable.setItems(Products);
    }

    public void deleteBtn(ActionEvent actionEvent) {
        try {
            db.delete(productsTable.getSelectionModel().getSelectedItem().getId());
            initialize();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editBtn(ActionEvent actionEvent) throws IOException {
        Product product = productsTable.getSelectionModel().getSelectedItem();
//        LocalDate d = product.getExpirationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
        Parent parent = (Parent)loader.load();
        ViewController controller = loader.<ViewController>getController();
        controller.fill(product);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}