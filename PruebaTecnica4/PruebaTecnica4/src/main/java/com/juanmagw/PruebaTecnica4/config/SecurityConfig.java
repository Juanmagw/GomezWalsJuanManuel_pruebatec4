package com.juanmagw.PruebaTecnica4.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests()
                .requestMatchers("/agency/flights/all").permitAll()
                .requestMatchers("/agency/flights/allActive").permitAll()
                .requestMatchers("/agency/flights/dates-travel").permitAll()
                .requestMatchers("/agency/flights/{id}").permitAll()
                .requestMatchers("/agency/hotels/all").permitAll()
                .requestMatchers("/agency/hotels/allActive").permitAll()
                .requestMatchers("/agency/hotels/dates-travel").permitAll()
                .requestMatchers("/agency/hotels/{id}").permitAll()
                .requestMatchers("/agency/rooms/all").permitAll()
                .requestMatchers("/agency/rooms/allActive").permitAll()
                .requestMatchers("/agency/rooms/{id}").permitAll()
                .requestMatchers("/agency/clients/all").permitAll()
                .requestMatchers("/agency/clients/allActive").permitAll()
                .requestMatchers("/agency/clients/{id}").permitAll()
                .requestMatchers("/agency/flight-booking/all").permitAll()
                .requestMatchers("/agency/flight-booking/allActive").permitAll()
                .requestMatchers("/agency/flight-booking/{id}").permitAll()
                .requestMatchers("/agency/room-booking/all").permitAll()
                .requestMatchers("/agency/room-booking/allActive").permitAll()
                .requestMatchers("/agency/room-booking/{id}").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .build();
    }
}*/