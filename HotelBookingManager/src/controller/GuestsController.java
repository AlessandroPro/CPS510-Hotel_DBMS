package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.*;

import java.io.*;
import java.sql.Date;
import java.sql.SQLException;

public class GuestsController {

    @FXML
    private Label roomErrorText;
    @FXML
    private Label bookingErrorText;


    @FXML
    private TableView guestsTable;
    @FXML
    private TableColumn<Guest, Integer>  guestIDColumn;
    @FXML
    private TableColumn<Guest, String> titleColumn;
    @FXML
    private TableColumn<Guest, String> firstNameColumn;
    @FXML
    private TableColumn<Guest, String>  lastNameColumn;
    @FXML
    private TableColumn<Guest, String> contactNumberColumn;
    @FXML
    private TableColumn<Guest, String>  homeAddressColumn;


    //View all Guests
    @FXML
    private void viewGuests(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            //Get all Rooms information
            ObservableList<Guest> guestData = GuestDAO.viewGuests();
            //Populate Rooms on TableView
            populateGuests(guestData);
        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("An error occurred. Please try again.");
            System.out.println("Error occurred while getting Guest information from DB.\n" + e);
            throw e;
        }
    }


    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {

        guestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestIDProperty().asObject());
        titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        contactNumberColumn.setCellValueFactory(cellData -> cellData.getValue().contactNumberProperty());
        homeAddressColumn.setCellValueFactory(cellData -> cellData.getValue().homeAddressProperty());
    }

    //Populate Guests for TableView
    @FXML
    private void populateGuests (ObservableList<Guest> guestData) throws ClassNotFoundException {
        //Set items to the Guest Table
        guestsTable.setItems(guestData);
    }

}
