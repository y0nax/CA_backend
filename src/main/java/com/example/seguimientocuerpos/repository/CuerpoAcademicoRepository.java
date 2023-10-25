package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.CuerpoAcademico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuerpoAcademicoRepository extends MongoRepository<CuerpoAcademico,String> {
}
