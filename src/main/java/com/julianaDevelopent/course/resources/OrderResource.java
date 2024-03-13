package com.julianaDevelopent.course.resources;
import com.julianaDevelopent.course.entities.Order;
import com.julianaDevelopent.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// essa classe e um recurso web implementado por um controlador rest
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    // end ponto para ver se ta acessando os usuarios
    @Autowired
    private OrderService service;

    @GetMapping // Responde o metodo get da requisiçao HTTP
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
