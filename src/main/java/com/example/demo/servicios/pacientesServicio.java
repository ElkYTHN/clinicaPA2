
package com.example.demo.servicios;



import com.example.demo.modelos.Pacientes;
import com.example.demo.repositorios.pacientesRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class pacientesServicio {
    @Autowired
    private pacientesRepositorio repositorio;
    
    public Pacientes guardar(Pacientes entidad){
        return repositorio.save(entidad);
    }
    
    public void eliminar(Long id_paciente){
        repositorio.deleteById(id_paciente);
    }
    
    public Optional<Pacientes> getValor(Long id_paciente){
        return repositorio.findById(id_paciente);
    }
    
    public List<Pacientes> getTodos(){
        return (List<Pacientes>)repositorio.findAll();
    }

}