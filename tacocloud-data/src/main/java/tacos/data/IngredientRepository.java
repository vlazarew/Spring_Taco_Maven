package tacos.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tacos.Ingredient;

import java.util.List;

@CrossOrigin(origins = "*")
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
