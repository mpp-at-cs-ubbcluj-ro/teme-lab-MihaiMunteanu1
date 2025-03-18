module ro.mpp.temalab {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires spring.context;

    opens ro.mpp2024.temalab4 to javafx.fxml;
    exports ro.mpp2024.temalab4;
}