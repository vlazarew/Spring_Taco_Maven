package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    // Виды ингридиентов (лаваш, белки, овощи, сыр, соус)
    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

//    public Ingredient(String id, String name, Type type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }

}
