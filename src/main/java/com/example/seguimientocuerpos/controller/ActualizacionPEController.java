package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ActualizacionPE;
import com.example.seguimientocuerpos.service.ActualizacionPEService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ActualizacionPEController {

    private final ActualizacionPEService actualizacionPEService;

    @PostMapping("/actualizacionPE")
    public void save(@RequestBody ActualizacionPE actualizacionPE){
        actualizacionPEService.save(actualizacionPE);
    }

    @GetMapping("/actualizacionPEs")
    public List<ActualizacionPE> findAll(){
        return actualizacionPEService.findAll();
    }

    @GetMapping("/actualizacionPE/{id}")
    public ActualizacionPE findById(@PathVariable String id){
        return actualizacionPEService.findById(id).get();
    }

    @GetMapping("/actualizacionPEA/{anio}")
    public ResponseEntity<Object> findByAnio(@PathVariable String anio){
        if(actualizacionPEService.findByAnio(anio).size()>0)
            return new ResponseEntity<>(actualizacionPEService.findByAnio(anio), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/actualizacionPEN/{nivel}")
    public ResponseEntity<Object> findByNivel(@PathVariable String nivel){
        if(actualizacionPEService.findByNivel(nivel).size()>0)
            return new ResponseEntity<>(actualizacionPEService.findByNivel(nivel), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/actualizacionPEAR/{area}")
    public ResponseEntity<Object> findByArea(@PathVariable String area){
        if(actualizacionPEService.findByArea(area).size()>0)
            return new ResponseEntity<>(actualizacionPEService.findByArea(area), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/actualizacionPEC/{idCa}")
    public ResponseEntity<Object> findByIntegrantesIdCa(@PathVariable String idCa){
        if(actualizacionPEService.findByIntegrantesIdCa(idCa).size()>0)
            return new ResponseEntity<>(actualizacionPEService.findByIntegrantesIdCa(idCa), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/actualizacionPE/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(actualizacionPEService.findById(id).get().getIdUsuario().equals(id_usuario)){
            actualizacionPEService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/actualizacionPE/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ActualizacionPE actualizacionPE, @PathVariable String id_usuario){
        if(actualizacionPEService.findById(actualizacionPE.getId()).get().getIdUsuario().equals(id_usuario)){
            actualizacionPEService.save(actualizacionPE);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
