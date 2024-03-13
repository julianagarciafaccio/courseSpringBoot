package com.julianaDevelopent.course.repositories;

import com.julianaDevelopent.course.entities.Order;
import com.julianaDevelopent.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // opcional aqui pq ela herda do jpa repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //vai ser responsavel por fazer as operaçoes com o Order
    /* ESSA INTERFACE FORNECE OPERAÇOES PRONTAS DO CRUD, FACILITA A LISTAGEM DE DADOS,PERMITE CONSULTAS DINAMICAS E CUSTOMIZADAS
    TBM PERSISTE OS DADOS NA MEMORIA
     */



}
