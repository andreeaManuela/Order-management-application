package Start;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * aceasta clasa creeaza o fereastra in care este afisat un tabel cu obiecte din baza de date. Obiectele pot fi : Client, Product si Order
 * @param <T>
 */

public class Table<T> extends JFrame{
    JFrame frame;
    JTable tabel;
    JScrollPane scroll;

    /**
     * Constructorul va crea tabelul generic cu celulele din fiecare tabel din baza de date
     * Se creaza capul de tabel , apoi pentru fiecare coloana se pune valoarea in tabel si se merge la urmatoarea linie
     * @param lista
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */

    //crearea tabelului
    public Table(List<T> lista) throws IllegalAccessException, NoSuchFieldException {
        frame= new JFrame();
        setTitle("TABEL" + lista.get(0).getClass().getName());

        Reflection<T> ref=new Reflection<T>();

        //creem capul de tabel (coloanele)
        int nrColoane=ref.retrieveheader(lista).size();
        String[] coloana=new String[nrColoane];
        for(int i=0; i<nrColoane;i++)
        {
            coloana[i]=ref.retrieveheader(lista).get(i).toString();
        }

        //iau valorile din tabel pentru fiecare coloana
        int nrLinii=lista.size();
        String[][] celulaTabel=new String[nrLinii][nrColoane];

        int linie=0, col;
        for(T t: lista)
        {
             col=0;
            for(Field field : t.getClass().getDeclaredFields())
            {
                field.setAccessible(true);
                Object value=field.get(t);
                //pune valoarea in celula
                celulaTabel[linie][col]=value.toString();
                //mergem la urmatoarea coloana
                col++;
            }
           linie++;
        }
        tabel=new JTable(celulaTabel,coloana);
        tabel.setBounds(100,100,100,100);
        scroll=new JScrollPane(tabel);
        frame.add(scroll);
        frame.setSize(500,200);
        frame.setVisible(true);

    }

}
