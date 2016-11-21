package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import model.Room;
import model.RoomDAO;
import model.GuestDAO;
import model.Booking;
import model.BookingDAO;

import java.sql.Date;
import java.sql.SQLException;

public class BookingsController {

    @FXML
    private TextField roomTypeText;
    @FXML
    private TextField numberOfBedsText;
    @FXML
    private TextField maxNightlyRateText;
    @FXML
    private TextField floorNumberText;
    @FXML
    private TextField roomNumberText;
    @FXML
    private TextField checkInDateText;
    @FXML
    private TextField checkOutDateText;
    @FXML
    private TextField packageText;
    @FXML
    private TextField guestFirstNameText;
    @FXML
    private TextField guestLastNameText;
    @FXML
    private TextField guestTitleText;
    @FXML
    private TextField guestContactNumberText;
    @FXML
    private TextField guestHomeAddressText;


    @FXML
    private Label roomErrorText;
    @FXML
    private Label bookingErrorText;


    @FXML
    private TableView availableRoomsTable;
    @FXML
    private TableColumn<Room, Integer>  roomNumberColumn;
    @FXML
    private TableColumn<Room, String> roomTypeColumn;
    @FXML
    private TableColumn<Room, String> roomAvailabilityColumn;
    @FXML
    private TableColumn<Room, Integer>  roomNumberOfBedsColumn;
    @FXML
    private TableColumn<Room, String> roomPhoneNumberColumn;
    @FXML
    private TableColumn<Room, Integer>  roomNightlyRateColumn;
    @FXML
    private TableColumn<Room, Integer>  roomWingNumberColumn;
    @FXML
    private TableColumn<Room, Integer>  roomFloorNumberColumn;

    @FXML
    private TableView bookingsTable;
    @FXML
    private TableColumn<Booking, Integer>  booksGuestIDColumn;
    @FXML
    private TableColumn<Booking, Integer>  booksRoomNumberColumn;
    @FXML
    private TableColumn<Booking, Date>  booksCheckInDateColumn;
    @FXML
    private TableColumn<Booking, Date>  booksCheckOutDateColumn;
    @FXML
    private TableColumn<Booking, String>  booksPackageColumn;
    @FXML
    private TableColumn<Booking, String>  booksPaymentMethodColumn;
    @FXML
    private TableColumn<Booking, String>  booksPaymentReceivedColumn;

    //Search all Rooms
    @FXML
    private void searchRooms(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String type = null;
        int numOfBeds = 0;
        int maxRate = 0;
        int floorNum = 0;

        if(!roomTypeText.getText().equals(""))
            type = roomTypeText.getText();
        if(!numberOfBedsText.getText().equals(""))
            numOfBeds = Integer.parseInt(numberOfBedsText.getText());
        if(!maxNightlyRateText.getText().equals(""))
            maxRate = Integer.parseInt(maxNightlyRateText.getText());
        if(!floorNumberText.getText().equals(""))
            floorNum = Integer.parseInt(floorNumberText.getText());

        try {
            //Get all Rooms information
            ObservableList<Room> roomData = RoomDAO.searchRooms(type, numOfBeds, maxRate, floorNum);
            //Populate Rooms on TableView
            populateRooms(roomData);
        } catch (SQLException e){
            roomErrorText.setText("Invalid search. Change input and try again.");
            System.out.println("Error occurred while getting Room information from DB.\n" + e);
            throw e;
        }
    }

