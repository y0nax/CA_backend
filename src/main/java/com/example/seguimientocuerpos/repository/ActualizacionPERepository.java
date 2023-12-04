package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ActualizacionPE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualizacionPERepository extends MongoRepository<ActualizacionPE,String> {

    @Query("{'fecha' : {$regex:  ?0 }}")
    List<ActualizacionPE> findByAnio(String anio);

    List<ActualizacionPE> findByNivel(String nivel);

    List<ActualizacionPE> findByArea(String area);

    List<ActualizacionPE> findByIntegrantesIdCa(String idCa);
}
