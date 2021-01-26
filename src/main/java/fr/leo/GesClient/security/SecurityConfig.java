package fr.leo.GesClient.security;

/**
 * Classe de securité
 *
 * @author Léo
 */
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder bc = getBc();
        //AUTH JDBC
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username as principal, password as credentials, active  from users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username as principal, role as role from users_roles WHERE username = ? ")
                .rolePrefix("ROLE_")
                .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        //http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/user/*").hasRole("USER");

        //gestion des erreurs
        http.exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    public BCryptPasswordEncoder getBc() {
        return new BCryptPasswordEncoder();
    }

}
