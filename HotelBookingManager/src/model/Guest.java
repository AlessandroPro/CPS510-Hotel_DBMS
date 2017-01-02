package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Guest {
    //Declare Guest Table Columns
    private IntegerProperty guestID;
    private StringProperty title;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty contactNumber;
    private StringProperty homeAddress;


    //Constructor
    public Guest() {
        this.guestID = new SimpleIntegerProperty();
        this.title = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.contactNumber = new SimpleStringProperty();
        this.homeAddress = new SimpleStringProperty();
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

    //title
    public String getTitle () {
        return title.get();
    }

    public void setTitle(String title){
        this.title.set(title);
    }

    public StringProperty titleProperty() { return title; }

    //firstName
    public String getFirstName () {
        return firstName.get();
    }

    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    //lastName
    public String getLastName () { return lastName.get(); }

    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    //contactNumber
    public String getContactNumber() {
        return contactNumber.get();
    }

    public void setContactNumber(String contactNumber){ this.contactNumber.set(contactNumber); }

    public StringProperty contactNumberProperty(){
        return contactNumber;
    }

    //homeAddress
    public String getHomeAddress () {
        return homeAddress.get();
    }

    public void setHomeAddress(String homeAddress){
        this.homeAddress.set(homeAddress);
    }

    public StringProperty homeAddressProperty() { return homeAddress; }

}
