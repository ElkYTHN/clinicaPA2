/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;

import com.example.demo.modelos.Doctores;
import com.example.demo.modelos.Intervenciones;
import com.example.demo.servicios.intervencionesServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Elkin Portillo
 */
@RestController
@RequestMapping(value="/ws/intervenciones")
public class intervencionesApi {
    @Autowired
    private intervencionesServicio servicio;
    
    @GetMapping(value="/intervenciones")
    public List<Intervenciones> getTodos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id_inter}")
    public Optional<Intervenciones> getValor(@PathVariable Long id_inter){
        return servicio.getValor(id_inter);
    }               
    
    @PostMapping(value="/guardarI")
    public Intervenciones guardar(@RequestBody Intervenciones intervenciones){
        return servicio.guardar(intervenciones);
    }
    
    @GetMapping(value="/eliminarI/{id_inter}")
    public Optional<Intervenciones> eliminar(@PathVariable Long id_inter){
        Optional<Intervenciones> IntervencionEliminado=servicio.getValor(id_inter);
        servicio.eliminar(id_inter);
        return IntervencionEliminado;
    }
}