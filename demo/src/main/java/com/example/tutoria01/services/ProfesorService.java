package com.example.tutoria01.services;

import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import com.example.tutoria01.Models.Profesor;
import com.example.tutoria01.repositories.IProfesorRepository;

@Service
public class ProfesorService {

    private final IProfesorRepository profesorRepository;

    public ProfesorService(@NonNull IProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public @NonNull Profesor creaProfesor(@NonNull Profesor profesor) {
        return profesorRepository.save(profesor);
    }
}
