package com.example.JACM.service;

import com.example.JACM.model.Empresa;
import com.example.JACM.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;


    public void crearYActualizarEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }




    public List<Empresa> verEmpresa(){
        List<Empresa> empresas = new ArrayList<Empresa>();
        empresas.addAll(empresaRepository.findAll());
        return empresas;
    }

    public void eliminarEmpresa(Long id){
        empresaRepository.deleteById(id);
    }

}
