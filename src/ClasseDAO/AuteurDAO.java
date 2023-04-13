package ClasseDAO;

import Classes.Auteur;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuteurDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public AuteurDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertAutheur(Auteur autheur) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.authors (id, name) VALUES (?, ?)");

            preparedStatement.setInt(1, autheur.getId());
            preparedStatement.setString(2, autheur.getName());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getIdAuteur(String nom) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer id = null;
        try {
            preparedStatement = this.connection.prepareStatement("SELECT id FROM dblp.authors WHERE name = ?");
            preparedStatement.setString(1, nom);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                System.out.println("\n" + "Récupération de l'id réussie !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


}

