module no.ntnu.iir.jakobfin.gui.views{
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.iir.jakobfin.gui.views to javafx.fxml;
    exports no.ntnu.iir.jakobfin.gui.views;
    exports no.ntnu.iir.jakobfin.data;
    exports no.ntnu.iir.jakobfin.function;
}