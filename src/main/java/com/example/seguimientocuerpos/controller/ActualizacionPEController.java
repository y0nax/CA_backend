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

    @DeleteMapping("/actualizacionPE/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(actualizacionPEService.findById(id).get().getId_usuario().equals(id_usuario)){
            actualizacionPEService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/actualizacionPE/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ActualizacionPE actualizacionPE, @PathVariable String id_usuario){
        if(actualizacionPEService.findById(actualizacionPE.getId()).get().getId_usuario().equals(id_usuario)){
            actualizacionPEService.save(actualizacionPE);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
