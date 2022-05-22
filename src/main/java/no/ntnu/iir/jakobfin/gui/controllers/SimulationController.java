package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import no.ntnu.iir.jakobfin.data.Biomes;
import no.ntnu.iir.jakobfin.data.RangedUnit;
import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.function.Army;
import no.ntnu.iir.jakobfin.function.Battle;
import no.ntnu.iir.jakobfin.function.UnitFactory;

import java.util.ArrayList;
import java.util.List;

public class SimulationController {

        public void simulate(List<Army> armyList,Biomes terrain){
            armyList = generateGhostArmies(armyList);
            Army army1 = new Army(armyList.get(0).getName());
            army1.addAll(armyList.get(0).getAllUnits());

            Army army2 = new Army(armyList.get(1).getName());
            army2.addAll(armyList.get(1).getAllUnits());

            Battle battle = new Battle(army1,army2, terrain);
            displayWinner(battle.simulate());
        }

        private void displayWinner(Army winner){
            Alert winnerAlert = new Alert(Alert.AlertType.INFORMATION);
            winnerAlert.setTitle("Winner Dialog");
            winnerAlert.setHeaderText("Winner of the battle was "+winner.getName());

            Pane rootNode = new Pane();
            Label unitText = new Label("Remaining units");
            VBox middleBox = new VBox();

            middleBox.getChildren().add(unitText);
            middleBox.getChildren().add(creatTable(winner.getAllUnits()));


            rootNode.getChildren().add(middleBox);
            winnerAlert.getDialogPane().setContent(rootNode);
            winnerAlert.showAndWait();

        }

    private TableView<Unit> creatTable(List<Unit> unitList){
        TableView<Unit> tableView = new TableView<>();

        TableColumn<Unit, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> healthColumn = new TableColumn<>("Health");
        healthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

        TableColumn<Unit, Integer> attackColumn = new TableColumn<>("Attack");
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));

        TableColumn<Unit, Integer> armorColumn = new TableColumn<>("Armor");
        armorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

        tableView.getColumns().addAll(nameColumn,healthColumn,attackColumn,armorColumn);
        ObservableList<Unit> observableList = FXCollections.observableList(unitList);
        tableView.setItems(observableList);

        return tableView;
    }

    private List<Army> generateGhostArmies(List<Army> armyList){
            List<Army> armies = new ArrayList<>();
            UnitFactory factory = new UnitFactory();

            for(Army a:armyList){
                List<Unit> units = new ArrayList<>();
                for(Unit u:a.getAllUnits()){
                    units.add(factory.createUnit(u.getClass().getSimpleName(),u.getName(),u.getHealth()));
                }
                Army ghostArmy = new Army(a.getName(),units);
                armies.add(ghostArmy);
            }


            return armies;
    }
}
