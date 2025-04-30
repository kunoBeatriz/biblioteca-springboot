package com.biblioteca.controller;

import com.biblioteca.entity.Autor;
import com.biblioteca.entity.Libro;
import com.biblioteca.repository.AutorRepository;
import com.biblioteca.repository.LibroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @PostMapping("/guardar")
    public Autor guardar(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/actualizar/{id}")
    public Autor actualizar(@PathVariable Long id, @RequestBody Autor autor) {
        autor.setId(id);
        return autorRepository.save(autor);
    }

    @GetMapping("/{id}")
    public Autor obtener(@PathVariable Long id) {
        return autorRepository.findById(id).orElse(null);
    }



    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        autorRepository.deleteById(id);
    }
}
