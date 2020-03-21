package tacos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Наименование позиции должно быть не менее 5 символов.")
    private String name;

    @Size(min = 1, message = "Должно быть выбрано не менее одно ингридиента.")
    private List<Ingredient> ingredients;
}
