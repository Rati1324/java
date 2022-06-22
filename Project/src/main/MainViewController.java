package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class MainViewController {
    public TableColumn<PhoneModel, Integer> idCol;
    public TableColumn<PhoneModel, Integer> ramCol;
    public TableColumn<PhoneModel, Integer> storageCol;
    public TableColumn<PhoneModel, Integer> cpuCol;
    public TableColumn<PhoneModel, Date> dateCol;
    public TableColumn<PhoneModel, String> nameCol;
    public TableView<PhoneModel> phoneTable;
    public Button insertBtn;
    public Button cancelUpdate;
    @FXML
    private TextField nameInput;
    @FXML
    private DatePicker dateInput;
    @FXML
    private TextField cpuInput;
    @FXML
    private TextField ramInput;
    @FXML
    private TextField storageInput;
    public boolean insertNotUpdate = true;
    public int phoneId;
    DB db = new DB();

    public void initialize() {
        idCol.setVisible(false);
    }
    public void importClick() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("phoneName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        cpuCol.setCellValueFactory(new PropertyValueFactory<>("CPU"));
        ramCol.setCellValueFactory(new PropertyValueFactory<>("RAM"));
        storageCol.setCellValueFactory(new PropertyValueFactory<>("storage"));

        var phones = db.select();
        phoneTable.setItems(phones);
    }

    public void insertClick() throws SQLException {
        if (insertNotUpdate) {
            db.insert(nameInput.getText(), String.valueOf(Date.valueOf(dateInput.getValue())), cpuInput.getText(), Integer.parseInt(ramInput.getText()), Integer.parseInt(storageInput.getText()));
        }
        else {
            db.update(phoneId, nameInput.getText(), String.valueOf(Date.valueOf(dateInput.getValue())), cpuInput.getText(), Integer.parseInt(ramInput.getText()), Integer.parseInt(storageInput.getText()));
            insertNotUpdate = true;
        }
        importClick();
    }

    public void fill() {
        insertBtn.setText("Save");
        PhoneModel selectedPhone = phoneTable.getSelectionModel().getSelectedItem();
        phoneId = selectedPhone.id;

        nameInput.setText(selectedPhone.getPhoneName());
        dateInput.setValue(LocalDate.parse(selectedPhone.getReleaseDate()));
        cpuInput.setText(selectedPhone.getCPU());
        ramInput.setText(String.valueOf(selectedPhone.getRAM()));
        storageInput.setText(String.valueOf(selectedPhone.getStorage()));
        insertNotUpdate = false;
    }
    public void clear() {
        insertBtn.setText("Insert");
        nameInput.clear();
        dateInput.getEditor().clear();
        cpuInput.clear();
        ramInput.clear();
        storageInput.clear();
        insertNotUpdate = false;
    }

    public void delete() throws SQLException {
        phoneId = phoneTable.getSelectionModel().getSelectedItem().getId();
        db.delete(phoneId);
        importClick();
    }
}
