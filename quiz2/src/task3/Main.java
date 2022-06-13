package task3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }
    public void start(Stage stage) throws IOException, SQLException {
        // need to pass arguments to the constructor somehow, this doesnt work
//        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("View.fxml")));
//        Scene s = new Scene(parent);
//        stage.setScene(s);
//        stage.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
