package ClasseDAO;

import Classes.Autheur;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutheurDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public AutheurDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertAutheur(Autheur autheur) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.authors (id, name, firstpaper, lastpaper, affiliation) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, autheur.getId());
            preparedStatement.setString(2, autheur.getName());
            preparedStatement.setInt(3, autheur.getFirstpaper());
            preparedStatement.setInt(4, autheur.getLastpaper());
            //preparedStatement.setNull(5, null);

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}