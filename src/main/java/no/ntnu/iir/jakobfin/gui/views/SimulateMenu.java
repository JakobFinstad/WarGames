package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SimulateMenu {
    private Scene scene;

    public SimulateMenu(){

        Pane rootNode = new Pane();

        Label title = new Label("Simulation Menu");

        rootNode.getChildren().add(title);

        scene = new Scene(rootNode,800, 800);
    }

    public Scene getScene(){
        return this.scene;
    }
}
