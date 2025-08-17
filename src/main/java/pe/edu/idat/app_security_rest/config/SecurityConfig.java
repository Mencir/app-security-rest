package pe.edu.idat.app_security_rest.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import pe.edu.idat.app_security_rest.model.UserModel;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        UserModel adminModel = new UserModel("admin", "1234", "ADMIN");
        UserModel userModel = new UserModel("user", "abcd", "USER");

        UserDetails admin = User.withUsername(adminModel.getUsername())
                .password("{noop}" + adminModel.getPassword())
                .roles(adminModel.getRole())
                .build();

        UserDetails user = User.withUsername(userModel.getUsername())
                .password("{noop}" + userModel.getPassword())
                .roles(userModel.getRole())
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {});

        return http.build();
    }

}