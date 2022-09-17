package com.example.JACM.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false, name = "name")
    private String nombre;
    private String direccion;
    private String telefono;
    @Column(unique = true, nullable = false, name = "nit")
    private int nit;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Empleado> usuario;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovimientoDinero> transaccion;

    private String createAt;
    private String updateAt;

}
