package com.cibertec.Models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String username;
    private String password;

    public Usuario(){   }
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }
}
