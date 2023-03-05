package Presentation;

import DAO.ClientDAO;
import Model.Client;
import Model.Order;
import Model.Product;
import Start.Table;
import bll.ClientBLL;
import bll.OrderBLL;
import bll.ProductBLL;
import com.itextpdf.text.DocumentException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Aceasta clasa implementeaza ascultatorii pentru toate butaonele
 */

public class Controller {
    private View view;
    private ViewClient viewClient=new ViewClient();
    private ViewProduct viewProduct=new ViewProduct();
    private ViewOrder viewOrder=new ViewOrder();

    public Controller(View view)
    {
        this.view=view;

        //Pentru afisarea interfetei Clienti
        this.view.clientShowTableListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewClient viewClient=new ViewClient();
                view.setVisible(false);
                viewClient.setVisible(true);
                //Adaugarea unui client la baza de date

                viewClient.addClientListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String idInput="", ageInput="";
                        int idC, ageC;
                        idInput=viewClient.getUserIdClient();
                        idC=Integer.parseInt(idInput);
                        ageInput=viewClient.getAgeClient();
                        ageC=Integer.parseInt(ageInput);
                        Client client=new Client(idC, viewClient.getNameClient(), viewClient.getAddressClient(), ageC);
                        ClientBLL clientBLL=new ClientBLL();
                        clientBLL.insertClient(client);
                    }
                });
                //UPDATE CLIENT
                viewClient.updateClientListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ageInput="", nameInput="";
                        int ageC;
                        ageInput=viewClient.getAgeClient();
                        ageC=Integer.parseInt(ageInput);
                        nameInput=viewClient.getNameClient();
                        ClientBLL clientBLL=new ClientBLL();
                        clientBLL.updateClient(nameInput, ageC);
                    }
                });
                //DELETE CLIENT
                viewClient.deleteClientListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nameInput="";
                        nameInput=viewClient.getNameClient();
                        ClientBLL clientBLL=new ClientBLL();
                        clientBLL.deleteClient(nameInput);
                    }
                });
                //SHOW TABLE CLIENT
                viewClient.ShowClientTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       ClientBLL clientBLL=new ClientBLL();
                        List<Client> clienti= null;
                        try {
                            clienti = clientBLL.showAll();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Table<Client> tabel=new Table<Client>(clienti);
                        } catch (IllegalAccessException | NoSuchFieldException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                viewClient.BackClientButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewClient.setVisible(false);
                        view.setVisible(true);
                    }
                });
            }
        });

        //Pentru afisarea interfetei Products
        this.viewProduct=viewProduct;
        this.view.productShowTableListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewProduct viewProduct=new ViewProduct();
                view.setVisible(false);
                viewProduct.setVisible(true);
                //ADD PRODUCT
                viewProduct.addProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Product produs=new Product(viewProduct.getUserIdProduct(), viewProduct.getNameProduct(), viewProduct.getStocProduct(), viewProduct.getPriceProduct());
                        ProductBLL productBLL=new ProductBLL();
                        productBLL.insertProduct(produs);
                    }
                });
                //UPDATE PRODUCT
                viewProduct.updateProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL=new ProductBLL();
                        productBLL.updateProduct(viewProduct.getNameProduct(),viewProduct.getStocProduct());
                    }
                });
                //DELETE PRODUCT
                viewProduct.deleteProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL=new ProductBLL();
                        productBLL.deleteProduct(viewProduct.getNameProduct());
                    }
                });
               //VIEW TABLE
                viewProduct.ShowProductTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ProductBLL productBLL=new ProductBLL();
                        List<Product> produse= null;
                        try {
                            produse = productBLL.showAll();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Table<Product> tabel=new Table<Product>(produse);
                        } catch (IllegalAccessException | NoSuchFieldException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                viewProduct.BackProductListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewProduct.setVisible(false);
                        view.setVisible(true);
                    }
                });

            }
        });
        //Pentru afisarea interfetei Order
        this.viewOrder=viewOrder;
        this.view.orderShowTableListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewOrder viewOrder=new ViewOrder();
                view.setVisible(false);
                viewOrder.setVisible(true);
                viewOrder.comboIdClient();
                viewOrder.comboIDProduct();

                //ADD ORDER
                viewOrder.addOrderListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ProductBLL productBLL=new ProductBLL();
                        OrderBLL orderBLL=new OrderBLL();

                        int stocCurent=productBLL.getStocCurent(viewOrder.getIdProductOrder());
                        int cantitateIntrodusa=viewOrder.getQuantityOrderInput();

                        if(stocCurent<cantitateIntrodusa)
                        {
                            JOptionPane.showMessageDialog(viewOrder, "Stoc insuficient!");
                        }
                        else
                        {
                            int stocNou=stocCurent-cantitateIntrodusa;
                            productBLL.updateStocProduct(stocNou, viewOrder.getIdProductOrder());
                            Order comanda=new Order(viewOrder.getIdOrderInput(),viewOrder.getQuantityOrderInput(), viewOrder.getIdClientOrder(), viewOrder.getIdProductOrder());
                            orderBLL.insertOrder(comanda);
                            orderBLL.bon(viewOrder.getIdOrderInput(), viewOrder.getIdClientOrder(), viewOrder.getIdProductOrder(), viewOrder.getQuantityOrderInput());
                        }
                    }
                });

                //DELETE ORDER
                viewOrder.deleteOrderListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OrderBLL orderBLL=new OrderBLL();
                        orderBLL.deleteOrder(viewOrder.getIdOrderInput());
                    }
                });

                //SHOW TABLE
                viewOrder.ShowOrderTableListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OrderBLL orderBLL=new OrderBLL();
                        List<Order> comenzi= null;
                        try {
                            comenzi = orderBLL.showAll();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            Table<Order> tabel=new Table<Order>(comenzi);
                        } catch (IllegalAccessException | NoSuchFieldException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                viewOrder.BackOrderListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewOrder.setVisible(false);
                        view.setVisible(true);
                    }
                });
            }
        });
    }
}
