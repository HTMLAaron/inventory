package test.inventory.dao;

import test.inventory.model.category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Aaron
 */
public interface CategoryRepository extends JpaRepository<category, String>{
    
    
}
