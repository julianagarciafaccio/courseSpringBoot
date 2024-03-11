package com.julianaDevelopent.course.config;

import com.julianaDevelopent.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.julianaDevelopent.course.entities.User;

import java.util.Arrays;
// CLASSE DE CONFIGURAÇAO PARA INSTANCIAR O BANCO DE DADOS
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    // CLASSE USADA PARA EXCECUTAR OQ TA NELA QUANDO A APLICAÇAO INICIALIZAR
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null  ,"Juliana Garcia" , "juGarcia@hotmail.com" , "996570617" , "#ju1911");

        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}
