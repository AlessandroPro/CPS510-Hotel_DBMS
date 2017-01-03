package model;

import javafx.beans.property.*;

import java.sql.Date;

public class Room {
    //Declare Room Table Columns
    private IntegerProperty roomNumber;
    private StringProperty type;
    private StringProperty availability;
    private IntegerProperty numberOfBeds;
    private StringProperty phoneNumber;
    private IntegerProperty nightlyRate;
    private IntegerProperty wingNumber;
    private IntegerProperty floorNumber;

    //Constructor
    public Room() {
        this.roomNumber = new SimpleIntegerProperty();
        this.type = new SimpleStringProperty();
        this.availability = new SimpleStringProperty();
        this.numberOfBeds = new SimpleIntegerProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.nightlyRate = new SimpleIntegerProperty();
        this.wingNumber = new SimpleIntegerProperty();
        this.floorNumber = new SimpleIntegerProperty();
    }

    //roomNumber
    public int getroomNumber() {
        return roomNumber.get();
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber.set(roomNumber);
    }

    public IntegerProperty roomNumberProperty(){
        return roomNumber;
    }

    //type
    public String getType () {
        return type.get();
    }

    public void setType(String type){
        this.type.set(type);
    }

    public StringProperty typeProperty() { return type; }

    //availability
    public String getAvailability () {
        return availability.get();
    }

    public void setAvailability(String availability){
        this.availability.set(availability);
    }

    public StringProperty availabilityProperty() {
        return availability;
    }

    //numberOfBeds
    public int getNumberOfBeds () {
        return numberOfBeds.get();
    }

    public void setnumberOfBeds(int numberOfBeds){
        this.numberOfBeds.set(numberOfBeds);
    }

    public IntegerProperty numberOfBedsProperty() {
        return numberOfBeds;
    }

    //phoneNumber
    public String getphoneNumber() {
        return phoneNumber.get();
    }

    public void setphoneNumber(String phoneNumber){ this.phoneNumber.set(phoneNumber); }

    public StringProperty phoneNumberProperty(){
        return phoneNumber;
    }


    //nightlyRate
    public int getNightlyRate () {
        return nightlyRate.get();
    }

    public void setNightlyRate(int nightlyRate){
        this.nightlyRate.set(nightlyRate);
    }

    public IntegerProperty nightlyRateProperty() {
        return nightlyRate;
    }

    //wingNumber
    public int getWingNumber () {
        return wingNumber.get();
    }

    public void setWingNumber(int wingNumber){
        this.wingNumber.set(wingNumber);
    }

    public IntegerProperty wingNumberProperty() {
        return wingNumber;
    }


    //floorNumber
    public int getFloorNumber () {
        return floorNumber.get();
    }

    public void setFloorNumber(int floorNumber){
        this.floorNumber.set(floorNumber);
    }

    public IntegerProperty floorNumberProperty() { return floorNumber; }

}
