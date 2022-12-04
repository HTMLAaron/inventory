package test.inventory.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Aaron
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   
    
    private int productid;    
    private int quantity;
    private String location;
        

    public Inventory(){}
    
    public Inventory(int id, int productid, String location,int quantity) {
        this.id = id;
        this.productid = productid;
        this.quantity = quantity;
        this.location = location;
        }
    
    public Inventory(int productid, String location,int quantity) {
        this.productid = productid;
        this.quantity = quantity;
        this.location = location;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}