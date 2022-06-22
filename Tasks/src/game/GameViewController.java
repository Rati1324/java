package game;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;
import java.util.Random;

public class GameViewController {


    public Label label1;
    public Label curScore;
    public Label money;
    public Button play1;
    @javafx.fxml.FXML
    private Label label18;
    @javafx.fxml.FXML
    private Label label17;
    @javafx.fxml.FXML
    private Label label16;
    @javafx.fxml.FXML
    private Label label15;
    @javafx.fxml.FXML
    private Label label19;
    @javafx.fxml.FXML
    private Label label10;
    @javafx.fxml.FXML
    private Label label20;
    @javafx.fxml.FXML
    private Label label14;
    @javafx.fxml.FXML
    private Label label13;
    @javafx.fxml.FXML
    private Label label2;
    @javafx.fxml.FXML
    private Label label12;
    @javafx.fxml.FXML
    private Label label3;
    @javafx.fxml.FXML
    private Label label11;
    @javafx.fxml.FXML
    private Label label4;
    @javafx.fxml.FXML
    private Label label5;
    @javafx.fxml.FXML
    private Label label6;
    @javafx.fxml.FXML
    private Label label7;
    @javafx.fxml.FXML
    private Label label8;
    @javafx.fxml.FXML
    private Label label9;

    public Label[] labels;
    public int userMoney = 100;
    public int score;

    public void initialize() {
        labels = new Label[]{
                label1, label2, label3, label4,
                label5, label6, label7, label8,
                label9, label10, label11, label12,
                label13, label14, label15, label16,
                label17, label18, label19, label20,
        };
        money.setText("100");
    }
    public void play() {
        Random rn = new Random();
        int curRand;
        for (int i = 0; i < 20; i++) {
            curRand = rn.nextInt(0, 9);
            labels[i].setText(String.valueOf(curRand));
            score += curRand;
        }
        if (score > 100) {
            userMoney += 5;
        }
        else {
            userMoney -= 10;
        }
        curScore.setText(String.valueOf(score));
        money.setText(money.getText() + " " + userMoney);
    }
}
