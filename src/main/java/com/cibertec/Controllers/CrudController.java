package com.cibertec.Controllers;

import com.cibertec.Models.CurrencyExchange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "tc")
public class CrudController {

    @GetMapping("listar")
    public String listadotc(Model model) {
        model.addAttribute("tc", new CurrencyExchange());
        return "listadomoneda";
    }




}
