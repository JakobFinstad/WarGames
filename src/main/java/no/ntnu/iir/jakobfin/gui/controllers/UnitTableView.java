package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import no.ntnu.iir.jakobfin.data.Unit;

/**
 * A class that creates a table view for units.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class UnitTableView {

    /**
     * Generate the tableview with no items. Ready to be populated.
     *
     * @return an empty table view for units
     */
    public static TableView<Unit> getUnitTableView(){
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

        return tableView;
    }
}
