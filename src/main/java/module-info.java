module com.oop.group16.summer25_sec2 {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.oop.group16.summer25_sec2;

    opens com.oop.group16.summer25_sec2 to javafx.fxml;
    opens com.oop.group16.summer25_sec2.Ashik.Sponsor to javafx.fxml;
    opens com.oop.group16.summer25_sec2.Ashik.TicketBuyer to javafx.fxml;
}