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
import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.function.Army;
import no.ntnu.iir.jakobfin.function.Battle;
import no.ntnu.iir.jakobfin.function.UnitFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * A controller for the simulation part of the game. Simulate the battle and display the winner army.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class SimulationController {

    /**
     * Simulate a battle between two armies.
     *
     * @param armyList list of armies that shall battle, it only uses the two first armies in the battle
     * @param terrain the terrain type the armies are battling in
     */
    public void simulate(List<Army> armyList,Biomes terrain){
            armyList = generateGhostArmies(armyList);
            Army army1 = new Army(armyList.get(0).getName());
            army1.addAll(armyList.get(0).getAllUnits());

            Army army2 = new Army(armyList.get(1).getName());
            army2.addAll(armyList.get(1).getAllUnits());

            Battle battle = new Battle(army1,army2, terrain);
            displayWinner(battle.simulate(),terrain);
    }

    /**
     * Display the winner and the terrain of the fought battle.
     *
     * @param winner the winner of the battle
     * @param terrain the terrain type the battle was fought on
     */
    private void displayWinner(Army winner, Biomes terrain){
        Alert winnerAlert = new Alert(Alert.AlertType.INFORMATION);
        winnerAlert.setTitle("Winner Dialog");
        winnerAlert.setHeaderText("Winner of the battle was "+winner.getName()+".\n The battle was faught in/on "+terrain.name().toLowerCase(Locale.ROOT)+".");
        Pane rootNode = new Pane();
        Label unitText = new Label("Remaining units");
        VBox middleBox = new VBox();

        middleBox.getChildren().add(unitText);
        middleBox.getChildren().add(creatTable(winner.getAllUnits()));


        rootNode.getChildren().add(middleBox);
        winnerAlert.getDialogPane().setContent(rootNode);
        winnerAlert.showAndWait();

    }

    /**
     * Create the table for viewing the remaining units in the winning army. This table does not display the losing team.
     *
     * @param unitList a list of the units that will be the body of the table
     * @return a tableview with unit columns containing the units provided by the list
     */
    private TableView<Unit> creatTable(List<Unit> unitList){
        TableView<Unit> tableView = UnitTableView.getUnitTableView();
        ObservableList<Unit> observableList = FXCollections.observableList(unitList);
        tableView.setItems(observableList);

        return tableView;
    }

    /**
     * Generate ghost armies. This method generate ghost armies that can mirror armies, altho it does not have a
     * connection with the origin armies that is connected to the list.
     *
     * @param armyList a list of armies that shall be copied
     * @return a list similar to the original list
     */
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
