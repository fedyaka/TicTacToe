package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import object.GameField;
import object.Person;

public class GameSceneController {
    GameField gameField = new GameField(3);
    ArrayList<Person> personList = RegistrationPlayerSceneController.getPersonList();
    boolean isGameEnd = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label player;

    @FXML
    private Label turn;

    @FXML
    private Button c1;

    @FXML
    private Button c2;

    @FXML
    private Button c3;

    @FXML
    private Button c4;

    @FXML
    private Button c5;

    @FXML
    private Button c6;

    @FXML
    private Button c7;

    @FXML
    private Button c8;

    @FXML
    private Button c9;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        personList.clear();
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("../view/mainScene.fxml");
        loader.setLocation(xmlUrl);
        Parent parent = loader.load();
        Stage primaryStage =(Stage) back.getScene().getWindow();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    @FXML
    void cellAction(ActionEvent event) {
        if (isGameEnd){
            return;
        }
        Button clickedButton = (Button) event.getSource();
        ObservableList<Node> buttons = gridPane.getChildren();
        if (sendCellValues(clickedButton, buttons) == true){
            clickedButton.setText(personList.get(0).getIcon());
            clickedButton.setTextFill(personList.get(0).getColor());
            changeText(personList.get(1));
            if (gameField.checkingWinner(personList.get(0).getIcon())){
                turn.setText("THE WINNER:");
                turn.setTextFill(Color.GREEN);
                player.setText(personList.get(0).getName());
                player.setTextFill(Color.GREEN);
                turn.setMinWidth(300);
                turn.setAlignment(Pos.CENTER);
                isGameEnd = true;
            }
            if (gameField.checkingDrawGame() && !isGameEnd){
                turn.setText("DRAW GAME");
                turn.setTextFill(Color.GREEN);
                player.setText("");
                turn.setMinWidth(300);
                turn.setAlignment(Pos.CENTER);
                isGameEnd = true;
            }
            Collections.reverse(personList);
        }

    }
    @FXML
    void initialize() {
        changeText(personList.get(0));
    }

    private void changeText (Person person){
        turn.setTextFill(person.getColor());
        player.setText(person.getName());
        player.setTextFill(person.getColor());
    }
    private boolean sendCellValues(Button clickedButton, ObservableList buttons){
        int k = 0;
        for (int i = 0; i < gameField.getSize(); i++){
            for (int j = 0; j < gameField.getSize(); j++){
                if(buttons.get(k).equals(clickedButton)){
                    return gameField.setCellValue(i, j, personList.get(0).getIcon());
                }
                k++;
            }
        }
        return false;
    }


}

