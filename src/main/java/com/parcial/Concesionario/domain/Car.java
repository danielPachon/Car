package com.parcial.Concesionario.domain;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="Car")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=1, max=40)
    private String marca;

    @NotNull
    @Size(min=1, max=40)
    private String modelo;

    @NotNull
    private String color;

    @NotNull
    @Size(min=4, max=4)
    private String year;

    @NotNull
    @Size(min=2, max=20)
    private String cilindros;
    @NotNull
    @Size(min=1, max=40)
    private String price;
    @NotNull
    private String tipoAuto;
    @NotNull
    private String tipoCombustible;
}