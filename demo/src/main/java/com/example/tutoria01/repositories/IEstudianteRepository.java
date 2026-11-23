package com.example.tutoria01.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutoria01.models.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

    boolean existsByDocumento(String documento);

    Optional<Estudiante> findByDocumento(String documento);

}
