package com.biblioteca.repository;

import com.biblioteca.entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryJPA extends JpaRepository<Prestamo, Long> {
}
