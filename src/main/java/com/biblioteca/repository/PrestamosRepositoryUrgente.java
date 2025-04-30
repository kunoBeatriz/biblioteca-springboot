package com.biblioteca.repository;
import com.biblioteca.entity.Prestamo;

public class PrestamosRepositoryUrgente implements PrestamoRepository{

    @Override
    public String procesarPrestamo(Prestamo prestamo) {
        return "procesoPrestamoUrgente";
    }
}
