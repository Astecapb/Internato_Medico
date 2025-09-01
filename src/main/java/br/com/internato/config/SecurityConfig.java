package br.com.internato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita CSRF (ativa para produção depois)
                .csrf(csrf -> csrf.disable())

                // Autorização de requisições
                .authorizeHttpRequests(auth -> auth
                        // End-points públicos (ajuste ao padrão real dos seus controllers)
                        .requestMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        // Qualquer outra requisição exige autenticação
                        .anyRequest().authenticated()
                )

                // Autenticação básica (para testes/MVP)
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}