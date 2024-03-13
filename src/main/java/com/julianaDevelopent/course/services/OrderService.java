package com.julianaDevelopent.course.services;

import com.julianaDevelopent.course.entities.Order;
import com.julianaDevelopent.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Indica q e uma camada de serviço
public class OrderService { // Camada de serviço responsavel por realizar consultas sql
    @Autowired // indica q aqui tem uma injeçao de dependencia
    private OrderRepository repository;
    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }



}
