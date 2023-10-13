package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ProduccionAcademica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduccionAcademicaRepository extends MongoRepository<ProduccionAcademica,String> {
}
