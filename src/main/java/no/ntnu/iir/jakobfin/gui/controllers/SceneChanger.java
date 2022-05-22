package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.gui.views.ManageArmies;
import no.ntnu.iir.jakobfin.gui.views.MenuView;
import no.ntnu.iir.jakobfin.gui.views.SimulateMenu;
import no.ntnu.iir.jakobfin.gui.views.StartWindow;

public class SceneChanger {
    private Stage stage;

    public SceneChanger(Stage stage){
        this.stage = stage;
    }


    public void goToMainMenu(Stage stage, ArmiesController armiesController){
        MenuView menuView = new MenuView(stage, armiesController);
        stage.setScene(menuView.getScene());
    }

    public void goToSimulationMenu(Stage stage, ArmiesController armiesController){
        SimulateMenu simulationMenu = new SimulateMenu(stage, armiesController);
        stage.setScene(simulationMenu.getScene());
    }

    public void goToManageArmies(Stage stage, ArmiesController armiesController){
        ManageArmies manageArmies = new ManageArmies(stage, armiesController);
        stage.setScene(manageArmies.getScene());
    }

}
