package com.example.JACM.service;

import com.example.JACM.model.Empleado;
import com.example.JACM.model.Empresa;
import com.example.JACM.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public void crearYActualizarEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
    }

    public List<Empleado> verEmpleado(){
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleados.addAll(empleadoRepository.findAll());
        return empleados;
    }

    public List<Empleado> ListarEmpleados(){ return this.empleadoRepository.findAll();}

    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }
}
