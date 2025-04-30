package com.biblioteca.dto;

import com.biblioteca.entity.Autor;
import com.biblioteca.entity.Libro;

public class LibroDto {
    private Long id;
    private String nombre;
    private String codigo;
    private Long idAutor;


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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }


    public static LibroDtoBuilder builder() {
        return new LibroDtoBuilder();
    }

    public static final class LibroDtoBuilder {
        private LibroDto libroDto;

        private LibroDtoBuilder() {
            libroDto = new LibroDto();
        }

        public LibroDtoBuilder id(Long id) {
            libroDto.setId(id);
            return this;
        }

        public LibroDtoBuilder nombre(String nombre) {
            libroDto.setNombre(nombre);
            return this;
        }

        public LibroDtoBuilder codigo(String codigo) {
            libroDto.setCodigo(codigo);
            return this;
        }

        public LibroDtoBuilder idAutor(Long idAutor) {
            libroDto.setIdAutor(idAutor);
            return this;
        }

        public LibroDto build() {
            return libroDto;
        }
    }

    public static LibroDto mapearLibro (Libro libro) {
        return LibroDto.builder()
                .id(libro.getIdLibro())
                .nombre(libro.getNombre())
                .codigo(libro.getCodigo())
                .idAutor(libro.getIdAutor().getId())
                .build();
    };
}
