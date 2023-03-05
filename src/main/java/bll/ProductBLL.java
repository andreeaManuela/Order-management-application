package bll;
import DAO.ProductDAO;
import Model.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * in aceasta clasa sunt apelate metodele din clasa ProductDAO pt inserare, stergere si actualizare
 */

public class ProductBLL {
    public void insertProduct(Product produs)
    {
        ProductDAO.insert(produs);
    }

    public void deleteProduct(String nameProduct)
    {
        ProductDAO.delete(nameProduct);
    }

    public void updateProduct(String Name, int stoc)
    {
        ProductDAO.update(Name,stoc);
    }

    public void updateStocProduct(int cantitate, int idProduct){ProductDAO.updateStoc(cantitate, idProduct);}

    public List<Product> showAll() throws SQLException
    {
       return ProductDAO.viewAll();
    }

    public int getStocCurent(int id)
    {
        return ProductDAO.getStoc(id);
    }


}
