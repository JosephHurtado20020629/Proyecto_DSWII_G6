package com.cibertec.Services;

import com.cibertec.Models.Usuario;
import com.cibertec.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsuarioService{

    public List<Usuario> listarUsuarios();

    public void guardarUsuario(Usuario usuario);

    public void eliminarUsuario(Usuario usuario);

    public Usuario encontrarUsuario(Usuario usuario);


}
