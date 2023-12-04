package com.example.seguimientocuerpos.service;

import com.example.seguimientocuerpos.model.ActualizacionPE;
import com.example.seguimientocuerpos.repository.ActualizacionPERepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActualizacionPEService {

    private final ActualizacionPERepository actualizacionPERepository;

    public void save(ActualizacionPE actualizacionPE){
        actualizacionPERepository.save(actualizacionPE);
    }

    public List<ActualizacionPE> findAll(){
        return actualizacionPERepository.findAll();
    }

    public Optional<ActualizacionPE> findById(String id){
        return actualizacionPERepository.findById(id);
    }

    public void deleteById(String id){
        actualizacionPERepository.deleteById(id);
    }

    public List<ActualizacionPE> findByAnio(String anio){
        return actualizacionPERepository.findByAnio(anio);
    }

    public List<ActualizacionPE> findByNivel(String nivel){
        return actualizacionPERepository.findByNivel(nivel);
    }

    public List<ActualizacionPE> findByArea(String area){
        return actualizacionPERepository.findByArea(area);
    }

    public List<ActualizacionPE> findByIntegrantesIdCa(String idCa){
        return actualizacionPERepository.findByIntegrantesIdCa(idCa);
    }
}
