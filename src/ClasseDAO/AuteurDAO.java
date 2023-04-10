package ClasseDAO;

import Classes.Auteur;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuteurDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public AuteurDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertAutheur(Auteur autheur) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.authors (id, name) VALUES (?, ?)");

            preparedStatement.setInt(1, autheur.getId());
            preparedStatement.setString(2, autheur.getName());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}