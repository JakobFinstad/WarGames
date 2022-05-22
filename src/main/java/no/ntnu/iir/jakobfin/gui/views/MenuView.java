package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;

public class MenuView {

    private Scene scene;

    public MenuView(Stage stage){

        AnchorPane rootNode = new AnchorPane();
        SceneChanger sceneChanger = new SceneChanger(stage);


        Label title = new Label("Main Title");
        Button manageArmies = new Button("Arrange fleets");
        Button importArmies = new Button("Import");
        Button simulateMenu = new Button("Ready the chase guns");
        HBox buttonBox = new HBox();

        simulateMenu.setOnAction(actionEvent ->sceneChanger.goToSimulationMenu(stage));
        manageArmies.setOnAction(actionEvent -> sceneChanger.goToManageArmies(stage));


        buttonBox.getChildren().add(manageArmies);
        buttonBox.getChildren().add(importArmies);
        buttonBox.getChildren().add(simulateMenu);



        rootNode.getChildren().add(title);
        rootNode.getChildren().add(buttonBox);



        scene = new Scene(rootNode,800,800);
        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene(){
        return this.scene;
    }
}

