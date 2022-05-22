package no.ntnu.iir.jakobfin.gui.views;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.function.Army;
import no.ntnu.iir.jakobfin.gui.controllers.ArmiesController;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;
import no.ntnu.iir.jakobfin.gui.controllers.UnitTableView;

import java.util.ArrayList;
import java.util.List;

/**
 * A view that present the armies and it's units. This will eventually represent the adding and removing of units in
 * the armies. I want to add more functionality to this window although right now it just displays the armies.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class ManageArmies {
    private Scene scene;
    private List<Unit> unitList;
    private ArmiesController armyController;
    private TableView<Unit> unitTableView;

    /**
     * Constructor for the manage armies view. Create all the provided field and retrieve the armies from the controller.
     *
     * @param stage the stage for this window
     * @param armiesController the controller for the armies in this game
     */
    public ManageArmies(Stage stage, ArmiesController armiesController){
        //Creating the list
        this.armyController = armiesController;
        unitList = new ArrayList<>();


        SceneChanger sceneChanger = new SceneChanger(stage);

        BorderPane rootNode = new BorderPane();

        Label title = new Label("Arrange fleets");
        Button mainMenu = new Button("Heave to(back)");



        mainMenu.setOnAction(actionEvent -> sceneChanger.goToMainMenu(stage, armiesController));
        setUpTableArmy();

        rootNode.setTop(title);
        rootNode.setLeft(setUpTableArmy());
        rootNode.setRight(setUpUnitTable());
        rootNode.setBottom(mainMenu);

        scene = new Scene(rootNode, 800,800);
        stage.setScene(scene);
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

    /**
     * Set up the army table for the armies in the game.
     *
     * @return tableview for displaying the armies in the game
     */
    public TableView<Army> setUpTableArmy(){


            TableColumn<Army, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableView<Army> leftTableArmies = new TableView<>();


            leftTableArmies.setItems(armyController.getArmyObservableList(armyController.getArmyList()));
            leftTableArmies.getColumns().add(nameColumn);

            leftTableArmies.setOnMousePressed(mouseEvent -> {
                if(mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2){
                    Army selectedArmy = leftTableArmies.getSelectionModel().getSelectedItem();
                    refreshUnitList(selectedArmy);
                }
            });


        return leftTableArmies;
    }

    /**
     * Set up the table view for the units.
     *
     * @return table view populated with the armies in the army controller
     */
    public TableView<Unit> setUpUnitTable(){
        unitTableView = UnitTableView.getUnitTableView();
        unitTableView.setItems(armyController.getUnitObservablesList(unitList));
        return unitTableView;
    }

    /**
     * Refresh the unit table with the units in the given army.
     *
     * @param army the army with the units that shall populate the table
     */
    public void refreshUnitList(Army army){
        unitList = army.getAllUnits();
        unitTableView.setItems(armyController.getUnitObservablesList(unitList));
    }



}
