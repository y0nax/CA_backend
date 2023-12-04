package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ColaboracionCA;
import com.example.seguimientocuerpos.service.ColaboracionCAService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ColaboracionCAController {

    private final ColaboracionCAService colaboracionCAService;

    @PostMapping("/colaboracionCA")
    public void save(@RequestBody ColaboracionCA colaboracionCA){
        colaboracionCAService.save(colaboracionCA);
    }

    @GetMapping("/colaboracionCAs")
    public List<ColaboracionCA> findAll(){
        return colaboracionCAService.findAll();
    }

    @GetMapping("/colaboracionCA/{id}")
    public ColaboracionCA findById(@PathVariable String id){
        return colaboracionCAService.findById(id).get();
    }

    @GetMapping("colaboracionCAA/{anio}")
    public ResponseEntity<Object> findByFecha(@PathVariable String anio){
        if(colaboracionCAService.findByAnio(anio).size()>0)
            return new ResponseEntity<>(colaboracionCAService.findByAnio(anio), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("colaboracionCAT/{tipo}")
    public ResponseEntity<Object> findByTipo(@PathVariable String tipo){
        if(colaboracionCAService.findByTipo(tipo).size()>0)
            return new ResponseEntity<>(colaboracionCAService.findByTipo(tipo), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("colaboracionCAC/{idCa}")
    public ResponseEntity<Object> findByIntegrantesIdCa(@PathVariable String idCa){
        if(colaboracionCAService.findByIntegrantesIdCa(idCa).size()>0)
            return new ResponseEntity<>(colaboracionCAService.findByIntegrantesIdCa(idCa), HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/colaboracionCA/{id}/{idUsuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String idUsuario){
        if(colaboracionCAService.findById(id).get().getIdUsuario().equals(idUsuario)){
            colaboracionCAService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/colaboracionCA/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ColaboracionCA colaboracionCA, @PathVariable String id_usuario) {
        if (colaboracionCAService.findById(colaboracionCA.getId()).get().getIdUsuario().equals(id_usuario)) {
            colaboracionCAService.save(colaboracionCA);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
