module com.example.mendeleevtable {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens com.example.mendeleevtable to javafx.fxml;
    exports com.example.mendeleevtable;
}