package br.com.iniflex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.iniflex")
public class SimplesCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplesCrudApplication.class, args);
    }

}
