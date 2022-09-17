package com.example.JACM.model;

import com.example.JACM.enums.Enum_Rol;
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
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    @Column(unique = true, nullable = false, name = "email")
    private String correo;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Enum_Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;


    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MovimientoDinero> transaccion;

    private String createAt;
    private String updateAt;
}
