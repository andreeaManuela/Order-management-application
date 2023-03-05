package Model;

/**
 * Aceasta clasa reprezinta tabeleul clinet din baza de date cu atributele : id , nume, adresa, varsta
 */

public class Client {
    private int ID;
    private String Name;
    private int Age;
    private String Address;

    /**
     * Constructorul initializeaza obiecte noi
     * @param ID este unic si este cheie primara in tabel
     * @param name este numele clientului
     * @param address
     * @param age varsta clientului
     */

    public Client(int ID, String name, String address, int age)
    {
       this.ID=ID;
       this.Name=name;
       this.Address=address;
       this.Age=age;
    }

    /**
     * metoda de get
     * @return id client
     */

    public int getID() {
        return ID;
    }

    /**
     * Metoda de set
     * @param ID seteaza o noua valoare atributului
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @return nume client
     */

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    /**
     * @return adresa clientului
     */

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    /**
     * @return vartsa clientului
     */

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String toString()
    {
        return "Client : id= " +ID + ", name :" +Name + ", address: "+ Address + ", age="+Age;
    }
}
