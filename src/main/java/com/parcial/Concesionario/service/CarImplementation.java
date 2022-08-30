package com.parcial.Concesionario.service;

import com.parcial.Concesionario.dao.CarDao;
import com.parcial.Concesionario.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarImplementation implements CarService{

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional(readOnly = true)
    public List<Car> listar() {
        return (List<Car>) carDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Car buscar(Car car) {
        return carDao.findById(car.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Car car) {
        carDao.save(car);
    }

    @Override
    @Transactional
    public void eliminar(Car car) {
        carDao.delete(car);
    }
}
