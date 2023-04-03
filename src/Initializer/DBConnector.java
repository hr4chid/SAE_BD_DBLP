package Initializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private String user;
    private String url;
    private String password;

    public DBConnector() {
        this.user = "rabdoulalime";
        this.url = "jdbc:postgresql://database-etudiants.iut.univ-paris8.fr/rabdoulalime";
        this.password = "Azertyuiop94!";
    }

    public String getUser() {
        return this.user;
    }

    public String getUrl() {
        return this.url;
    }

    public String getPassword() {
        return this.password;
    }

    public Connection getConnection() throws ClassNotFoundException {
        Connection connect = null;
        Class.forName("org.postgresql.Driver");
        try {
            connect = DriverManager.getConnection(getUrl(), getUser(), getPassword());
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return connect;
    }

}

