package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDAO {

    //*******************************
    //SELECT Bookings
    //*******************************
    public static ObservableList<Booking> searchBookings () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM books" ;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getBookingList method and get booking object
            ObservableList<Booking> bookingList = getBookingList(rsEmps);

            //Return room object
            return bookingList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from booking operation
    private static ObservableList<Booking> getBookingList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Booking objects
        ObservableList<Booking> bookingList = FXCollections.observableArrayList();

        while (rs.next()) {
            Booking booking = new Booking();
            booking.setRoomNumber(rs.getInt("RoomNumber"));
            booking.setGuestID(rs.getInt("GuestID"));
            booking.setCheckInDate(rs.getDate("checkInDate"));
            booking.setCheckOutDate(rs.getDate("checkOutDate"));
            booking.setPackageUsed(rs.getString("Package"));
            booking.setPaymentMethod(rs.getString("PaymentMethod"));
            booking.setPaymentReceived(rs.getString("PaymentReceived"));

            //Add booking to the ObservableList
            bookingList.add(booking);
        }
        //return bookingList (ObservableList of bookings)
        return bookingList;
    }

    //*************************************
    //INSERT a Booking
    //*************************************
    public static void insertBooking (int guestID, int roomNum, String checkInDate, String checkOutDate,
                                      String packageUsed) throws SQLException, ClassNotFoundException {
        //Declare an UPDATE statement
        String updateStmt =
                "INSERT INTO books\n" +
                        "(GuestID, RoomNumber, CheckInDate, CheckOutDate, Package, PaymentMethod, PaymentReceived)\n" +
                        "VALUES\n" +
                        "("+guestID+", "+roomNum+", TO_DATE('"+checkInDate+" 15:00:00', " +
                        "'yy/mm/dd hh24:mi:ss'), TO_DATE('"+checkOutDate+" 11:00:00', 'yy/mm/dd hh24:mi:ss')," +
                        " '"+packageUsed+"', 'Visa', 'N')";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
    }
}
