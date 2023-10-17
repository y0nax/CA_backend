package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ApoyoEconomico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoyoEconomicoRepository extends MongoRepository<ApoyoEconomico,String> {
}
