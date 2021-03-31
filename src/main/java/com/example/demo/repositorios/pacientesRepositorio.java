
package com.example.demo.repositorios;


import com.example.demo.modelos.Pacientes;
import org.springframework.data.repository.CrudRepository;


public interface pacientesRepositorio extends CrudRepository<Pacientes, Long> {
    
}