package quiz2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import task3.Product;

import java.sql.Date;
import java.util.Random;

public class Task1ViewController {
    ObservableList<String> languages = FXCollections.observableArrayList("English", "Georgian");
    @javafx.fxml.FXML
    private ComboBox languageChoice;
    @javafx.fxml.FXML
    private TextField output;
    @javafx.fxml.FXML
    private TextField numOfWords;
    @javafx.fxml.FXML
    private TextField numOfLetters;
    @javafx.fxml.FXML
    private Button generateText;
    public void initialize() {
        languageChoice.setItems(languages);
        languageChoice.setValue("Georgian");
    }
    public void generate() {
        String outputText = "";
        int numLetters = Integer.parseInt(numOfLetters.getText());
        int numWords = Integer.parseInt(numOfWords.getText());
        String[] letters = {"ქწერტყუიოპასდფგჰჯკლზხცვბნმ", "qwertyuiopasdfghjklzxcvbnm"};
        SingleSelectionModel sm = languageChoice.getSelectionModel();

        System.out.println(sm.getSelectedIndex());
        Random rn = new Random();
        for (int i = 0; i < numWords; i++) {
            for (int j = 0; j < numLetters; j++) {
                outputText += letters[sm.getSelectedIndex()].charAt(rn.nextInt(0, 25));
            }
            outputText += " ";
        }
        output.setText(outputText);
    }
}
