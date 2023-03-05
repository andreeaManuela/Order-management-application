package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * aceasta clasa creeaza interfata grafica care interactioneaza cu baza de date
 * Avem 5 butoane : un buton pentru adaugarea produselor , pentru actualizare, pentru stergerea , afisarea produselor intr-un tabel
 * si pentru intoarcerea la meniul principal
 */

public class ViewProduct extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JButton addProd;
    private JButton updateProd;
    private JButton deleteProd;
    private JButton showTableProd;
    private JButton inapoi;
    private JLabel id;
    private JLabel nameProduct;
    private JLabel stocProd;
    private JLabel priceProduc;
    private JTextField idText;
    private JTextField nameText;
    private JTextField stocText;
    private JTextField priceText;

    /**
     *    Aceasta metoda contine toate atributele interfetei
     *
     */

    public ViewProduct()
    {
        setTitle("PRODUCT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,500,500,500);

        panel=new JPanel();
        panel.setBorder(new EmptyBorder(100,100,100,100));
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

      /*  tabel=new JPanel();
        tabel.setBorder(new EmptyBorder(200,200,200,200));
        setContentPane(tabel);
        tabel.setBackground(Color.orange);*/

        id=new JLabel("ID PRODUCT:");
        id.setBounds(10,10,100,35);
        panel.add(id);

        idText=new JTextField();
        idText.setBounds(120,15,100,25);
        panel.add(idText);
        idText.setColumns(10);

        nameProduct=new JLabel("NAME PRODUCT:");
        nameProduct.setBounds(10,40,110,35);
        panel.add(nameProduct);

        nameText=new JTextField();
        nameText.setBounds(120,45,100,25);
        panel.add(nameText);
        nameText.setColumns(10);

        stocProd=new JLabel("STOC:");
        stocProd.setBounds(10,70,100,35);
        panel.add(stocProd);

        stocText=new JTextField();
        stocText.setBounds(120,75,100,25);
        panel.add(stocText);
        stocText.setColumns(10);

        priceProduc=new JLabel("PRICE:");
        priceProduc.setBounds(10,100,100,35);
        panel.add(priceProduc);

        priceText=new JTextField();
        priceText.setBounds(120,105,100,25);
        panel.add(priceText);
        priceText.setColumns(10);

        addProd=new JButton("ADD PRODUCT");
        addProd.setBounds(100,150,150,30);
        panel.add(addProd);

        updateProd=new JButton("EDIT PRODUCT");
        updateProd.setBounds(250,150,150,30);
        panel.add(updateProd);

        deleteProd=new JButton("DELETE PRODUCT");
        deleteProd.setBounds(100,195,150,30);
        panel.add(deleteProd);

        showTableProd=new JButton("SHOW TABLE");
        showTableProd.setBounds(250,195,150,30);
        panel.add(showTableProd);

        inapoi=new JButton("BACK");
        inapoi.setBounds(190,235,130,30);
        panel.add(inapoi);

    }

    /**
     * Aceasta metoda extrage stringul din texfield si il converteste in int
     *       @return
     *
     */

    public int getUserIdProduct()
    {
        String idInput;
        int idP;
        idInput=this.idText.getText();
        idP=Integer.parseInt(idInput);
        return idP;
    }

    public String getNameProduct()
    {
        return this.nameText.getText();
    }

    public int getStocProduct()
    {
        String inputStoc="";
        int stocP;
        inputStoc=this.stocText.getText();
        stocP=Integer.parseInt(inputStoc);
        return stocP;
    }


    public int getPriceProduct()
    {
        String inputPrice;
        int pret;
        inputPrice=this.priceText.getText();
        pret=Integer.parseInt(inputPrice);
        return pret;
    }

    /**
     * Aceste metode adauga un ascultator pentru butoane
     * @param actionListener
     */

    public void addProductListener(ActionListener actionListener)
    {
        this.addProd.addActionListener(actionListener);
    }

    public void updateProductListener(ActionListener actionListener)
    {
        this.updateProd.addActionListener(actionListener);
    }

    public void deleteProductListener(ActionListener actionListener)
    {
        this.deleteProd.addActionListener(actionListener);
    }

    public void ShowProductTableListener(ActionListener actionListener)
    {
        this.showTableProd.addActionListener(actionListener);
    }

    public void BackProductListener(ActionListener actionListener)
    {
        this.inapoi.addActionListener(actionListener);
    }
}
