package com.julianaDevelopent.course.resources;
import com.julianaDevelopent.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// essa classe e um recurso web implementado por um controlador rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    // end ponto para ver se ta acessando os usuarios
    @GetMapping // Responde o metodo get da requisiçao HTTP
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"maria","maria@got" , "9999999" , "12345");
        return ResponseEntity.ok().body(u);
    }



}
