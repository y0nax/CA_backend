package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ProyectosColectivos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosColectivosRepository extends MongoRepository<ProyectosColectivos,String> {
}
