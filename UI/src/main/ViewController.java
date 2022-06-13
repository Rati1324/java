package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class ViewController {
    @javafx.fxml.FXML
    private Button c1r1;
    @javafx.fxml.FXML
    private Button c1r3;
    @javafx.fxml.FXML
    private Button c2r2;
    @javafx.fxml.FXML
    private Button c3r1;
    @javafx.fxml.FXML
    private Button c1r2;
    @javafx.fxml.FXML
    private Button c2r1;
    @javafx.fxml.FXML
    private Button c3r3;
    @javafx.fxml.FXML
    private Button c2r3;
    @javafx.fxml.FXML
    private Button c3r2;
    @FXML
    private Label turnMessage;
    private String turn = "X";
    private String message;
    private String winner = "";
    private Button[][] buttons = new Button[3][3];
    @FXML
    public void initialize() {
         buttons[0][0] = c1r1;
         buttons[0][1] = c1r2;
         buttons[0][2] = c1r3;
         buttons[1][0] = c2r1;
         buttons[1][1] = c2r2;
         buttons[1][2] = c2r3;
         buttons[2][0] = c3r1;
         buttons[2][1] = c3r2;
         buttons[2][2] = c3r3;
    }
    public void handleClick(ActionEvent e) {
        Button btn = (Button) e.getSource();
        if (winner.isEmpty()) {
            if (Objects.equals(btn.getText(), "")) {
                btn.setText(turn);
                if (checkForWinner()) {
                    winner = turn;
                    message = "Winner: " + turn;
                }
                turnMessage.setText(message);
            }
        }
    }

    public boolean checkForWinner() {
        int x[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int o[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] curPlayer = (Objects.equals(turn, "X")) ? x : o;

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (!buttons[i][j].getText().isEmpty()) {
                    if (Objects.equals(buttons[i][j].getText(), turn)) {
                        curPlayer[i] += 1;
                        curPlayer[j + 3] += 1;
                        if (i == j) {
                            curPlayer[6] += 1;
                        }
                        if (i == 2 - j) {
                            curPlayer[7] += 1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 3) {
                return true;
            }
            else if (o[i] == 3) {
                return true;
            }
        }
        turn = (Objects.equals(turn, "X")) ? "O" : "X";
        message = "Next turn: " + turn;
        return false;
    }
}