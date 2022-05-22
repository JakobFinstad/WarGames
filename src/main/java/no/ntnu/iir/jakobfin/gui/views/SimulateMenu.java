package no.ntnu.iir.jakobfin.gui.views;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.data.Biomes;
import no.ntnu.iir.jakobfin.function.Army;
import no.ntnu.iir.jakobfin.gui.controllers.ArmiesController;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;
import no.ntnu.iir.jakobfin.gui.controllers.SimulationController;
import java.util.ArrayList;
import java.util.List;


/**
 * A class that represent the simulation of the game. It gives you the choice to pick armies from the two tables.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class SimulateMenu {
    private Scene scene;
    private ArmiesController armiesController;
    private SimulationController simController;
    private List<Army> selectedArmies;
    private TableView<Army> selectedArmiesTable;

    private Button plainTerrain;
    private Button forrestTerrain;
    private Button hillTerrain;
    private Biomes selectedTerrain;

    /**
     * Set up the display for all the information of this view. Connect the armies and button to the controllers.
     *
     * @param stage the stage of the application
     * @param armiesController the controller to the armies in the game
     */
    public SimulateMenu(Stage stage, ArmiesController armiesController){
        this.armiesController = armiesController;
        simController = new SimulationController();
        selectedArmies = new ArrayList<>();

        SceneChanger sceneChanger = new SceneChanger(stage);

        BorderPane rootNode = new BorderPane();

        VBox middleBox = new VBox();
        VBox leftBox = new VBox();
        VBox rightBox = new VBox();
        HBox terrainBox = new HBox();

        Label leftArmy = new Label("Army 1");
        Label rightArmy = new Label("Army 2");
        Label middleText = new Label("Selected armies");
        Label title = new Label("Simulation Menu");

        Button mainWindow = new Button("Heave To(back)");
        Button simulationButton = new Button("Fire in the hole");
        plainTerrain = new Button("Plain");
        hillTerrain = new Button("Hill");
        forrestTerrain = new Button("Forrest");

        plainTerrain.getStyleClass().add("gay");

        //Adding function to terrain buttons
        plainTerrain.setOnAction(actionEvent -> selectTerrainButton(plainTerrain));
        hillTerrain.setOnAction(actionEvent -> selectTerrainButton(hillTerrain));
        forrestTerrain.setOnAction(actionEvent -> selectTerrainButton(forrestTerrain));



        //Adding function to the main buttons
        mainWindow.setOnAction(actionEvent -> sceneChanger.goToMainMenu(stage, armiesController));
        simulationButton.setOnAction(actionEvent ->{
            if(selectedArmies.size()==2){
                    simController.simulate(selectedArmies,selectedTerrain);
                    selectedArmies.clear();
                    selectedArmiesTable.setItems(armiesController.getArmyObservableList(selectedArmies));
            }else{
                showAlert("Please select two armies that shall battle!");
            }
        });

        rootNode.setTop(title);

        leftBox.getChildren().add(leftArmy);
        leftBox.getChildren().add(setUpArmyTable(armiesController.getArmyList()));
        rootNode.setLeft(leftBox);

        rightBox.getChildren().add(rightArmy);
        rightBox.getChildren().add(setUpArmyTable(armiesController.getArmyList()));
        rootNode.setRight(rightBox);

        terrainBox.getChildren().addAll(plainTerrain,forrestTerrain,hillTerrain);
        middleBox.getChildren().add(terrainBox);
        middleBox.getChildren().add(simulationButton);
        middleBox.getChildren().add(middleText);
        setUpSelectedArmiesTable(selectedArmies);
        middleBox.getChildren().add(selectedArmiesTable);
        rootNode.setCenter(middleBox);

        rootNode.setBottom(mainWindow);

        scene = new Scene(rootNode,800, 800);
        scene.getStylesheets().add(getClass().getResource("MainWindow.css").toExternalForm());
    }

    /**
     * Get the scene of this simulation view.
     *
     * @return the scene of this window
     */
    public Scene getScene(){
        return this.scene;
    }

    /**
     * Set up the army table for the armies in the given list. Also add action events to the table.
     *
     * @param armyList a list of armies that shall be added to the display
     * @return a table view populated by armies and action events
     */
    private TableView<Army> setUpArmyTable(List<Army> armyList){


        TableColumn<Army, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Army> armyTable = new TableView<>();


        armyTable.setItems(armiesController.getArmyObservableList(armyList));
        armyTable.getColumns().add(nameColumn);

        armyTable.setOnMousePressed(mouseEvent -> {
            if(mouseEvent.isPrimaryButtonDown()&&mouseEvent.getClickCount()==2&&selectedArmies.size()<=1) {
                Army selectedArmy = armyTable.getSelectionModel().getSelectedItem();
                addArmyToSelected(selectedArmy);
            }
        });



        return armyTable;
    }

    /**
     * Add army to selected table.
     *
     * @param army the army that shall be added to the selected table
     */
    private void addArmyToSelected(Army army){
        selectedArmies.add(army);
        selectedArmiesTable.setItems(armiesController.getArmyObservableList(selectedArmies));
    }

    /**
     * Set up a table view for the selected armies to battle.
     *
     * @param armyList a list of the armies that shall be added to the selected table
     */
    private void setUpSelectedArmiesTable(List<Army> armyList){
        selectedArmiesTable = setUpArmyTable(armyList);

        selectedArmiesTable.setOnMousePressed(mouseEvent -> {
           if(mouseEvent.isPrimaryButtonDown()&&mouseEvent.getClickCount()==2){
               Army unSelectedArmy = selectedArmiesTable.getSelectionModel().getSelectedItem();
               removeArmyToSelected(unSelectedArmy);
           }
        });
    }

    /**
     * Remove army from the selected table.
     *
     * @param army army that shall be removed from the selected table
     */
    private void removeArmyToSelected(Army army){
        selectedArmies.remove(army);
        selectedArmiesTable.setItems(armiesController.getArmyObservableList(selectedArmies));
    }

    /**
     * Show alert. This method shows an error alert that have a custom text that can be added to
     * the description of the problem.
     *
     * @param displayText the text that shall be displayed to the user
     */
    private void showAlert(String displayText){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error has occurred. Please try again!");
        alert.setContentText(displayText);
        alert.showAndWait();
    }

    /**
     * Select the terrain, and gives the selected terrain button a specific style class.
     *
     * @param button the button that was pressed
     */
    private void selectTerrainButton(Button button){
        plainTerrain.setId("");
        forrestTerrain.setId("");
        hillTerrain.setId("");
        button.setId("selected");
        if(button==plainTerrain){
            selectedTerrain = Biomes.PLAINS;
        }
        if(button==forrestTerrain){
            selectedTerrain = Biomes.FORREST;
        }
        if(button==hillTerrain){
            selectedTerrain = Biomes.FORREST;
        }
    }
}
