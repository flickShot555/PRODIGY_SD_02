module com.example.prodigy_sd_02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.prodigy_sd_02 to javafx.fxml;
    exports com.example.prodigy_sd_02;
}