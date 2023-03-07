module com.example.carddetails {
    requires javafx.controls;
    requires javafx.fxml;

    requires validatorfx;

    opens com.example.carddetails to javafx.fxml;
    exports com.example.carddetails;
}