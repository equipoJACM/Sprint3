package com.example.JACM.repository;

import com.example.JACM.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository <Empresa,Long> {
}
