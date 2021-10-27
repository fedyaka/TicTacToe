import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("view/mainScene.fxml");
        loader.setLocation(xmlUrl);
        Parent parent = loader.load();

        Scene scene = new Scene(parent);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}