package com.example.seguimientocuerpos.controller;

import com.example.seguimientocuerpos.model.ProyectosColectivos;
import com.example.seguimientocuerpos.service.ProyectosColectivosService;
import com.example.seguimientocuerpos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProyectosColectivosController {

    private final ProyectosColectivosService proyectosColectivosService;
    private final UsuarioService usuarioService;

    @PostMapping("/proyectoColectivo")
    public void save(@RequestBody ProyectosColectivos proyectosColectivos){
        proyectosColectivosService.save(proyectosColectivos);
    }

    @GetMapping("/proyectoColectivos")
    public List<ProyectosColectivos> findAll(){
        return proyectosColectivosService.findAll();
    }

    @GetMapping("/proyectoColectivo/{id}")
    public ProyectosColectivos findById(@PathVariable String id){
        return proyectosColectivosService.findById(id).get();
    }

    @GetMapping("/proyectoColectivoA/{anio}/{id_usuario}")
    public ResponseEntity<Object> findByFecha(@PathVariable String anio, @PathVariable String id_usuario){
        List<ProyectosColectivos> filtro = new ArrayList<>();
        if (proyectosColectivosService.findByAnio(anio).size()>0){
            for (ProyectosColectivos p: proyectosColectivosService.findByAnio(anio))
                if(usuarioService.findById(id_usuario).get().getIdCa().equals(p.getIdCa()))
                    filtro.add(p);

            if(filtro.size()>0)
                return new ResponseEntity<>(filtro,HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/proyectoColectivoI/{id_usuario}")
    public ResponseEntity<Object> findByIntegrantes(@PathVariable String id_usuario){
        if(proyectosColectivosService.findByIntegrantesIdUsuario(id_usuario).size()>0)
            return new ResponseEntity<>(proyectosColectivosService.findByIntegrantesIdUsuario(id_usuario),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/proyectoColectivoC/{idCa}")
    public ResponseEntity<Object> findByCuerpos (@PathVariable String idCa){
        if (proyectosColectivosService.findByIdCa(idCa).size()>0)
            return new ResponseEntity<>(proyectosColectivosService.findByIdCa(idCa),HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/proyectoColectivo/{id}/{id_usuario}")
    public ResponseEntity<Object> deleteById(@PathVariable String id, @PathVariable String id_usuario){
        if(proyectosColectivosService.findById(id).get().getIdUsuario().equals(id_usuario)){
            proyectosColectivosService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/proyectoColectivo/{id_usuario}")
    public ResponseEntity<Object> update(@RequestBody ProyectosColectivos proyectosColectivos, @PathVariable String id_usuario){
        if(proyectosColectivosService.findById(proyectosColectivos.getId()).get().getIdUsuario().equals(id_usuario)){
            proyectosColectivosService.save(proyectosColectivos);
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
