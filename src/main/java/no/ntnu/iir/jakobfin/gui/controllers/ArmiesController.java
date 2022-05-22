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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that control the armies in the application. It reads from files, returns observable lists and add and remove
 * from the list.
 *
 * @author 10007
 * @version 22.05.2022
 */
public class ArmiesController {
    private List<Army> armyList;

    /**
     * Constructor for the army controller.
     */
    public ArmiesController(){
        armyList = new ArrayList<>();
    }

    /**
     * Get observable list wrapper for a list containing armies.
     *
     * @param armyList list of armies
     * @return observable list for javafx handling
     */
    public ObservableList<Army> getArmyObservableList(List<Army> armyList){
        ObservableList<Army> observableList = FXCollections.observableList(armyList);
        return observableList;
    }

    /**
     * Get observable list wrapper for a list containing units.
     *
     * @param unitList list containing units
     * @return observable list for javafx handling
     */
    public  ObservableList<Unit> getUnitObservablesList(List<Unit> unitList){
         ObservableList<Unit> observableList = FXCollections.observableList(unitList);
         return observableList;
    }

    /**
     * Get the list of armies in the game.
     *
     * @return the armies in this game
     */
    public List<Army> getArmyList(){
        return this.armyList;
    }

    /**
     * Add army to the game.
     *
     * @param army army that shall be added
     */
    public void addArmy(Army army){
        armyList.add(army);
    }

    /**
     * Add multiple armies to the game.
     *
     * @param armyList list of armies that shall be added to the game
     */
    public void addMultipleArmies(List<Army> armyList){
        for(Army a: armyList){
            this.armyList.add(a);
        }
    }

    /**
     * Import army from multiple files. Read from multiple files and add all the armies in the designated files to the
     * game's list of armies.
     */
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
