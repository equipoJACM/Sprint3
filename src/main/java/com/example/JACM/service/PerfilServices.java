package com.example.JACM.service;

import com.example.JACM.model.Empresa;
import com.example.JACM.model.Perfil;
import com.example.JACM.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfilServices {

    @Autowired
    PerfilRepository perfilRepository;

    public void crearYActualizarPerfil(Perfil perfil){
        perfilRepository.save(perfil);
    }




    public List<Perfil> verPerfil(){
        List<Perfil> perfiles = new ArrayList<Perfil>();
        perfiles.addAll(perfilRepository.findAll());
        return perfiles;
    }

    public void eliminarPerfil(Long id){
        perfilRepository.deleteById(id);
    }
}
