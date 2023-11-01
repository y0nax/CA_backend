package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ProduccionAcademica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduccionAcademicaRepository extends MongoRepository<ProduccionAcademica,String> {
    @Query("{ 'fecha' : { $regex: ?0 } }")
    List <ProduccionAcademica> findByAnio(String anio);
    List<ProduccionAcademica> findByIntegrantesIdUsuario (String idUsuario);

    List <ProduccionAcademica> findByTipo (String tipo);
}
