
package com.example.demo.controladores;

import com.example.demo.modelos.Pacientes;
import com.example.demo.servicios.pacientesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class pacientesUIcontrolador {
 @Autowired
 private pacientesServicio servicio;
 
 @RequestMapping("/pacientes")
 public String pacientes(Model model){
     setParametro(model,"listaP", servicio.getTodos());
     return "pacientes";
 }
 
 @GetMapping("/crearP")
 public String irCrear(Model model){
     setParametro(model,"crearPaciente", new Pacientes());
     return "crearPaciente";
 }
 
 @GetMapping("/actualizarP/{id_paciente}")
 public String irActualizar(@PathVariable("id_paciente") Long id_paciente, Model model){
     setParametro(model,"crearPaciente",servicio.getValor(id_paciente));
     return "crearPaciente";
 }
 
 @PostMapping("/guardarP")
 public String guardar(Pacientes pacientes, Model model){
     servicio.guardar(pacientes);
     return "redirect:/pacientes";
 }
 
 @GetMapping("/eliminarP/{id_paciente}")
 public String eliminar(@PathVariable("id_paciente") Long id_paciente, Model model){
     servicio.eliminar(id_paciente);
     return "redirect:/pacientes";
 }
 public void setParametro(Model model, String atributo, Object valor){
     model.addAttribute(atributo, valor);
 }
}
