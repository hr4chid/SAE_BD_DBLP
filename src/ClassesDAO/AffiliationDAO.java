package ClassesDAO;

import ClassesObject.Affiliation;
import Initializers.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliationDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public AffiliationDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public boolean affiliationExists(int id) {
        boolean exists = false;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT COUNT(*) FROM dblp.affiliation WHERE idAff = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    exists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    public void insertAffiliation(Affiliation affiliation) throws SQLException {
        try {
            if (!affiliationExists(affiliation.getId())) {
                PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.affiliation (idAff, name, country) VALUES (?, ?, ?)");
                preparedStatement.setInt(1, affiliation.getId());
                preparedStatement.setString(2, affiliation.getName());
                preparedStatement.setString(3, affiliation.getCountry());
                preparedStatement.executeUpdate();
                System.out.println("Affiliation inséréé avec succès !");
            } else {
                System.out.println("L'affiliation existe déjà dans la base de données !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}