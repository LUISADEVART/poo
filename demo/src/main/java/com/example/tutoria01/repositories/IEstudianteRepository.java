package com.example.tutoria01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tutoria01.models.Estudiante;

@Repository 
public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
