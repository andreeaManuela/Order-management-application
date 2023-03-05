package Model;

/**
 * Aceasta clasa reprezinta tabelul product din baza de date si are urmatoarele atribute : idProduct ,nume produs, stoc si pret
 */

public class Product {
    private int idProduct;
    private String nameProduct;
    private int stoc;
    private int price;

    /**
     * Constructorul initializeaza obiecte noi
     * @param idProduct id ul unic al produsului, este cheie primara in tabel
     * @param nameProduct numele produsului
     * @param stoc
     * @param price pretul produsului
     */

    public Product(int idProduct, String nameProduct, int stoc, int price)
    {
        this.idProduct=idProduct;
        this.nameProduct=nameProduct;
        this.stoc=stoc;
        this.price=price;
    }

    /**
     *
     * @return id-ul produsului
     */

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     *
     * @return numele produsului
     */

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     *
     * @return stocul produsului
     */

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    /**
     *
     * @return pretul produsului
     */

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString()
    {
        return "Product : id=" + idProduct +", name: " +nameProduct+ ", stoc="+stoc+", price="+price;
    }
}
