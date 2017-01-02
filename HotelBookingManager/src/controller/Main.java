package controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

//controller.Main class which extends from Application Class
public class Main extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        //1) Declare a primary stage (Everything will be on this stage)
        this.primaryStage = primaryStage;

        //Optional: Set a title for primary stage
        this.primaryStage.setTitle("Hotel Booking Manager");

        //2) Initialize RootLayout
        initRootLayout();

        //3) Display the BookingOperations View
        showBookingsView();
    }

    //Initializes the root layout.
    public void initRootLayout() {
        try {
            //First, load root layout from RootLayout.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Second, show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //We are sending rootLayout to the Scene.
            primaryStage.setScene(scene); //Set the scene in primary stage.

            //Give the controller access to the main.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);

            //Third, show the primary stage
            primaryStage.show(); //Display the primary stage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the bookings view inside the root layout.
    public void showBookingsView() {
        try {
            //First, load BookingsView from BookingsView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/BookingsView.fxml"));
            AnchorPane bookingsOperationsView = (AnchorPane) loader.load();

            // Set Bookings Operations view into the center of root layout.
            rootLayout.setCenter(bookingsOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Shows the guest view inside the root layout.
    public void showGuestsView() {
        try {
            //First, load BookingsView from BookingsView.fxml
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../view/GuestsView.fxml"));
            AnchorPane GuestsOperationsView = (AnchorPane) loader.load();

            // Set Bookings Operations view into the center of root layout.
            rootLayout.setCenter(GuestsOperationsView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
