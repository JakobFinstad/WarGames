package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.function.Army;

import java.util.List;

public class ArmiesController {

        public ObservableList<Army> getArmyObservableList(List<Army> armyList){
            ObservableList<Army> observableList = FXCollections.observableList(armyList);
            return observableList;
        }

        public  ObservableList<Unit> getUnitObservablesList(List<Unit> unitList){
            ObservableList<Unit> observableList = FXCollections.observableList(unitList);
            return observableList;
        }
}
