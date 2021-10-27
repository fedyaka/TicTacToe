package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit;

    @FXML
    private Button play;

    @FXML
    void exitAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void playAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("../view/registrationPlayerScene.fxml");
        loader.setLocation(xmlUrl);
        Parent parent = loader.load();
        Stage primaryStage =(Stage) play.getScene().getWindow();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }

    @FXML
    void initialize() {

    }

}
