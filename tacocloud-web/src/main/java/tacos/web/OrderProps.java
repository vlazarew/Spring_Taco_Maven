package tacos.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "taco.orders")
@Validated
@Data
public class OrderProps {

    @Min(value = 5, message = "Должно быть между 5 и 25")
    @Max(value = 25, message = "Должно быть между 5 и 25")
    private int pageSize = 20;
}
