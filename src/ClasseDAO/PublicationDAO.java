package ClasseDAO;

import ClassesObject.Publication;
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
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.publications (id, title, year, venue, nauthor, type) " +
                    "SELECT ?, ?, ?, ?, ?, ? " +
                    "WHERE NOT EXISTS " +
                    "(SELECT * FROM dblp.publications WHERE id = ?)");

            preparedStatement.setInt(1, publication.getId());
            preparedStatement.setString(2, publication.getTitle());
            preparedStatement.setInt(3, publication.getYear());
            preparedStatement.setString(4, publication.getVenue());
            preparedStatement.setInt(5, publication.getNbAuthors());
            preparedStatement.setString(6, publication.getType());
            preparedStatement.setInt(7, publication.getId());

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Publication insérée avec succès.");
            } else {
                System.out.println("La publication existe déjà dans la base de données !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}