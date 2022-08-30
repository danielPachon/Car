package co.edu.eam;

import co.edu.eam.domain.Estudiante;
import co.edu.eam.service.EstudianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Slf4j
public class ControladorInicial {


    private EstudianteService estudianteService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var estudiantes = estudianteService.listar();
        model.addAttribute("estudiantes", estudiantes);
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar(Estudiante estudiante){
        return "registrar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Estudiante estudiante, Errors errores){
        if (errores.hasErrors()) {
            return "registrar";
        }
        estudianteService.guardar(estudiante);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Estudiante estudiante, Model model){
        estudiante = estudianteService.buscarPorId(estudiante);
        model.addAttribute("estudiante", estudiante);
        return "registrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Estudiante estudiante){
        estudianteService.eliminar(estudiante);
        return "redirect:/";
    }
}
