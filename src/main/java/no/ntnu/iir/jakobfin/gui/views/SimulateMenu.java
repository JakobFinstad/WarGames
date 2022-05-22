package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;

public class SimulateMenu {
    private Scene scene;

    public SimulateMenu(Stage stage){

        SceneChanger sceneChanger = new SceneChanger(stage);

        BorderPane rootNode = new BorderPane();

        Label title = new Label("Simulation Menu");
        Button mainWindow = new Button("Heave To(back)");

        mainWindow.setOnAction(actionEvent -> sceneChanger.goToMainMenu(stage));

        rootNode.setTop(title);
        rootNode.setBottom(mainWindow);

        scene = new Scene(rootNode,800, 800);
    }

    public Scene getScene(){
        return this.scene;
    }
}
