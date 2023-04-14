package ClasseDAO;

import ClassesObject.PublicationAuthors;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PublicationAuthorsDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public PublicationAuthorsDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertPublicationAuthors(PublicationAuthors publicationAuthors) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.publicationauthors (author_id, publication_id) VALUES (?, ?)");

            preparedStatement.setInt(1, publicationAuthors.getAuthorId());
            preparedStatement.setInt(2, publicationAuthors.getPublicationId());

            preparedStatement.executeUpdate();
            System.out.println("PublicationAuthors insertion réussie !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
