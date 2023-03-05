package Start;

import Model.Client;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa utilizeaza reflectia pentru a extrage campurile din lista de obiecte data ca parametru
 * @param <T>
 */

public class Reflection<T> {
    //extrage proprietatiile obiectelor folosind reflectie
    public static void retrieveProperties(Object object)
    {
        //pentru fiecare field se ia numele din clasa
        for(Field field: object.getClass().getDeclaredFields())
        {
            //metoda de get() folosita pentru a lua valoarea din field a obiectului
            field.setAccessible(true); //set modifier to public
            Object value;
            try{
                value=field.get(object);
                System.out.println(field.getName()+ "="+value);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    //* Extrag numele coloanelor si returneaza o lista */
    public  List<T> retrieveheader(List<T> object) {
        List<T> lista=new ArrayList<>();
        T obiect= object.get(0);
        for (Field field : obiect.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.getName();
                lista.add((T) value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
        return lista;
    }

}
