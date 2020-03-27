package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.Ingredient;
import tacos.User;
import tacos.data.IngredientRepository;
import tacos.data.UserRepository;
import tacos.Ingredient.Type;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository, UserRepository userRepository,
                                        PasswordEncoder passwordEncoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));


                userRepository.save(new User("vlazarew", passwordEncoder.encode("123"),
                        "Владимир Лазарев", "Березовая роща 24/1", "Воронеж",
                        "Воронежская область", "394000", "123-123-1234"));
            }
        };
    }

}
