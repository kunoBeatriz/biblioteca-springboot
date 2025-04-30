package com.biblioteca.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    private Date fecha;
    private String lector;
    private Long libroId;

    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLector() {
        return lector;
    }

    public void setLector(String lector) {
        this.lector = lector;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public static PrestamoBuilder builder() {
        return new PrestamoBuilder();
    }
    public static final class PrestamoBuilder {
        private Prestamo prestamo;

        private PrestamoBuilder() {
            prestamo = new Prestamo();
        }

        public PrestamoBuilder idPrestamo(Long idPrestamo) {
            prestamo.setIdPrestamo(idPrestamo);
            return this;
        }

        public PrestamoBuilder fecha(Date fecha) {
            prestamo.setFecha(fecha);
            return this;
        }

        public PrestamoBuilder lector(String lector) {
            prestamo.setLector(lector);
            return this;
        }

        public PrestamoBuilder libroId(Long libroId) {
            prestamo.setLibroId(libroId);
            return this;
        }

        public Prestamo build() {
            return prestamo;
        }
    }
}
