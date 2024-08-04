module mdt.caf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    exports mdt.caf.controladores;
    opens mdt.caf.controladores to javafx.fxml;
    exports mdt.caf.metodos;
    opens mdt.caf.metodos to javafx.fxml;
    exports mdt.caf;
    opens mdt.caf to javafx.fxml;
    opens mdt.caf.objetos to org.hibernate.orm.core;
}