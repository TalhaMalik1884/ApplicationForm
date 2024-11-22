module com.example.applicform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.applicform to javafx.fxml;
    exports com.example.applicform;
}