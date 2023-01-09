package br.com.study.api;

import br.com.study.api.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJUnitMockitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJUnitMockitoApplication.class, args);

        User user = new User(1, "Felipe", "fsdiasdf@gmail.com", "123456");
    }

}
