package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.gui.views.ManageArmies;
import no.ntnu.iir.jakobfin.gui.views.MenuView;
import no.ntnu.iir.jakobfin.gui.views.SimulateMenu;

/**
 * A controller for changing the different scenes or windows in the application.
 */
public class SceneChanger {
    private Stage stage;

    /**
     * Constructor for the controller. Connect the controller to the stage.
     *
     * @param stage the javafx stage for this application
     */
    public SceneChanger(Stage stage){
        this.stage = stage;
    }


    /**
     * Go to the main menu. Changes the view to main menu view.
     *
     * @param stage the stage for the application
     * @param armiesController the controller for the armies in this game
     */
    public void goToMainMenu(Stage stage, ArmiesController armiesController){
        MenuView menuView = new MenuView(stage, armiesController);
        stage.setScene(menuView.getScene());
    }

    /**
     * Go to simulation menu. Change the window of the application to the simulation window.
     *
     * @param stage the stage of the application
     * @param armiesController the controller for the armies in the game
     */
    public void goToSimulationMenu(Stage stage, ArmiesController armiesController){
        SimulateMenu simulationMenu = new SimulateMenu(stage, armiesController);
        stage.setScene(simulationMenu.getScene());
    }

    /**
     * Go to manage armies window. Change the application window to the manage armies window.
     *
     * @param stage the stage of the application
     * @param armiesController the controller for armies in the game
     */
    public void goToManageArmies(Stage stage, ArmiesController armiesController){
        ManageArmies manageArmies = new ManageArmies(stage, armiesController);
        stage.setScene(manageArmies.getScene());
    }

}
