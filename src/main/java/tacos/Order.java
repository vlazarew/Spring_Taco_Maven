package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class Order {

    @NotBlank(message = "Имя получателя обязательно")
    private String name;

    @NotBlank(message = "Улица получателя обязательна")
    private String street;

    @NotBlank(message = "Горож получателя обязателен")
    private String city;

    @NotBlank(message = "Регион получателя обязателен")
    private String state;

    @NotBlank(message = "Почтовый индкс получателя обязателнг")
    private String zip;

    @CreditCardNumber(message = "Номер кредитной карты получателя обязателен")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Дата окончания карты обязательна")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Некорректный код CVV")
    private String ccCVV;
}
