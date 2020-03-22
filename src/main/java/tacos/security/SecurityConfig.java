package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userRepositoryUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/design", "/orders").access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll()")
        .and().formLogin().loginPage("/login")
        .and().logout().logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.ldapAuthentication().
//                userSearchFilter("(uid={0})").
//                groupSearchFilter("member={0}")
//                .passwordCompare().
//                passwordEncoder(new BCryptPasswordEncoder()).
//                passwordAttribute("authentication_string");
//    }

//    @Autowired
//    DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
//                "select user, authentication_string, account_locked from mysql.Users " +
//                        "where username = ?").authoritiesByUsernameQuery("" +
//                "show grants for ?)").passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//    }

    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("buzz").password("infinity").authorities("ROLE_USER").and()
//                .withUser("woody").password("bullseye").authorities("ROLE_USER");
//    }
}
