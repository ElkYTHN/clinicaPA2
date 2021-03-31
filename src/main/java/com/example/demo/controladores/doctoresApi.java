/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;

import com.example.demo.modelos.Doctores;
import com.example.demo.servicios.doctoresServicio;
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
@RequestMapping(value="/ws/doctores")
public class doctoresApi {
    @Autowired
    private doctoresServicio servicio;
    
    @GetMapping(value="/doctores")
    public List<Doctores> getTodos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id_doctor}")
    public Optional<Doctores> getValor(@PathVariable Long id_doctor){
        return servicio.getValor(id_doctor);
    }               
    
    @PostMapping(value="/guardar")
    public Doctores guardar(@RequestBody Doctores doctores){
        return servicio.guardar(doctores);
    }
    
    @GetMapping(value="/eliminar/{id_doctor}")
    public Optional<Doctores> eliminar(@PathVariable Long id_doctor){
        Optional<Doctores> DoctorEliminado=servicio.getValor(id_doctor);
        servicio.eliminar(id_doctor);
        return DoctorEliminado;
    }
}