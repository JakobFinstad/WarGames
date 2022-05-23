package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.gui.controllers.ArmiesController;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;

/**
 * A class that represent the main menu of the game. It is designed for easy navigating between the options of this
 * application.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class MenuView {

    private Scene scene;
    private ArmiesController armiesController;

    /**
     * Generate the menu page, with all it's displays.
     *
     * @param stage the stage of the application
     * @param armiesController the controller for controlling armies in the game
     */
    public MenuView(Stage stage, ArmiesController armiesController){

        this.armiesController = armiesController;
        AnchorPane rootNode = new AnchorPane();
        SceneChanger sceneChanger = new SceneChanger(stage);


        Label title = new Label("Main Title");
        Button manageArmies = new Button("Arrange fleets");
        Button importArmies = new Button("Import");
        Button simulateMenu = new Button("Ready the chase guns");
        HBox buttonBox = new HBox();

        simulateMenu.setOnAction(actionEvent ->sceneChanger.goToSimulationMenu(stage, armiesController));
        importArmies.setOnAction(actionEvent -> armiesController.importArmy());
        manageArmies.setOnAction(actionEvent -> sceneChanger.goToManageArmies(stage, armiesController));


        buttonBox.getChildren().add(manageArmies);
        buttonBox.getChildren().add(importArmies);
        buttonBox.getChildren().add(simulateMenu);



        rootNode.getChildren().add(title);
        rootNode.getChildren().add(buttonBox);



        scene = new Scene(rootNode,800,800);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
        stage.show();
    }

    /**
     * Get the scene of this window.
     *
     * @return the scene of this view
     */
    public Scene getScene(){
        return this.scene;
    }
}

