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
import Model.Order;

/**
 * In aceasta clasa sunt implementate interogarile din SQL : adugarea, stergerea, actualizarea si afisarea tabelului Comenzi
 */

public class OrderDAO {
    protected static final Logger LOGGER=Logger.getLogger(OrderDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO schooldb.order (idOrder , quantity , idClient , idProduct )" + "VALUES (?,?,?,?)";
    private static final String deleteStatementString= "DELETE FROM schooldb.order where idOrder=?";
    private static final String viewStatementString = "SELECT * FROM schooldb.order";

    /**
     * aceasta metoda insereaza o comanda in tabel
     * @param order
     */

    //////INSERT/////
    public static void insert(Order order)
    {
        Connection dbConnection=ConnectionFactory.getConnection();

        PreparedStatement insertStatement=null;
        try{
            insertStatement=dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,order.getIdOrder());
            insertStatement.setInt(2, order.getQuantity());
            insertStatement.setInt(3, order.getIdClient());
            insertStatement.setInt(4, order.getIdProduct());
            insertStatement.executeUpdate();

            ResultSet rs=insertStatement.getGeneratedKeys();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO: insert "+ e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * sterge comanda in functie de id ul comenzii
     * @param idOrder
     */

   ///////DELETE///////
    public static void delete(int idOrder) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, idOrder);
            deleteStatement.executeUpdate();
        }catch(SQLException e) {
            LOGGER.log(Level.WARNING, "OrderDAO: delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    /**
     * returneaza lista cu toate comenzile din tabel
     * @return
     * @throws SQLException
     */

    ///////VIEW ALL CLIENTS//////
    public static List<Order> viewAll() throws SQLException {
        Connection connection=ConnectionFactory.getConnection();
        PreparedStatement viewStatement=null;
        viewStatement=connection.prepareStatement(viewStatementString, Statement.RETURN_GENERATED_KEYS);
        ResultSet result=null;
        result=viewStatement.executeQuery(viewStatementString);
        List<Order> listOrders=new ArrayList<>();
        while(result.next())
        {
            Order o=new Order(result.getInt("idOrder"), result.getInt("idClient"),result.getInt("idProduct"), result.getInt("quantity"));
            listOrders.add(o);
            //  System.out.println(client);
        }
        return listOrders;
    }
}
