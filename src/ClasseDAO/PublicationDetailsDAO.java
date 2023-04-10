package ClasseDAO;

import Classes.PublicationDetails;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PublicationDetailsDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public PublicationDetailsDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertPublicationDetailsDAO(PublicationDetails publicationDetails) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.publicationdetails (publication_id, authors, mdate, key_id) VALUES (?, ?, ?, ?)");

            preparedStatement.setInt(1, publicationDetails.getIdPublication());
            preparedStatement.setInt(2, publicationDetails.getAuthors());
            preparedStatement.setString(3, publicationDetails.getMdate());
            preparedStatement.setString(4, publicationDetails.getKey_id());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}