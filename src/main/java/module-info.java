module com.oop.group16.summer25_sec2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.oop.group16.summer25_sec2 to javafx.fxml;
    exports com.oop.group16.summer25_sec2;
    opens com.oop.group16.summer25_sec2.Ashik.TicketBuyer to javafx.fxml;
    exports com.oop.group16.summer25_sec2.Ashik.TicketBuyer;
}