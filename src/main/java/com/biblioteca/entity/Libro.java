package com.biblioteca.entity;

import jakarta.persistence.*;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    private String nombre;
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor idAutor;

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    public static LibroBuilder builder() {
        return new LibroBuilder();
    }
    public static final class LibroBuilder {
        private Libro libro;

        private LibroBuilder() {
            libro = new Libro();
        }

        public LibroBuilder idLibro(Long idLibro) {
            libro.setIdLibro(idLibro);
            return this;
        }

        public LibroBuilder nombre(String nombre) {
            libro.setNombre(nombre);
            return this;
        }

        public LibroBuilder codigo(String codigo) {
            libro.setCodigo(codigo);
            return this;
        }

        public LibroBuilder idAutor(Autor idAutor) {
            libro.setIdAutor(idAutor);
            return this;
        }

        public Libro build() {
            return libro;
        }
    }

}
