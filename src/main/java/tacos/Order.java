package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @NotBlank(message = "Имя получателя обязательно")
    private String deliveryName;

    @NotBlank(message = "Улица получателя обязательна")
    private String deliveryStreet;

    @NotBlank(message = "Горож получателя обязателен")
    private String deliveryCity;

    @NotBlank(message = "Регион получателя обязателен")
    private String deliveryState;

    @NotBlank(message = "Почтовый индкс получателя обязателнг")
    private String deliveryZip;

    @CreditCardNumber(message = "Номер кредитной карты получателя обязателен")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Дата окончания карты обязательна")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Некорректный код CVV")
    private String ccCVV;

    @ManyToMany(targetEntity = Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void PlacedAt() {
        this.placedAt = new Date();
    }

}
