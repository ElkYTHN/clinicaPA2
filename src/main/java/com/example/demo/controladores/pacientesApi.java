/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controladores;


import com.example.demo.modelos.Pacientes;
import com.example.demo.servicios.pacientesServicio;
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
@RequestMapping(value="/ws/pacientes")
public class pacientesApi {
    @Autowired
    private pacientesServicio servicio;
    
    @GetMapping(value="/pacientes")
    public List<Pacientes> getTodos(){
        return servicio.getTodos();
    }
    
    @GetMapping(value="/{id_paciente}")
    public Optional<Pacientes> getValor(@PathVariable Long id_paciente){
        return servicio.getValor(id_paciente);
    }               
    
    @PostMapping(value="/guardarP")
    public Pacientes guardar(@RequestBody Pacientes pacientes){
        return servicio.guardar(pacientes);
    }
    
    @GetMapping(value="/eliminarP/{id_paciente}")
    public Optional<Pacientes> eliminar(@PathVariable Long id_paciente){
        Optional<Pacientes> PacienteEliminado=servicio.getValor(id_paciente);
        servicio.eliminar(id_paciente);
        return PacienteEliminado;
    }
}