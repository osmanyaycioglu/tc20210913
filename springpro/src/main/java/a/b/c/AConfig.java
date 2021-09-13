package a.b.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AConfig {

    @Bean
    public A myA() {
        return new A();
    }

}
