package com.biblioteca.controller;

import com.biblioteca.entity.Prestamo;
import com.biblioteca.repository.PrestamoRepository;

public class PrestamoContext {
    private PrestamoRepository strategy;

    public void setStrategy(PrestamoRepository strategy) {
        this.strategy = strategy;
    }

    public String procesarPrestamo(Prestamo prestamo) {
        return strategy.procesarPrestamo(prestamo);
    }
}
