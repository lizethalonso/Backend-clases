package Gomez_Alonso.ClinicaOdontologica.controller;

import Gomez_Alonso.ClinicaOdontologica.model.Odontologo;
import Gomez_Alonso.ClinicaOdontologica.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
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

    @PostMapping //--> nos permite persistir los datos que vienen desde la vista
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.guardarOdontologo(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo buscarPorOdontologo(@PathVariable Integer id){
        return odontologoService.buscarPorID(id);
    }

    @GetMapping
    public List<Odontologo> buscarTodos(){
        return odontologoService.buscarTodos();
    }

    @GetMapping("/matricula")
    public Odontologo buscarPorMatricula(@RequestParam String matricula){
        return odontologoService.buscarPorMatricula(matricula);
    }

    @PutMapping
    public String actualizarOdontologo(@RequestBody Odontologo odontologo){
        Odontologo odontologoBuscado= odontologoService.buscarPorID(odontologo.getId());
        if(odontologoBuscado!=null){
            odontologoService.actualizarOdontologo(odontologo);
            return "Odontólogo actualizado con éxito";
        }else{
            return "Odontólogo no encontrado";
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarOdontologo(@PathVariable Integer id){
        odontologoService.eliminarOdontologo(id);
    }

    }
