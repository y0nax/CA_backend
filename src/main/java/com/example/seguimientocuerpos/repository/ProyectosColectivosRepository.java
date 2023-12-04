package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ProyectosColectivos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectosColectivosRepository extends MongoRepository<ProyectosColectivos,String> {

    @Query("{'fechaInicio' : {$regex:  ?0 }}")
    List<ProyectosColectivos> findByAnio(String añio);

    List<ProyectosColectivos> findByIntegrantesIdUsuario (String idUsuario);

    List<ProyectosColectivos> findByIdCa (String idCa);

}
