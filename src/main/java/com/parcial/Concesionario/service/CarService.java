package com.parcial.Concesionario.service;

import com.parcial.Concesionario.domain.Car;
import java.util.List;

public interface CarService {
    public List<Car> listar();
    public Car buscar(Car car);
    public void guardar(Car car);
    public void eliminar(Car car);
}
