package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.DireccionIndividual;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionIndividualRepository extends MongoRepository<DireccionIndividual,String> {

    @Query("{'fecha' : {$regex:  ?0 }}")
    List<DireccionIndividual> findByAnio(String añio);

    List<DireccionIndividual> findByIdCa(String idCa);

    List<DireccionIndividual> findByNivel(String nivel);
}
