package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO {


    //*******************************
    //SELECT available Rooms with search criteria
    //*******************************
    public static ObservableList<Room> searchRooms (String type, int numOfBeds, int maxRate, int floorNum)
                                                    throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String availabilityY = "'Y'";
        String selectStmt = "SELECT * FROM room WHERE Availability =" + availabilityY;

        if(type != null)
            selectStmt += " AND Type = '" + type + "'";
        if(numOfBeds != 0)
            selectStmt += " AND NumberOfBeds = " + numOfBeds;
        if(maxRate != 0)
            selectStmt += " AND CostPerNight <= " + maxRate;
        if(floorNum != 0)
            selectStmt += " AND floorNumber = " + floorNum;


        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getRoomList method and get room object
            ObservableList<Room> roomList = getRoomList(rsEmps);

            //Return room object
            return roomList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //*******************************
    //SELECT all available Rooms
    //*******************************
    public static ObservableList<Room> viewRooms () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String availabilityY = "'Y'";
        String selectStmt = "SELECT * FROM room WHERE Availability =" + availabilityY;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getRoomList method and get room object
            ObservableList<Room> roomList = getRoomList(rsEmps);

            //Return room object
            return roomList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from room operation
    private static ObservableList<Room> getRoomList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Room objects
        ObservableList<Room> roomList = FXCollections.observableArrayList();

        while (rs.next()) {
            Room room = new Room();
            room.setRoomNumber(rs.getInt("RoomNumber"));
            room.setType(rs.getString("Type"));
            room.setAvailability(rs.getString("Availability"));
            room.setnumberOfBeds(rs.getInt("NumberOfBeds"));
            room.setphoneNumber(rs.getString("PhoneNumber"));
            room.setNightlyRate(rs.getInt("CostPerNight"));
            room.setWingNumber(rs.getInt("WingNumber"));
            room.setFloorNumber(rs.getInt("FloorNumber"));
            //Add room to the ObservableList
            roomList.add(room);
        }
        //return roomList (ObservableList of rooms)
        return roomList;
    }
}
