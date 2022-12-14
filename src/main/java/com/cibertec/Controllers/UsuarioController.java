package com.cibertec.Controllers;

import com.cibertec.Models.Usuario;
import com.cibertec.Services.UsuarioService;
import com.cibertec.util.EncriptarString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listarUsuario")
    public String listarUsuario(Model model, Usuario usuario) {

        var usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);

        return "listarUsuario";
    }

    @GetMapping("/registrarUsuario")
    public String registrarUsuario(Usuario usuario, Model model) {
        model.addAttribute("action", "Registrar");
        return "registrarUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@RequestParam("password") String passw, @RequestParam("action") String action,
                                 Usuario usuario,
                                 Errors errores) {

        if (errores.hasErrors()) {
            return "registrarUsuario";
        }

        try {
            EncriptarString passCifrado = new EncriptarString();
            usuario.setPassword(passCifrado.encriptarString(passw));

            usuarioService.guardarUsuario(usuario);

            if (action.equals("Actualizar")) return "redirect:/user/listarUsuario";
            else return "redirect:/iniciar-sesion";

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return "redirect:/iniciar-sesion";
        }

    }

    @GetMapping("/actualizarUsuario/{idusuario}")
    public String actualizarUsuario(Usuario usuario, Model model) {
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("action", "Actualizar");
        return "registrarUsuario";
    }

    @GetMapping("/eliminarUsuario/{idusuario}")
    public String eliminarUsuario(Usuario usuario, Model model) {
        usuarioService.eliminarUsuario(usuario);

        return "redirect:/user/listarUsuario";
    }


}
