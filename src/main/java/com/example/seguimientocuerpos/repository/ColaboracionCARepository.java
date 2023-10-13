package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.ColaboracionCA;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboracionCARepository extends MongoRepository<ColaboracionCA,String> {
}
