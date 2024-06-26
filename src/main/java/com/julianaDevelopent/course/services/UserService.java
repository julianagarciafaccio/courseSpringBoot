package com.julianaDevelopent.course.services;

import com.julianaDevelopent.course.entities.User;
import com.julianaDevelopent.course.repositories.UserRepository;
import com.julianaDevelopent.course.services.exceptions.DatabaseException;
import com.julianaDevelopent.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    public User update(Long id , User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateDate(entity , obj);
            return repository.save(entity);
        }  catch (EntityNotFoundException e){
            e.printStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }


}
