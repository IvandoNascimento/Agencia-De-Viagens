module Controller{
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.base;
    requires org.controlsfx.controls;

    opens Controller to javafx.fxml;
    exports Controller;
}