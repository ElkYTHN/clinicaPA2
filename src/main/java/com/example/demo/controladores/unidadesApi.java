/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;


import com.example.demo.modelos.Unidades;
import com.example.demo.servicios.unidadesServicio;
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
@RequestMapping(value="/ws/unidades")
public class unidadesApi {
    @Autowired
    private unidadesServicio servicio;
    
    @GetMapping(value="/unidades")
    public List<Unidades> getTodos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id_unidades}")
    public Optional<Unidades> getValor(@PathVariable Long id_unidades){
        return servicio.getValor(id_unidades);
    }               
    
    @PostMapping(value="/guardarU")
    public Unidades guardar(@RequestBody Unidades unidades){
        return servicio.guardar(unidades);
    }
    
    @GetMapping(value="/eliminarU/{id_unidades}")
    public Optional<Unidades> eliminar(@PathVariable Long id_unidades){
        Optional<Unidades> UnidadesEliminado=servicio.getValor(id_unidades);
        servicio.eliminar(id_unidades);
        return UnidadesEliminado;
    }
}