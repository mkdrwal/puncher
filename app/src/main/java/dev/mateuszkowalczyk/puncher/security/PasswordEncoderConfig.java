package dev.mateuszkowalczyk.puncher.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(String plainPassword) {
                return plainPassword;
            }

            @Override
            public boolean matches(String plainPassword, String encodedPassword) {
                return plainPassword.equals(encodedPassword);
            }
        };
    }

}
