package ClasseDAO;

import Classes.CoAuthors;
import Initializer.DBConnector;
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

    public void insertCoAuthors(CoAuthors coAuthors) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.coauthors (author_id, coauthor_id) VALUES (?, ?)");

            preparedStatement.setInt(1, coAuthors.getAuthorId());
            preparedStatement.setInt(2, coAuthors.getCoauthorId());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}