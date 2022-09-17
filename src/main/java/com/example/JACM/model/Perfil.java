package com.example.JACM.model;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String imagen;
    private String telefono;
    @OneToOne
    @JoinColumn(name = "usuario")
    private Empleado usuario;
    private String createAt;
    private String updateAt;
}
