package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.layout.*;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class StartWindow extends Application {

    @Override
    public void start(Stage stage){

        try {
            SceneChanger controller = new SceneChanger(this);

            GridPane rootNode = new GridPane();

            VBox middleVBox = new VBox();
            Label title = new Label("Hearts of Steel");
            Button startButton = new Button("Run a rig");

            /**middleVBox.getChildren().add(title);*/
            middleVBox.getChildren().add(startButton);

            rootNode.add(title,1,0,1,1);
            rootNode.add(middleVBox,1,1,1,1);

            middleVBox.getStyleClass().add("vbox");
            title.getStyleClass().add("label");
            startButton.getStyleClass().add("button");
            rootNode.getStyleClass().add("rootNode");

            startButton.setOnAction(actionEvent -> controller.jumpToMenu(stage));

            Scene scene = new Scene(rootNode, 800, 800);
            scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.setTitle("Hearts of Steel");
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stop(){
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
