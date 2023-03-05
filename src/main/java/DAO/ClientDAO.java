package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connection.ConnectionFactory;

import Model.Client;
import Model.Product;
import Start.Reflection;

/**
 * In aceasta clasa sunt implementate interogarile din SQL : adugarea, stergerea, actualizarea si afisarea tabelului Clienti
 */

public class ClientDAO {
    protected static final Logger LOGGER=Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (ID,Name, Age, Address)" + "VALUES (?,?,?,?)";
    private static final String updateStatementString = "UPDATE client SET Age = ? where Name= ?";
    private static final String deleteStatementString = "DELETE FROM client where Name= ?";
    private static String viewStatementString = "SELECT * FROM client ";

    /**
     * aceasta metoda insereaza un client in tabel
     * @param client
     */

     //////INSERT/////
    public static void insert(Client client)
    {
        Connection dbConnection=ConnectionFactory.getConnection();
        PreparedStatement insertStatement=null;
        try{
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getID());
            insertStatement.setString(2, client.getName());
            insertStatement.setInt(3, client.getAge());
            insertStatement.setString(4,client.getAddress());
            insertStatement.executeUpdate();

            ResultSet rs=insertStatement.getGeneratedKeys();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: insert "+ e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * aceasta metoda actualizeaza varsta din tabelul clienti dupa nume
     * @param Name
     * @param age
     */

    ///////UPDATE/////
    public static void update(String Name, int age) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;
        try {
            updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setInt(1, age);
            updateStatement.setString(2, Name);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * aceasta metoda sterge clientii din tabel dupa nume
     * @param Name
     */

    ///////DELETE///////
    public static void delete(String Name) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setString(1, Name);
            deleteStatement.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "ClientDAO: delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * aceasta metoda returneaza o lista cu toti clientii din baza de date
     * @return
     * @throws SQLException
     */

    ///////VIEW ALL CLIENTS//////
    public static List<Client> viewAll() throws SQLException {
         Connection connection=ConnectionFactory.getConnection();
        PreparedStatement viewStatement=null;
        viewStatement=connection.prepareStatement(viewStatementString, Statement.RETURN_GENERATED_KEYS);
        ResultSet result=null;
        result=viewStatement.executeQuery(viewStatementString);
        List<Client> listClienti=new ArrayList<>();
        while(result.next())
        {
            Client client=new Client(result.getInt("ID"), result.getString("Name"),result.getString("Address"), result.getInt("Age"));
            listClienti.add(client);
          //  System.out.println(client);
        }
        return listClienti;
    }

}
