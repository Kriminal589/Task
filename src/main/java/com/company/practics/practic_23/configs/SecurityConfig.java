package com.company.practics.practic_23.configs;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //Бин для генерации объекта класса BCrypt. В сервисе вызывается этот бин и шифрует пароль
    @Bean
    public static @NotNull BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Новая защита спринга. Раньше было лучше и удобнее
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> {
                    try {
                        authz
                                //Разрешаю всем доступ по этому запросу.
                                //Но при последнем запуске почему-то я не получил доступ
                                .requestMatchers("/students/registrations").permitAll()
                                .anyRequest().authenticated()
                                .and()
                                .formLogin();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                );
        return http.build();
    }
}
