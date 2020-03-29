package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import tacos.Ingredient;
import tacos.User;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;
import tacos.data.UserRepository;
import tacos.Ingredient.Type;

import java.util.Arrays;

@Profile("!prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    public PasswordEncoder encoder() {
//    return new StandardPasswordEncoder("53cr3t");
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository, UserRepository userRepository,
                                        PasswordEncoder passwordEncoder, TacoRepository tacoRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Ingredient flourTortilla = new Ingredient("FLTO", "Лаваш торлтилья", Type.WRAP);
                Ingredient cornTortilla = new Ingredient("COTO", "Кукурузная лепешка", Type.WRAP);
                Ingredient groundBeef = new Ingredient("GRBF", "Говяжий фарш", Type.PROTEIN);
                Ingredient carnitas = new Ingredient("CARN", "Карнитас (ассорти)", Type.PROTEIN);
                Ingredient tomatoes = new Ingredient("TMTO", "Нарезанные кубиками помидоры", Type.VEGGIES);
                Ingredient lettuce = new Ingredient("LETC", "Салат", Type.VEGGIES);
                Ingredient cheddar = new Ingredient("CHED", "Чеддер", Type.CHEESE);
                Ingredient jack = new Ingredient("JACK", "Монтеррей Джек\n", Type.CHEESE);
                Ingredient salsa = new Ingredient("SLSA", "Сальса", Type.SAUCE);
                Ingredient sourCream = new Ingredient("SRCR", "Сметана", Type.SAUCE);
                ingredientRepository.save(flourTortilla);
                ingredientRepository.save(cornTortilla);
                ingredientRepository.save(groundBeef);
                ingredientRepository.save(carnitas);
                ingredientRepository.save(tomatoes);
                ingredientRepository.save(lettuce);
                ingredientRepository.save(cheddar);
                ingredientRepository.save(jack);
                ingredientRepository.save(salsa);
                ingredientRepository.save(sourCream);


                userRepository.save(new User("vlazarew", passwordEncoder.encode("123"),
                        "Владимир Лазарев", "Березовая роща 24/1", "Воронеж",
                        "Воронежская область", "394000", "123-123-1234"));

                Taco taco1 = new Taco();
                taco1.setName("Carnivore");
                taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
                tacoRepository.save(taco1);

                Taco taco2 = new Taco();
                taco2.setName("Bovine Bounty");
                taco2.setIngredients(Arrays.asList(cornTortilla, groundBeef, cheddar, jack, sourCream));
                tacoRepository.save(taco2);

                Taco taco3 = new Taco();
                taco3.setName("Veg-Out");
                taco3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
                tacoRepository.save(taco3);
            }
        };
    }

}
