package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.layout.*;
import no.ntnu.iir.jakobfin.function.Army;
import no.ntnu.iir.jakobfin.function.UnitFactory;
import no.ntnu.iir.jakobfin.gui.controllers.ArmiesController;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * A class that represent the start window for the application.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class StartWindow extends Application {

    private Scene scene;
    private ArmiesController armiesController;


    /**
     * Starts the application and gives the first window.
     *
     * @param stage the stage of the game
     */
    @Override
    public void start(Stage stage){

        try {
            SceneChanger controller = new SceneChanger(stage);

            armiesController = new ArmiesController();
            //Filling the tables
            fillArmiesController();

            GridPane rootNode = new GridPane();

            VBox middleVBox = new VBox();
            Label title = new Label("Hearts of Steel");
            Button startButton = new Button("Run a rig");

            middleVBox.getChildren().add(startButton);

            rootNode.add(title,1,0,1,1);
            rootNode.add(middleVBox,1,1,1,1);

            middleVBox.getStyleClass().add("vbox");
            title.getStyleClass().add("label");
            startButton.getStyleClass().add("button");
            rootNode.getStyleClass().add("rootNode");

            startButton.setOnAction(actionEvent -> controller.goToMainMenu(stage,armiesController));

            scene = new Scene(rootNode, 800, 800);
            scene.getStylesheets().add(getClass().getResource("mainWindow.css").toExternalForm());
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.setTitle("Hearts of Steel");
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Stops the application and exits the program.
     */
    @Override
    public void stop(){
        System.exit(0);
    }

    /**
     * Starts the program.
     *
     * @param args idk what this is, some arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Fill the army controller with two basic armies.
     */
    public void fillArmiesController(){
        UnitFactory factory = new UnitFactory();
        Army army1 = new Army("Human Army");
        army1.addAll(factory.createMultipleUnits("RangedUnit","Yolo",10,1));
        army1.addAll(factory.createMultipleUnits("CavalryUnit","My man Rammus",10,1));
        army1.addAll(factory.createMultipleUnits("InfantryUnit","Ok",10,1));

        Army army2 = new Army("Ogre Army");
        army2.addAll(factory.createMultipleUnits("RangedUnit","Hoo",10,10));
        army2.addAll(factory.createMultipleUnits("CavalryUnit","Little jo",10,10));
        army2.addAll(factory.createMultipleUnits("InfantryUnit","Some dudes",10,100));

        armiesController.addArmy(army1);
        armiesController.addArmy(army2);
    }

}
