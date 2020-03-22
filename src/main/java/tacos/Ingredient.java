package tacos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingredient {

    @Id
    @Column(name = "id")
    private  final String id;

    @Column(name = "name")
    private final String name;

    @Column(name = "type")
    @Enumerated (EnumType.STRING)
    private final Type type;

    // Виды ингредиентов (лаваш, белки, овощи, сыр, соус)
    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
