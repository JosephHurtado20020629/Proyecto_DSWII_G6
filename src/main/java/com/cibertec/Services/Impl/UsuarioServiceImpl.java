package com.cibertec.Services.Impl;

import com.cibertec.Models.Usuario;
import com.cibertec.Repositories.UsuarioRepository;
import com.cibertec.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioRepositorio.findById(usuario.getIdusuario()).orElse(null);
    }
}
