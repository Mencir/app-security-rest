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

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/security/admin").hasRole("ADMIN")
                        .requestMatchers("/api/v1/security/user").hasRole("USER")
                        .requestMatchers("/api/v1/security/hello").authenticated()
                        .anyRequest().denyAll()
                )
                .httpBasic(httpBasic -> {}); // API moderna Spring Security 6.1

        return http.build();
    }


}