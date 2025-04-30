package com.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static AutorBuilder builder() {
        return new AutorBuilder();
    }

    public static final class AutorBuilder {
        private Autor autor;

        private AutorBuilder() {
            autor = new Autor();
        }

        public AutorBuilder id(Long id) {
            autor.setId(id);
            return this;
        }

        public AutorBuilder nombre(String nombre) {
            autor.setNombre(nombre);
            return this;
        }

        public Autor build() {
            return autor;
        }
    }
}
