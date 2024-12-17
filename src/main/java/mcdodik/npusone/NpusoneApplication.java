package mcdodik.npusone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NpusoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NpusoneApplication.class, args);
    }

}
