package boot.thymeleaf.fragment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FragmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FragmentApplication.class, args);
    }

}
