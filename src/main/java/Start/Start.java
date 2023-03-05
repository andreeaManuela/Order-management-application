package Start;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Presentation.*;

import Model.Client;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import com.itextpdf.text.DocumentException;

/**
 * Aceasta este clasa main in care se creeaza obeictele de interfata : View, ViewClient, ViewProduct, ViewOrder si Controllerul
 *
 */

public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws SQLException {
        View view = new View();
        ViewClient viewClient = new ViewClient();
        ViewProduct viewProduct = new ViewProduct();
        ViewOrder viewOrder = new ViewOrder();
        Controller controller = new Controller(view);
        view.setVisible(true);
    }
}

