package Presentation;

import Connection.ConnectionFactory;
import DAO.ClientDAO;
import Model.Client;
import Model.Product;
import Start.Reflection;
import bll.ClientBLL;
import bll.ProductBLL;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * aceasta clasa creeaza interfata grafica care interactioneaza cu baza de date
 * Avem 4 butoane : un buton pentru adaugarea comenzilor , pentru stergerea , afisarea comenzilor intr-un tabel si un buton pentru a te intoarce la interfata principala
 */

public class ViewOrder extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JButton addOrder;
    private JButton deleteOrder;
    private JButton showTableOrder;
    private JButton inapoi;
    private JLabel idOrder;
    private JLabel idClient;
    private JLabel idProduct;
    private JLabel quantity;
    private JTextField idText;
    private JComboBox idCli;
    private JComboBox idProd;
    private JTextField quantityText;

    /**
     *   Aceasta metoda contine toate atributele interfetei
     *
     */

    public ViewOrder() {
        setTitle("ORDER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,500,500,500);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(100, 100, 100, 100));
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        idOrder=new JLabel("ID ORDER:");
        idOrder.setBounds(10,10,100,35);
        panel.add(idOrder);

        idText=new JTextField();
        idText.setBounds(120,15,100,25);
        panel.add(idText);
        idText.setColumns(10);

        idClient=new JLabel("ID CLIENT:");
        idClient.setBounds(10,40,110,35);
        panel.add(idClient);

        //obtinerea id-urilor clienti din baza de date

        idCli=new JComboBox<Client>();
        idCli.setBounds(120,45,100,25);
        panel.add(idCli);

        idProduct=new JLabel("ID PRODUCT:");
        idProduct.setBounds(10,70,100,35);
        panel.add(idProduct);

        //obtinerea id-urilor de produse din baza de date

        idProd=new JComboBox<Product>();
        idProd.setBounds(120,75,100,25);
        panel.add(idProd);

        quantity=new JLabel("QUANTITY:");
        quantity.setBounds(10,100,100,35);
        panel.add(quantity);

        quantityText=new JTextField();
        quantityText.setBounds(120,105,100,25);
        panel.add(quantityText);
        quantityText.setColumns(10);

        addOrder=new JButton("ADD ORDER");
        addOrder.setBounds(100,150,150,30);
        panel.add(addOrder);

        deleteOrder=new JButton("DELETE ORDER");
        deleteOrder.setBounds(250,150,150,30);
        panel.add(deleteOrder);

        showTableOrder=new JButton("SHOW TABLE");
        showTableOrder.setBounds(250,195,150,30);
        panel.add(showTableOrder);

        inapoi=new JButton("BACK");
        inapoi.setBounds(100,195,150,30);
        panel.add(inapoi);

    }

    /**
     * Aceasta metoda extrage stringul din texfield si il converteste in int
     * @return
     */

    public int getIdOrderInput()
    {
        String idString="";
        int idInt;
        idString=idText.getText();
        idInt=Integer.parseInt(idString);
        return idInt;
    }

    /**
     * aceasta metoda selecteaza optiunea din combobox facuta de utilizator
     * @return
     */

    public int getIdClientOrder()
    {
        return (int) idCli.getSelectedItem();
    }

    public int getIdProductOrder() {
        return (int) idProd.getSelectedItem();
    }

    public void comboIdClient()
    {
        try{
            Connection connection=ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT ID FROM client");
            while(rs.next())
            {
                 idCli.addItem(rs.getInt(1));
            }
            connection.close();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Couldn't connect to db","Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void comboIDProduct()
    {
        try{
            Connection connection=ConnectionFactory.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT idProduct FROM product");
            while(rs.next())
            {
                idProd.addItem(rs.getInt(1));
            }
            connection.close();
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Couldn't connect to db","Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public int getQuantityOrderInput()
    {
        String cantitate="";
        int cantitateOrder;
        cantitate=this.quantityText.getText();
        cantitateOrder=Integer.parseInt(cantitate);
        return  cantitateOrder;
    }

    /**
     * Aceste metode adauga un ascultator pentru butoane
     * @param actionListener
     */

    public void addOrderListener(ActionListener actionListener)
    {
        this.addOrder.addActionListener(actionListener);
    }

    public void deleteOrderListener(ActionListener actionListener)
    {
        this.deleteOrder.addActionListener(actionListener);
    }

    public void ShowOrderTableListener(ActionListener actionListener)
    {
        this.showTableOrder.addActionListener(actionListener);
    }

    public void BackOrderListener(ActionListener actionListener)
    {
        this.inapoi.addActionListener(actionListener);
    }
}
