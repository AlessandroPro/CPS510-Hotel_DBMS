package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;
import java.io.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GuestDAO {


    //Select * from guest operation
    private static ObservableList<Guest> getGuestList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Guest objects
        ObservableList<Guest> guestList = FXCollections.observableArrayList();

        while (rs.next()) {
            Guest guest = new Guest();
            guest.setGuestID(rs.getInt("GuestID"));
            guest.setTitle(rs.getString("Title"));
            guest.setFirstName(rs.getString("FirstName"));
            guest.setLastName(rs.getString("LastName"));
            guest.setContactNumber(rs.getString("ContactNumber"));
            guest.setHomeAddress(rs.getString("HomeAddress"));
            //Add guests to the ObservableList
            guestList.add(guest);
        }
        //return guestList (ObservableList of guests)
        return guestList;
    }

    //*******************************
    //SELECT all Guests
    //*******************************
    public static ObservableList<Guest> viewGuests () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM guest";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getRoomList method and get room object
            ObservableList<Guest> guestList = getGuestList(rsEmps);

            //Return room object
            return guestList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //*************************************
    //INSERT a Guest
    //*************************************
    public static void insertGuest (int guestID, String title, String firstName,
                                    String lastName, String contactNum, String homeAddr)
                                    throws SQLException, ClassNotFoundException {

        //Declare an UPDATE statement
        String updateStmt =
                        "INSERT INTO guest\n" +
                        "(GuestID, Title, FirstName, LastName, ContactNumber, HomeAddress)\n" +
                        "VALUES\n" +
                        "("+guestID+", '"+title+"', '"+firstName+"', '"+lastName+"', '"+contactNum+"', '"+homeAddr+"')";

        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //Delete a Guest
    //*************************************
    public static void deleteGuest (int guestID) throws SQLException, ClassNotFoundException {
        //Declare an UPDATE statement
        String updateStmt =
                "DELETE FROM guest WHERE GuestID = "+guestID ;

        //Execute INSERT operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

}
