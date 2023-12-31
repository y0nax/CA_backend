package com.example.seguimientocuerpos.repository;

import com.example.seguimientocuerpos.model.Minuta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MinutaRepository extends MongoRepository<Minuta, String> {
    List <Minuta> findByTipo (String tipo);
}
