package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import object.Person;

public class RegistrationPlayerSceneController {
    private static ArrayList<Person> personList = new ArrayList<Person>();

    public static ArrayList<Person> getPersonList() {
        return personList;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label errorLabel1;

    @FXML
    private Label errorLabel2;

    @FXML
    private URL location;

    @FXML
    private TextField firstTextField;

    @FXML
    private TextField secondTextField;

    @FXML
    private Button back;

    @FXML
    private Button play;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("../view/mainScene.fxml");
        loader.setLocation(xmlUrl);
        Parent parent = loader.load();
        Stage primaryStage =(Stage) back.getScene().getWindow();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    @FXML
    void playAction(ActionEvent event) throws IOException{
        if (firstTextField.getText() ==  "" || secondTextField.getText() == ""){
            return;
        }
        personList.add(new Person(firstTextField.getText(), Color.AQUA, "O"));
        personList.add(new Person(secondTextField.getText(), Color.web("#ff5757"), "X"));
        Collections.shuffle(personList);

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("../view/gameScene.fxml");
        loader.setLocation(xmlUrl);
        Parent parent = loader.load();
        Stage primaryStage = (Stage) play.getScene().getWindow();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();

    }

    @FXML
    void initialize() {

    }

}
