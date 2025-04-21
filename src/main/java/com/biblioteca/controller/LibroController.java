package com.biblioteca.controller;

import com.biblioteca.entity.Libro;
import com.biblioteca.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @PostMapping("/guardar")
    public Libro guardar(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/actualizar/{id}")
    public Libro actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setIdLibro(id);
        return libroRepository.save(libro);
    }

    @GetMapping("/{id}")
    public Libro obtener(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }



    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }
}
