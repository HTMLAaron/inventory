package test.inventory.dao;

import test.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import test.inventory.model.product;

/**
 *
 * @author Aaron
 */
public interface productRepository extends JpaRepository<product, Integer>{
    
}