    //View all Rooms
    @FXML
    private void viewRooms(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            //Get all Rooms information
            ObservableList<Room> roomData = RoomDAO.viewRooms();
            //Populate Rooms on TableView
            populateRooms(roomData);
        } catch (SQLException e){
            roomErrorText.setTextFill(Color.web("#dd0000"));
            roomErrorText.setText("An error occurred. Please try again.");
            System.out.println("Error occurred while getting Room information from DB.\n" + e);
            throw e;
        }
    }

    //Search all Bookings
    @FXML
    private void searchBookings(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try {
            //Get all Rooms information
            ObservableList<Booking> bookingData = BookingDAO.searchBookings();
            //Populate Rooms on TableView
            populateBookings(bookingData);
        } catch (SQLException e){
            bookingErrorText.setTextFill(Color.web("#dd0000"));
            bookingErrorText.setText("An error occurred. Please try again.");
            System.out.println("Error occurred while getting Booking information from DB.\n" + e);
            throw e;
        }
    }

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    private void initialize () {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */
        roomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty().asObject());
        roomTypeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        roomAvailabilityColumn.setCellValueFactory(cellData -> cellData.getValue().availabilityProperty());
        roomNumberOfBedsColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfBedsProperty().asObject());
        roomPhoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        roomNightlyRateColumn.setCellValueFactory(cellData -> cellData.getValue().nightlyRateProperty().asObject());
        roomWingNumberColumn.setCellValueFactory(cellData -> cellData.getValue().wingNumberProperty().asObject());
        roomFloorNumberColumn.setCellValueFactory(cellData -> cellData.getValue().floorNumberProperty().asObject());

        booksGuestIDColumn.setCellValueFactory(cellData -> cellData.getValue().guestIDProperty().asObject());
        booksRoomNumberColumn.setCellValueFactory(cellData -> cellData.getValue().roomNumberProperty().asObject());
        booksCheckInDateColumn.setCellValueFactory(cellData -> cellData.getValue().checkInDateProperty());
        booksCheckOutDateColumn.setCellValueFactory(cellData -> cellData.getValue().checkOutDateProperty());
        booksPackageColumn.setCellValueFactory(cellData -> cellData.getValue().packageUsedProperty());
        booksPaymentMethodColumn.setCellValueFactory(cellData -> cellData.getValue().paymentMethodProperty());
        booksPaymentReceivedColumn.setCellValueFactory(cellData -> cellData.getValue().paymentReceivedProperty());



        roomTypeText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    roomTypeText.setText(newValue.replaceAll(newValue, newValue.substring(0,10)));
                }
            }
        });

        numberOfBedsText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    numberOfBedsText.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 1) {
                    numberOfBedsText.setText(newValue.replaceAll(newValue, newValue.substring(0,1)));
                }
            }

        });

        maxNightlyRateText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    maxNightlyRateText.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 6) {
                    maxNightlyRateText.setText(newValue.replaceAll(newValue, newValue.substring(0,6)));
                }
            }
        });

        floorNumberText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    floorNumberText.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 3) {
                    floorNumberText.setText(newValue.replaceAll(newValue, newValue.substring(0,3)));
                }
            }

        });

        roomNumberText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    roomNumberText.setText(newValue.replaceAll("[^\\d]", ""));
                }
                if (newValue.length() > 4) {
                    roomTypeText.setText(newValue.replaceAll(newValue, newValue.substring(0,4)));
                }
            }
        });

        checkInDateText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    checkInDateText.setText(newValue.replaceAll(newValue, newValue.substring(0,10)));
                }
            }
        });

        checkOutDateText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    checkOutDateText.setText(newValue.replaceAll(newValue, newValue.substring(0,10)));
                }
            }
        });

        packageText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 10) {
                    packageText.setText(newValue.replaceAll(newValue, newValue.substring(0,10)));
                }
            }
        });

        guestFirstNameText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 20) {
                    guestFirstNameText.setText(newValue.replaceAll(newValue, newValue.substring(0,20)));
                }
            }
        });

        guestLastNameText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 20) {
                    guestLastNameText.setText(newValue.replaceAll(newValue, newValue.substring(0,20)));
                }
            }
        });

        guestTitleText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 4) {
                    guestTitleText.setText(newValue.replaceAll(newValue, newValue.substring(0, 4)));
                }
            }
        });

        guestContactNumberText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 12) {
                    guestContactNumberText.setText(newValue.replaceAll(newValue, newValue.substring(0,12)));
                }
            }
        });

        guestHomeAddressText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 20) {
                    guestHomeAddressText.setText(newValue.replaceAll(newValue, newValue.substring(0,20)));
                }
            }
        });
    }

    //Populate Rooms for TableView
    @FXML
    private void populateRooms (ObservableList<Room> roomData) throws ClassNotFoundException {
        //Set items to the employeeTable
        availableRoomsTable.setItems(roomData);
    }

    //Populate Bookings for TableView
    @FXML
    private void populateBookings (ObservableList<Booking> bookingData) throws ClassNotFoundException {
        //Set items to the employeeTable
        bookingsTable.setItems(bookingData);
    }

    //Insert a Booking to the DB
    @FXML
    private void insertBooking (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        int guestID = 37;

        try {
            GuestDAO.insertGuest(guestID, guestTitleText.getText(), guestFirstNameText.getText(),
                                    guestLastNameText.getText(),guestContactNumberText.getText(), guestHomeAddressText.getText());
            //resultArea.setText("Guest inserted! \n");
        } catch (SQLException e) {
            bookingErrorText.setTextFill(Color.web("#dd0000"));
            bookingErrorText.setText("Invalid search. Change input and try again.");
            throw e;
        }

        try {

            BookingDAO.insertBooking(guestID, Integer.parseInt(roomNumberText.getText()), checkInDateText.getText(),
                                    checkOutDateText.getText(), packageText.getText());
            bookingErrorText.setTextFill(Color.web("#000000"));
            bookingErrorText.setText("Booking Confirmed and Entered!");
            roomNumberText.setText("");
            checkInDateText.setText("");
            checkOutDateText.setText("");
            packageText.setText("");
            guestFirstNameText.setText("");
            guestLastNameText.setText("");
            guestContactNumberText.setText("");
            guestTitleText.setText("");
            guestHomeAddressText.setText("");
        } catch (RuntimeException e) {
            GuestDAO.deleteGuest(guestID);
            bookingErrorText.setTextFill(Color.web("#dd0000"));
            bookingErrorText.setText("Invalid search. Change input and try again.");
            throw e;
        }
    }

}
