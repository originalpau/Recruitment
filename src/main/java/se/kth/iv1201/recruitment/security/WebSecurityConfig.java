package se.kth.iv1201.recruitment.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configurations to secure our web app.
 * Handles authorization, authentication and protection for common attacks, with the Spring Security framework.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * Configurations using Spring Security's FilterChain.
     * All requests going to /register, /login and /error are permitted without being authenticated first.
     * Any other pages cannot be accessed before successful authentication.
     * Requests to /applications are only allowed if the user has role "recruiter".
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/applications").hasAuthority("recruiter")
                .antMatchers("/register**", "/error", "/js/**", "/css/**", "/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .httpBasic();

        return http.build();
    }


    /**
     * Encodes passwords with Bcrypt hashing function.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}