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


    public void goToMainMenu(Stage stage){
        MenuView menuView = new MenuView(stage);
        stage.setScene(menuView.getScene());
    }

    public void goToSimulationMenu(Stage stage){
        SimulateMenu simulationMenu = new SimulateMenu(stage);
        stage.setScene(simulationMenu.getScene());
    }

    public void goToManageArmies(Stage stage){
        ManageArmies manageArmies = new ManageArmies(stage);
        stage.setScene(manageArmies.getScene());
    }

}
