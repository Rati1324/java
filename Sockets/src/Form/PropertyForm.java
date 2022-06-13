package Form;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PropertyForm extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent p = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InputForm.fxml")));
        Scene s = new Scene(p);
        stage.setScene(s);
        stage.show();
    }
}
