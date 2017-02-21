/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maturitniprace_jaros;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Míča
 */
public class MainWindow {

    double height = AccessWindow.height * 1.8; //beru rozměry z AccessWindow a přiřřazuji si je
    double width = AccessWindow.width * 2;
    Stage primaryStage;

    GridPane grid2 = new GridPane();
    Scene scene2 = new Scene(grid2, width, height);

    private String nepřeloženýText;
    protected Button btn = new Button("Přeložit");
    protected TextField textf = new TextField(); //zobrazuje text
    protected TextArea texta = new TextArea(); //umožňuje vepsání textu
    protected Text scenetitle2 = new Text("Kdo hledá najde");
    protected ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("Obrácená", "Pozadu", "Číslice")); //chicebox

    public MainWindow(Stage primaryStage) {
        this.primaryStage = primaryStage;  //přidám si zděděnou informaci do Stage nahoře 
    }    //konstruktor

    public void init() { //metoda, která vše zařizuje 

        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(5); //nastaví horizontální mezery mezi prvky
        grid2.setVgap(5); //nastaví vertikální mezery mezi prvky

        primaryStage.setX(Screen.getPrimary().getVisualBounds().getWidth() / 2 - width / 2); //umístí druhé okno na prostředek
        primaryStage.setY(Screen.getPrimary().getVisualBounds().getHeight() / 2 - height / 2);

        nepřeloženýText = textf.getText();

        final ImageView iv3 = new ImageView(new Image("file:img/ENIGMA.png"));
        iv3.setFitHeight(95);
        iv3.setFitWidth(350);
        grid2.add(iv3, 2, 0);

        cb.setTooltip(new Tooltip("Vyberte si šifru")); //nápověda choiceboxu
        cb.setMinWidth(175); //rozměry choiceboxu
        cb.setMinHeight(42);
        grid2.add(cb, 1, 2);

        scenetitle2.setFont(Font.font("Georgia", FontWeight.MEDIUM, 30)); //font textu
        grid2.add(scenetitle2, 1, 1);

        btn.setPrefSize(200, 150);
        grid2.add(btn, 1, 3);    //sloupek, řádek, kolik sloupků zabere, kolik řádků zabere

        texta.setMinSize(360, 210); //šířka/výška
        grid2.add(texta, 3, 3); //sloupek, řádek, kolik sloupků zabere, kolik řádků zabere  

        textf.setMinSize(300, 50); //šíře, výška
        grid2.add(textf, 3, 2);   //    BERU SI ODSUD TEXT!!!

    }

    public GridPane getGrid2() {
        return grid2;
    }

    public Scene getScene2() {
        return scene2;
    }
}
