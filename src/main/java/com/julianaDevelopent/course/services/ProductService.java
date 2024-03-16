
package com.julianaDevelopent.course.services;

import com.julianaDevelopent.course.entities.Category;
import com.julianaDevelopent.course.entities.Product;
import com.julianaDevelopent.course.repositories.CategoryRepository;
import com.julianaDevelopent.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Indica q e uma camada de serviço
public class ProductService { // Camada de serviço responsavel por realizar consultas sql
    @Autowired // --> indica q aqui tem uma injeçao de dependencia
    private ProductRepository repository;
    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }



}
