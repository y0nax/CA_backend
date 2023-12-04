package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ColaboracionCA;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboracionCARepository extends MongoRepository<ColaboracionCA,String> {

    @Query("{'fechaInicio' : {$regex:  ?0 }}")
    List<ColaboracionCA> findByAnio(String anio);

    List<ColaboracionCA> findByTipo(String tipo);

    List<ColaboracionCA> findByIntegrantesIdCa(String idCa);
}
