package ClasseDAO;

import Classes.Autheur;
import Classes.Publication;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PublicationDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public PublicationDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertPublication(Publication publication) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.publications (id, title, year, venue, nauthor, type) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, publication.getId());
            preparedStatement.setString(2, publication.getTitle());
            preparedStatement.setInt(3, publication.getYear());
            preparedStatement.setString(4, publication.getVenue());
            preparedStatement.setInt(5, publication.getNbAuthors());
            preparedStatement.setString(6, publication.getType());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}