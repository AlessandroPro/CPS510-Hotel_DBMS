package model;

import javafx.beans.property.*;

import java.sql.Date;

public class Booking {
    //Declare Booking Table Columns
    private IntegerProperty guestID;
    private IntegerProperty roomNumber;
    private SimpleObjectProperty<Date> checkInDate;
    private SimpleObjectProperty<Date> checkOutDate;
    private StringProperty packageUsed;
    private StringProperty paymentMethod;
    private StringProperty paymentReceived;

    //Constructor
    public Booking() {
        this.guestID = new SimpleIntegerProperty();
        this.roomNumber = new SimpleIntegerProperty();
        this.checkInDate = new SimpleObjectProperty<>();
        this.checkOutDate = new SimpleObjectProperty<>();
        this.packageUsed = new SimpleStringProperty();
        this.paymentMethod = new SimpleStringProperty();
        this.paymentReceived = new SimpleStringProperty();
    }

    //guestID
    public int getGuestID() {
        return guestID.get();
    }

    public void setGuestID(int guestID){
        this.guestID.set(guestID);
    }

    public IntegerProperty guestIDProperty(){
        return guestID;
    }

    //roomNumber
    public int getRoomNumber() {
        return roomNumber.get();
    }

    public void setRoomNumber(int roomNumber){
        this.roomNumber.set(roomNumber);
    }

    public IntegerProperty roomNumberProperty(){
        return roomNumber;
    }

    //checkInDate
    public Object getCheckInDate(){
        return checkInDate.get();
    }

    public void setCheckInDate(Date checkInDate){
        this.checkInDate.set(checkInDate);
    }

    public SimpleObjectProperty<Date> checkInDateProperty(){
        return checkInDate;
    }

    //checkOutDate
    public Object getCheckOutDate(){
        return checkOutDate.get();
    }

    public void setCheckOutDate(Date checkOutDate){ this.checkOutDate.set(checkOutDate);}

    public SimpleObjectProperty<Date> checkOutDateProperty(){
        return checkOutDate;
    }

    //packageUsed
    public String getpackageUsed () { return packageUsed.get(); }

    public void setPackageUsed(String packageUsed){
        this.packageUsed.set(packageUsed);
    }

    public StringProperty packageUsedProperty() {
        return packageUsed;
    }

    //paymentMethod
    public String getPaymentMethod () { return paymentMethod.get(); }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod.set(paymentMethod);
    }

    public StringProperty paymentMethodProperty() {
        return paymentMethod;
    }

    //paymentReceived
    public String getPaymentReceived () { return paymentReceived.get(); }

    public void setPaymentReceived(String paymentReceived){
        this.paymentReceived.set(paymentReceived);
    }

    public StringProperty paymentReceivedProperty() {
        return paymentReceived;
    }

}
