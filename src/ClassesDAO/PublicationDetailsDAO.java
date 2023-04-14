package ClassesDAO;

import ClassesObject.PublicationDetails;
import Initializers.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublicationDetailsDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public PublicationDetailsDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public boolean publicationDetailsExists(int id) throws SQLException {
        String query = "SELECT publication_id FROM dblp.publicationdetails WHERE publication_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next();
    }

    public void insertPublicationDetailsDAO(PublicationDetails publicationDetails) throws SQLException {
        if (!publicationDetailsExists(publicationDetails.getIdPublication())) {
            String query = "INSERT INTO dblp.publicationdetails (publication_id, authors, mdate, key_id) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, publicationDetails.getIdPublication());
            preparedStatement.setInt(2, publicationDetails.getAuthors());
            preparedStatement.setString(3, publicationDetails.getMdate());
            preparedStatement.setString(4, publicationDetails.getKey_id());
            preparedStatement.executeUpdate();

            System.out.println("PublicationDetails insérée avec succès !");

        } else {
            System.out.println("La PublicationDetails existe déjà dans la base de données !");
        }
    }
}