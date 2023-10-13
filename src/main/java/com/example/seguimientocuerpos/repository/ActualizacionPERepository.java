package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ActualizacionPE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualizacionPERepository extends MongoRepository<ActualizacionPE,String> {
}
