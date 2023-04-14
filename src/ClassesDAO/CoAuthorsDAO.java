package ClassesDAO;

import Initializers.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoAuthorsDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public CoAuthorsDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertCoAuthors() throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.coauthors (author_id, coauthor_id)\n" +
                    "SELECT a1.id, a2.id\n" +
                    "FROM dblp.publicationauthors pa1\n" +
                    "JOIN dblp.publicationauthors pa2 ON pa1.publication_id = pa2.publication_id AND pa1.author_id < pa2.author_id\n" +
                    "JOIN dblp.authors a1 ON pa1.author_id = a1.id\n" +
                    "JOIN dblp.authors a2 ON pa2.author_id = a2.id\n" +
                    "GROUP BY a1.id, a2.id;\n");

            preparedStatement.executeUpdate();
            System.out.println("\n" + "CoAuthors insertion réussie !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}