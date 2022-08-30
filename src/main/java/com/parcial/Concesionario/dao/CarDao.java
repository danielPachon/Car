package com.parcial.Concesionario.dao;

import com.parcial.Concesionario.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarDao extends CrudRepository<Car, Long> {

}
