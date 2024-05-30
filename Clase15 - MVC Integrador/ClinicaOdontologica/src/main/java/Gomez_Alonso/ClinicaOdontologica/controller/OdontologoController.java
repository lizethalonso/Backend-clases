package Gomez_Alonso.ClinicaOdontologica.controller;

import Gomez_Alonso.ClinicaOdontologica.model.Odontologo;
import Gomez_Alonso.ClinicaOdontologica.service.OdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/odontologo")
public class OdontologoController {
    private OdontologoService odontologoService;

    public OdontologoController() {
        odontologoService = new OdontologoService();
    }

    /*@GetMapping
    public String getOdontologoById(Model model, @RequestParam("id") Integer id){
        Odontologo odontologo = odontologoService.buscarPorID(id);
        if (odontologo != null) {
            model.addAttribute("numeroMatricula", odontologo.getNumeroMatricula());
        } else {
            model.addAttribute("error", "Odontologo not found");
        }
        return "index";
    }*/


}
