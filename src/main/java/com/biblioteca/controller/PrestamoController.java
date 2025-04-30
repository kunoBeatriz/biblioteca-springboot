package com.biblioteca.controller;

import com.biblioteca.entity.Prestamo;
import com.biblioteca.repository.RepositoryJPA;
import com.biblioteca.repository.PrestamosRepositoryNormal;
import com.biblioteca.repository.PrestamosRepositoryUrgente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final RepositoryJPA prestamoRepository;

    public PrestamoController(RepositoryJPA prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @PostMapping("/procesar")
    public String procesar(@RequestBody Prestamo prestamo, @RequestParam boolean urgente) {
        PrestamoContext context = new PrestamoContext();

        if (urgente) {
            context.setStrategy(new PrestamosRepositoryUrgente());
        } else {
            context.setStrategy(new PrestamosRepositoryNormal());
        }
        return context.procesarPrestamo(prestamo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        prestamoRepository.deleteById(id);
    }

    /*
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
     */



}
