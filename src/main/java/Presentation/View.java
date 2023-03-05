package Presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.io.File;
import Presentation.ViewClient;

/**
 * Aceasta clasa se ocupa cu interfata grafica prin care utilizatorul poate interactiona cu programul
 * Aceasta interfata contine 3 butoane care ne directioneaza spre fiecare tabel
 */

public class View extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel labelTitlu;
    private JLabel table;
    private JButton butClient;
    private JButton butProdus;
    private JButton butOrder;

    /**
     * In aceasta metoda sunt toate atributele acestei clase : etichtele si butoanele
     */

    public View()  {
        setTitle("ORDER MANAGEMENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400, 400,400);

        panel=new JPanel();
        panel.setBorder(new EmptyBorder(100,100,100,100));
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        labelTitlu=new JLabel("ORDER MANAGEMENT APPLICATION");
        labelTitlu.setBounds(90,5,250,25);
        labelTitlu.setForeground(Color.WHITE);
        panel.add(labelTitlu);

       table=new JLabel("Choose table");
       table.setBounds(160,50,100,35);
       table.setForeground(Color.WHITE);
       panel.add(table);

       butClient=new JButton("CLIENTS");
       butClient.setBounds(155,95,105,30);
       panel.add(butClient);

       butProdus=new JButton("PRODUCTS");
       butProdus.setBounds(155,135,105,30);
       panel.add(butProdus);

       butOrder=new JButton("ORDERS");
       butOrder.setBounds(155,175,105,30);
       panel.add(butOrder);
    }

    /**
     * aceste metode adauga un ascultator pentru butoane
     * @param actionListener
     */

    public void clientShowTableListener(ActionListener actionListener)
    {
        this.butClient.addActionListener(actionListener);
    }

    public void productShowTableListener(ActionListener actionListener)
    {
        this.butProdus.addActionListener(actionListener);
    }

    public void orderShowTableListener(ActionListener actionListener)
    {
        this.butOrder.addActionListener(actionListener);
    }

}
