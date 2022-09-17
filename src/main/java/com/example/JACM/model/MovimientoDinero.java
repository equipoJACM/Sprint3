package com.example.JACM.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String concepto;
    private float monto;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Empleado usuario;
    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;
    private String createAt;
    private String updateAt;
}

