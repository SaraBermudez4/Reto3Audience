package Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sara Bermudez
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryInterface crud;

    public List<Category> getAll() {
        return (List<Category>) crud.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }

    public Category save(Category category) {
        return crud.save(category);
    }

    public void delete(Category category) {
        crud.delete(category);
    }
}
