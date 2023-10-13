package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.DireccionIndividual;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionIndividualRepository extends MongoRepository<DireccionIndividual,String> {
}
