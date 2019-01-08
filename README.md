CPS 510 - Database Systems - Final Project 
Section 5

## Hotel Booking Manager GUI

Alessandro Profenna  
Tolaz Hewa  
Ryan Randive  



This repository includes the Java GUI files for our Hotel Management Database System.

We designed a GUI using JavaFX that would be typically used by a hotel concierge. It is representative of hotel room booking software. 

This booking manager greets users with a main page that includes views for two tables. The user is able to view all available rooms in the hotel, and even search for rooms based on specific criteria.  He or she is also able to book a room by inputting guest and booking information. Doing so adds entries to the guest table and books table in the database. Via the dropdown menu, the hotel guest table is also viewable in a separate window.

The structure of program uses the DAO Design Pattern to perform operations. In DAO pattern, domain (business) logic does not directly communicate with the database. It communicates with DAO layer and DAO layer handles database operations and sends the results to the business layer.

Example Screenshots:

<img width="1140" alt="bookingview" src="https://cloud.githubusercontent.com/assets/15040875/21598076/a40577ca-d123-11e6-8702-67c51830ddc1.png">


<img width="1136" alt="guestview" src="https://cloud.githubusercontent.com/assets/15040875/21598242/2346ae70-d127-11e6-85f1-92c41315128d.png">



The java files, fxml files, and a single text file are located in the HotelBookingManager/src directory.
Here is the directory structure within src:

/controller:  
  BookingsController.java  
  guestsIDs.txt  
  GuestController.java  
  Main.java  
  RootLayoutController.java  

/model:  
  Booking.java  
  BookingDAO.java  
  Guest.java  
  GuestDAO.java  
  Room.java  
  RoomDAO.java  

/util:  
  DBUtil.java  

/view:  
  BookingsView.fxml
  GuestsView.fxml
  RootLayout.fxml


In order to connect to the database, the following ojdbc-11.2.0.3.jar driver is included in the HotelBookingManager/lib directory.


Java 8 must be installed. It is suggested that an IDE is used with the working directory set to /HotelBookingManager.
Once all files have been compiled, the application should run the main method from controller.Main





