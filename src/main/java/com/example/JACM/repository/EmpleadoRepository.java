package com.example.JACM.repository;

import com.example.JACM.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository <Empleado,Long> {
}
