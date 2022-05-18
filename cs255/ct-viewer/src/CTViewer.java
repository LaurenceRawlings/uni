import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * SMain class to run the application.
 *
 * @author Laurence Rawlings (991368)
 * Declaration: I declare that this is my own code.
 */
public class CTViewer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("CT Viewer");
        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("view/Main.fxml"));
        Parent root = loader.load();

        MainController main = loader.getController();
        main.onLoad();
        main.setStage(primaryStage);
        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
