package test.inventory.dao;

import java.util.List;
import test.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Aaron
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    
    //@Query("select * from inventory i where i.ID = ?1")
    //List<Inventory> findInventoryById(int id);
    Inventory findByProductidAndLocation(int productid,String location);
}
