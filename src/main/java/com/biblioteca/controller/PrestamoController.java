package com.biblioteca.controller;

import com.biblioteca.entity.Prestamo;
import com.biblioteca.repository.PrestamoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoRepository prestamoRepository;

    public PrestamoController(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @GetMapping
    public List<Prestamo> listar() {
        return prestamoRepository.findAll();
    }

    @PostMapping("/guardar")
    public Prestamo guardar(@RequestBody Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @GetMapping("/{id}")
    public Prestamo obtener(@PathVariable Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Prestamo actualizar(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        prestamo.setIdPrestamo(id);
        return prestamoRepository.save(prestamo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        prestamoRepository.deleteById(id);
    }

}
