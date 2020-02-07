package com;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;

@SpringBootApplication
@EnableJpaRepositories
public class AddressBookApplication {

    public static void main(String[] args) {
        ApplicationContext contexto = new SpringApplicationBuilder(AddressBookApplication.class)
                .headless(false)
                .run(args);
        //changes

        EventQueue.invokeLater(() -> {

            AddressBookView ex = contexto.getBean(AddressBookView.class);
            ex.setVisible(true);
        });
    }

}