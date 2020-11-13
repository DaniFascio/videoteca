package it.sincrono.videoteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class, MongoAutoConfiguration.class, MongoDataAutoConfiguration.class
})

// Classe main

public class VideotecaApplication {


    public static void main(String[] args) {
        SpringApplication.run(VideotecaApplication.class, args);



    }

}