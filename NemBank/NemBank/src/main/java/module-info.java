module com.jmc.nembank.nembank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.jmc.nembank.nembank to javafx.fxml;
    exports com.jmc.nembank.nembank;
    exports com.jmc.nembank.nembank.Controllers;
    exports com.jmc.nembank.nembank.Controllers.Admin;
    exports com.jmc.nembank.nembank.Controllers.Client;
    exports com.jmc.nembank.nembank.Views;


}