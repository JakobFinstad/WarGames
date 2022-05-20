package no.ntnu.iir.jakobfin.gui.controllers;

import javafx.stage.Stage;
import no.ntnu.iir.jakobfin.gui.views.MenuView;
import no.ntnu.iir.jakobfin.gui.views.StartWindow;

public class SceneChanger {

    private StartWindow view;
    private MenuView menu;
    public SceneChanger(StartWindow view){
        this.view = view;
    }

    public void jumpToMenu(Stage stage){
        this.menu = new MenuView(stage);
        stage.setScene(menu.getScene());
    }

}
