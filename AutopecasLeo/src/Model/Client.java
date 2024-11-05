/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author gabri
 */
public class Client {
    private int Id;
    private String Name;
    private String Address;
    private String Distric;
    
    public Client() {
    }

    public Client(int Id, String Name, String Address, String Distric) {
        this.Id = Id;
        this.Name = Name;
        this.Address = Address;
        this.Distric = Distric;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDistric() {
        return Distric;
    }

    public void setDistric(String Distric) {
        this.Distric = Distric;
    }  
}
