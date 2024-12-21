//package Electricity.Billing.System.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable() // Disable CSRF for testing purposes
//            .authorizeRequests()
//            .requestMatchers("/admin/**").permitAll() // Allow all admin endpoints
//            .requestMatchers("/customer/**").permitAll() // Allow all customer endpoints
//            .anyRequest().authenticated() // Require authentication for other requests
//            .and()
//            .formLogin().disable(); // Disable default login for testing
//        
//        
//    }
//    
//}

