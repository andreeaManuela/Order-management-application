package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * aceasta clasa creeaza interfata grafica care interactioneaza cu baza de date
 * Avem 5 butoane : un buton pentru adaugarea clientilor , pentru actualizare, pentru stergerea , afisarea clientilor intr-un tabel
 * si pentru intoarcerea la meniul principal
 */

public class ViewClient extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JButton addClient;
    private JButton updateClient;
    private JButton deleteClient;
    private JButton showTableClient;
    private JButton inapoi;
    private JLabel idClient;
    private JLabel nameCl;
    private JLabel ageClient;
    private JLabel addressClient;
    private JTextField idText;
    private JTextField nameText;
    private JTextField ageText;
    private JTextField addressText;

    /**
     * Aceasta metoda contine toate atributele interfetei
     */

    public ViewClient()
    {
       setTitle("CLIENT");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(500,500,500,500);

        panel=new JPanel();
        panel.setBorder(new EmptyBorder(100,100,100,100));
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        idClient=new JLabel("ID CLIENT:");
        idClient.setBounds(10,10,100,35);
        panel.add(idClient);

        idText=new JTextField();
        idText.setBounds(80,15,100,25);
        panel.add(idText);
        idText.setColumns(10);

        nameCl=new JLabel("NAME:");
        nameCl.setBounds(10,40,100,35);
        panel.add(nameCl);

        nameText=new JTextField();
        nameText.setBounds(80,45,100,25);
        panel.add(nameText);
        nameText.setColumns(10);

        addressClient=new JLabel("ADDRESS:");
        addressClient.setBounds(10,70,100,35);
        panel.add(addressClient);

        addressText=new JTextField();
        addressText.setBounds(80,75,100,25);
        panel.add(addressText);
        addressText.setColumns(10);

        ageClient=new JLabel("AGE:");
        ageClient.setBounds(10,100,100,35);
        panel.add(ageClient);

        ageText=new JTextField();
        ageText.setBounds(80,105,100,25);
        panel.add(ageText);
        ageText.setColumns(10);

        addClient=new JButton("ADD CLIENT");
        addClient.setBounds(100,150,130,30);
        panel.add(addClient);

        updateClient=new JButton("EDIT CLIENT");
        updateClient.setBounds(250,150,130,30);
        panel.add(updateClient);

        deleteClient=new JButton("DELETE CLIENT");
        deleteClient.setBounds(100,195,130,30);
        panel.add(deleteClient);

        showTableClient=new JButton("SHOW TABLE");
        showTableClient.setBounds(250,195,130,30);
        panel.add(showTableClient);

        inapoi=new JButton("BACK");
        inapoi.setBounds(190,235,130,30);
        panel.add(inapoi);
    }

    /**
     * Aceaste metode extrag stringul din textfield
     * @return
     */

    public String getUserIdClient()
    {
        return this.idText.getText();
    }

    public String getNameClient()
    {
        return this.nameText.getText();
    }

    public String getAddressClient()
    {
        return this.addressText.getText();
    }

    public String getAgeClient()
    {
        return this.ageText.getText();
    }

    /**
     * Aceste metode adauga un ascultator la butoane
     * @param actionListener
     */

    public void addClientListener(ActionListener actionListener)
    {
        this.addClient.addActionListener(actionListener);
    }

    public void updateClientListener(ActionListener actionListener)
    {
        this.updateClient.addActionListener(actionListener);
    }

    public void deleteClientListener(ActionListener actionListener)
    {
        this.deleteClient.addActionListener(actionListener);
    }

    public void ShowClientTableListener(ActionListener actionListener)
    {
        this.showTableClient.addActionListener(actionListener);
    }

    public void BackClientButtonListener(ActionListener actionListener)
    {
        this.inapoi.addActionListener(actionListener);
    }

}
