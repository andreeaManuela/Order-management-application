package Model;

/**
 * Aceasta clasa reprezinta tabelul din baza de date Order care are urmatoarele atribute : id comanda , id produs , id client si cantitate
 */

public class Order {
    private int idOrder;
    private int idClient;
    private int idProduct;
    private int quantity;

    /**
     * Constructorul initializeaza obiecte noi
     * @param idOrder id comenzii
     * @param idClient id clientului
     * @param idProduct id produs
     * @param quantity cantitate
     */

    public Order(int idOrder, int idClient, int idProduct, int quantity)
    {
        this.idOrder=idOrder;
        this.idClient=idClient;
        this.idProduct=idProduct;
        this.quantity=quantity;
    }

    /**
     *
     * @return id-ul comenzii
     */

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    /**
     *
     * @return id-ul clientului
     */

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
     * @return cantitate
     */

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString()
    {
        return "Order: idOrder="+idOrder + ", ClientId="+idClient+", ProductId="+idProduct+" Stoc="+quantity;
    }
}
