module com.pbo.pbo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires java.sql;

    opens com.pbo.pbo to javafx.fxml;
    exports com.pbo.pbo;
    exports com.pbo;
    opens com.pbo to javafx.fxml;
}