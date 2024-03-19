package com.julianaDevelopent.course.services;

import com.julianaDevelopent.course.entities.User;
import com.julianaDevelopent.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Indica q e uma camada de serviço
public class UserService  { // chama user service pq e uma camada de serviço onde porEx eu to fazendo consultas sql
    @Autowired // indica q aqui tem uma injeçao de dependencia
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }



}
