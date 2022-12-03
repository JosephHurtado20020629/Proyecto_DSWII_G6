package com.cibertec.Controllers;

import com.cibertec.Models.CurrencyExchange;
import com.cibertec.Services.CurrencyExchangeService;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class InicioController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    String url = "https://www.sbs.gob.pe/app/pp/sistip_portal/paginas/publicacion/tipocambiopromedio.aspx";

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("hola", "hola");
        return "inicio";
    }

    @GetMapping("hola")
    public void Scrapping() throws IOException, ParseException {
        Document webPage = Jsoup.connect(url).get();
        Element row = webPage.getElementById("ctl00_cphContent_rgTipoCambio_ctl00__0");
        Double buy = convertToDouble(row.getElementsByTag("td").get(1).text());
        Double sell = convertToDouble(row.getElementsByTag("td").get(2).text());
        String date = Arrays.stream(webPage.getElementById("ctl00_cphContent_lblFecha").text().split(" ")).collect(Collectors.toList()).get(4);
        SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
        SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
        String datesql=outSDF.format(inSDF.parse(date));

        currencyExchangeService.save(new CurrencyExchange(buy, sell, date));
        System.out.println("Get currency exchange successful");
    }

    private Double convertToDouble(String val) throws ParseException {
        String valpoint = val.replace(",", ".");
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        return nf.parse(valpoint).doubleValue();
    }

    @GetMapping("obtenerHistorial")
    public ResponseEntity<?> obtenerTipoCambio() {
        List<CurrencyExchange> history=currencyExchangeService.findAllByOrderByDateAsc();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("history", history);
        return ResponseEntity.ok(jsonObject);
    }

    @GetMapping("obtenerTipoCambio")
    public ResponseEntity<?> obtenerhistorialTipoCambio() {
        CurrencyExchange currencyExchange = currencyExchangeService.findTheCurrent();
        Double compra = currencyExchange.getBuy();
        Double venta = currencyExchange.getSell();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("compra", compra);
        jsonObject.put("venta", venta);
        return ResponseEntity.ok(jsonObject);
    }


    @GetMapping("/iniciar-sesion")
    public String login() {
        return "login";
    }

}
