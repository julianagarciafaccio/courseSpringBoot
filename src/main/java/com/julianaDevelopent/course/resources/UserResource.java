package com.julianaDevelopent.course.resources;
import com.julianaDevelopent.course.entities.User;
import com.julianaDevelopent.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// essa classe e um recurso web implementado por um controlador rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    // end ponto para ver se ta acessando os usuarios
    @Autowired
    private UserService service;

    @GetMapping // Responde o metodo get da requisiçao HTTP
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
