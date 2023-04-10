package ClasseDAO;

import Classes.Affiliation;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AffiliationDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public AffiliationDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertAffiliation(Affiliation affiliation) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.affiliation (idAff, name, country) VALUES (?, ?, ?)");

            preparedStatement.setInt(1, affiliation.getId());
            preparedStatement.setString(2, affiliation.getName());
            preparedStatement.setString(3, affiliation.getCountry());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}