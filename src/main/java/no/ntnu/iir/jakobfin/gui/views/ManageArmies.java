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
import no.ntnu.iir.jakobfin.function.UnitFactory;
import no.ntnu.iir.jakobfin.gui.controllers.ArmiesController;
import no.ntnu.iir.jakobfin.gui.controllers.SceneChanger;

import java.util.ArrayList;
import java.util.List;

public class ManageArmies {
    private Scene scene;
    private ObservableList<Army> armyObservableList;
    private Army testArmy = new Army("Test");
    private List<Army> armyList;
    private List<Unit> unitList;
    private ObservableList<Unit> unitObservableList;
    private ArmiesController armyController;

    private TableView<Unit> unitTableView;

    public ManageArmies(Stage stage){
        //Creating the list
        armyList = new ArrayList<>();
        armyController = new ArmiesController();
        unitList = new ArrayList<>();

        //Filling the tables
        fillTable();

        SceneChanger sceneChanger = new SceneChanger(stage);

        BorderPane rootNode = new BorderPane();

        Label title = new Label("Arrange fleets");
        Button mainMenu = new Button("Heave to(back)");



        mainMenu.setOnAction(actionEvent -> sceneChanger.goToMainMenu(stage));
        setUpTableArmy();

        rootNode.setTop(title);
        rootNode.setLeft(setUpTableArmy());
        rootNode.setRight(setUpUnitTable());
        rootNode.setBottom(mainMenu);

        scene = new Scene(rootNode, 800,800);
        stage.setScene(scene);
        stage.show();


    }

    public Scene getScene(){
        return this.scene;
    }

    public TableView<Army> setUpTableArmy(){


            TableColumn<Army, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableView<Army> leftTableArmies = new TableView<>();


            leftTableArmies.setItems(armyController.getArmyObservableList(armyList));
            leftTableArmies.getColumns().add(nameColumn);

            leftTableArmies.setOnMousePressed(mouseEvent -> {
                if(mouseEvent.isPrimaryButtonDown() && mouseEvent.getClickCount() == 2){
                    Army selectedArmy = leftTableArmies.getSelectionModel().getSelectedItem();
                    refreshUnitList(selectedArmy);
                }
            });


        return leftTableArmies;
    }
    
    public TableView<Unit> setUpUnitTable(){
        TableColumn<Unit, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> healthColumn = new TableColumn<>("Health");
        healthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

        TableColumn<Unit, Integer> attackColumn = new TableColumn<>("Attack");
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));

        TableColumn<Unit, Integer> armorColumn = new TableColumn<>("Armor");
        armorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

        unitTableView = new TableView<>();

        unitTableView.setItems(armyController.getUnitObservablesList(unitList));
        unitTableView.getColumns().addAll(nameColumn, healthColumn, attackColumn, armorColumn);

        return unitTableView;
    }

    public void refreshUnitList(Army army){
        unitList = army.getAllUnits();
        unitTableView.setItems(armyController.getUnitObservablesList(unitList));
    }

    public void fillTable(){
        UnitFactory factory = new UnitFactory();
        Army army1 = new Army("Human Army");
        army1.addAll(factory.createMultipleUnits("RangedUnit","Yolo",10,10));
        army1.addAll(factory.createMultipleUnits("CavalryUnit","My man Rammus",10,10));
        army1.addAll(factory.createMultipleUnits("InfantryUnit","Ok",10,10));

        Army army2 = new Army("Ogre Army");
        army2.addAll(factory.createMultipleUnits("RangedUnit","Hoo",10,10));
        army2.addAll(factory.createMultipleUnits("CavalryUnit","Little jo",10,10));
        army2.addAll(factory.createMultipleUnits("InfantryUnit","Some dudes",10,100));

        armyList.add(army1);
        armyList.add(army2);
    }

}
