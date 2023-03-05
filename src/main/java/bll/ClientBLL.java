package bll;
import DAO.ClientDAO;
import Model.Client;
import bll.validators.ClientAgeValidator;
import bll.validators.Validator;

//import com.itextpdf
import javax.swing.text.Document;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * in aceasta clasa sunt apelate metodele din clasa ClientDAO pt inserare, stergere si actualizare
 */

public class ClientBLL {

    private List<Validator<Client>> validators;

    public ClientBLL()
    {
        validators=new ArrayList<Validator<Client>>();
        validators.add(new ClientAgeValidator());
    }

    public void insertClient(Client client)
    {
        ClientDAO.insert(client);
    }

    public void deleteClient(String name)
    {
        ClientDAO.delete(name);
    }

    public void updateClient(String Name, int age)
    {
        ClientDAO.update(Name,age);
    }

     public List<Client> showAll() throws SQLException {
       return  ClientDAO.viewAll();
    }

}
