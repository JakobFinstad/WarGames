package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import no.ntnu.iir.jakobfin.data.Unit;
import no.ntnu.iir.jakobfin.exceptions.CorruptLineInFileException;
import no.ntnu.iir.jakobfin.exceptions.WrongFileFormatException;
import no.ntnu.iir.jakobfin.function.Army;
import no.ntnu.iir.jakobfin.function.ArmyFileManager;

import javax.crypto.spec.PSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArmiesController {
    private List<Army> armyList;

    public ArmiesController(){
        armyList = new ArrayList<>();
    }

    public ObservableList<Army> getArmyObservableList(List<Army> armyList){
        ObservableList<Army> observableList = FXCollections.observableList(armyList);
        return observableList;
    }

    public  ObservableList<Unit> getUnitObservablesList(List<Unit> unitList){
         ObservableList<Unit> observableList = FXCollections.observableList(unitList);
         return observableList;
    }

    public List<Army> getArmyList(){
        return this.armyList;
    }

    public void addArmy(Army army){
        armyList.add(army);
    }

    public void addMultipleArmies(List<Army> armyList){
        for(Army a: armyList){
            this.armyList.add(a);
        }
    }

    public void importArmy(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select files with armies");

        File file = new File("src\\main\\resources\\");
        fileChooser.setInitialDirectory(file);
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);
        if(selectedFiles != null){
            try {
                for(File f: selectedFiles) {
                    try {
                        ArmyFileManager armyFile = new ArmyFileManager(f);
                        this.armyList.add(armyFile.readFromFile());

                    }catch (WrongFileFormatException wfe){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Wrong file format");
                        alert.setContentText("Please select a '.csv' file for importing. The file with path: " + wfe.getMessage() + " , is not the right format.");
                        alert.showAndWait();
                    }catch(CorruptLineInFileException clife){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Corrupted line");
                        alert.setContentText("Line number " + clife.getMessage() + " was corrupted. Pleas fix the issue and try again.");
                        alert.showAndWait();
                    }

                }
            }catch(IOException ioException){
                System.out.println(ioException.getMessage());
            }
        }


    }

}
