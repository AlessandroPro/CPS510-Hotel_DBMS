package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RootLayoutController {


    //Reference to the main application
    private Main main;

    //Is called by the main application to give a reference back to itself.
   public void setMain (Main main) {
       this.main = main;
    }
    public void showGuestsView() {
        main.showGuestsView();
    }

    public void showBookingsView() {
        main.showBookingsView();
    }
    //Exit the program
    public void handleExit(ActionEvent actionEvent) {
        System.exit(0);
    }

}
