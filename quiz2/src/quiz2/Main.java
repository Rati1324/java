package quiz2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws IOException {
        Parent p = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Task1View.fxml")));
        Scene s = new Scene(p);
        stage.setScene(s);
        stage.show();
    }
}
