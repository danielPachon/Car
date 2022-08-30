package com.parcial.Concesionario;

import com.parcial.Concesionario.dao.CarDao;
import com.parcial.Concesionario.domain.Car;
import com.parcial.Concesionario.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@Slf4j
public class CotroladorInicio {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String mostrar(Model modelo){
        var cars = carService.listar();
        modelo.addAttribute("cars", cars);
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar(Car car){
        return "actualizar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Car car, Errors errors){
        if(errors.hasErrors()){
            return "actualizar";
        }
        carService.guardar(car);
        return "redirect:/";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Car car, Model model){
        car = carService.buscar(car);
        model.addAttribute("car", car);
        return "actualizar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Car car){
        carService.eliminar(car);
        return "redirect:/";
    }
}
