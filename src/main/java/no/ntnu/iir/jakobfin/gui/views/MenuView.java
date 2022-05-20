package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuView {

    private Scene scene;

    public MenuView(Stage stage){

        AnchorPane rootNode = new AnchorPane();

        Button manageArmies = new Button("Arrange fleets");
        Button importArmies = new Button("Import");
        Button simulateMenu = new Button("Ready the chase guns");

        Label title = new Label("Main Title");
        rootNode.getChildren().add(title);

        scene = new Scene(rootNode,800,800);
        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene(){
        return this.scene;
    }
}

