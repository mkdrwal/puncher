package dev.mateuszkowalczyk.puncher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PuncherApplication {
    public static void main(String[] args) {
        SpringApplication.run(PuncherApplication.class, args);
    }
}
