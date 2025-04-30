package com.biblioteca.repository;


import com.biblioteca.entity.Prestamo;

public class PrestamosRepositoryNormal implements PrestamoRepository{

    @Override
    public String procesarPrestamo(Prestamo prestamo) {
        return "procesoPrestamoNormal";
    }
}
