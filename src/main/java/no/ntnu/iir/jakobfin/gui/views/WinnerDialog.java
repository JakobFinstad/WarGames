package no.ntnu.iir.jakobfin.gui.views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.function.Army;

import java.util.List;

public class WinnerDialog extends Dialog<Army> {



    private Army army;

    private Label winnerArmy;
    private Label units;
    private TableView<Unit> unitTableView;

    public WinnerDialog(Army army){
        this.army = army;
        createContent();

    }

    public void createContent(){
        setTitle("The winner of the battle");

        getDialogPane().getButtonTypes().add(ButtonType.OK);

        GridPane rootNode = new GridPane();
        rootNode.setHgap(15);
        rootNode.setVgap(15);

        this.winnerArmy = new Label("Winner is "+ army.getName());

        this.unitTableView = creatTable(army.getAllUnits());

        rootNode.add(winnerArmy,1,1,1,1);
        rootNode.add(unitTableView,2,1,1,1);

        getDialogPane().setContent(rootNode);
        showAndWait();
    }

    private TableView<Unit> creatTable(List<Unit> unitList){
        TableView<Unit> table = new TableView<>();

        TableColumn<Unit, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Unit, Integer> healthColumn = new TableColumn<>("Health");
        healthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

        TableColumn<Unit, String> attackColumn = new TableColumn<>("Attack");
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));

        TableColumn<Unit, String> armorColumn = new TableColumn<>("Armor");
        armorColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));

        table.getColumns().addAll(nameColumn,healthColumn,attackColumn,armorColumn);
        ObservableList<Unit> observableList = FXCollections.observableList(unitList);
        table.setItems(observableList);

        return table;
    }



}
