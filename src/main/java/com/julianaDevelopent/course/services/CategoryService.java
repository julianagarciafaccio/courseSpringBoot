package com.julianaDevelopent.course.services;

import com.julianaDevelopent.course.entities.Category;
import com.julianaDevelopent.course.entities.Order;
import com.julianaDevelopent.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service //Indica q e uma camada de serviço
public class CategoryService { // Camada de serviço responsavel por realizar consultas sql
    @Autowired // --> indica q aqui tem uma injeçao de dependencia
    private CategoryRepository repository;
    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }



}
