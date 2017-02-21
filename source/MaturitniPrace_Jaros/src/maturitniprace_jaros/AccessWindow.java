/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maturitniprace_jaros;

import java.io.File;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Míča
 */
public class AccessWindow extends Application {

    static double height = 350;
    static double width = 470;
    final String password = ("admin");   //Kpt. Krutor
    protected String musicFile = "sounds/sound.mp3";
    protected String musicFail = "sounds/fail.mp3";

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Enigma 1.0"); //nastaví název okana
        GridPane grid = new GridPane(); //mřížka
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //nastaví horizontální mezery mezi prvky
        grid.setVgap(30); //nastaví vertikální mezery mezi prvky

        Scene scene = new Scene(grid, width, height);

        ColumnConstraints col1Constraints = new ColumnConstraints();
        col1Constraints.setPercentWidth(40);
        ColumnConstraints col2Constraints = new ColumnConstraints();
        col2Constraints.setPercentWidth(40);
        grid.getColumnConstraints().addAll(col1Constraints, col2Constraints);

        Text scenetitle = new Text("    Zadejte přístupové heslo");
        scenetitle.setFont(Font.font("Georgia", FontWeight.MEDIUM, 29));
        grid.add(scenetitle, 0, 0, 2, 1); //sloupec/řádek, kolik zabere spoupců(řádků

        PasswordField pwBox = new PasswordField();
        pwBox.setPrefSize(400, 35);
        grid.add(pwBox, 0, 2, 2, 1);

        Button btn = new Button("Potvrdit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);//pozice
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 4); //první horizontální sloupek, druhý vertikální

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                String input = pwBox.getText(); //načte zadaný text do pwboxu
                if (input.equals(password)) {
                   // PauseTransition delay = new PauseTransition(Duration.seconds(1)); //časová prodleva
                    MainWindow x = new MainWindow(primaryStage); // vytváření konkrétní instance
                    //delay.setOnFinished(event -> primaryStage.setScene(x.getScene2()));
                    //delay.play();
                    primaryStage.setScene(x.getScene2());
                    x.init();

                    Media sound = new Media(new File(musicFile).toURI().toString()); //hudba
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();

                } else {
                    actiontarget.setText("Špatně!");
                    actiontarget.setFill(Color.RED);
                    actiontarget.setFont(Font.font("Georgia", FontWeight.MEDIUM, 29));
                    Media sound = new Media(new File(musicFail).toURI().toString()); //hudba
                    MediaPlayer mediaPlayer = new MediaPlayer(sound);
                    mediaPlayer.play();
                }
            }
        });

        scene.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
            if (ev.getCode() == KeyCode.ENTER) {
                btn.fire();
                ev.consume();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

/**
 * @param args the command line arguments
 */
