package com.example.tutoria01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tutoria01.models.Profesor;
import com.example.tutoria01.repositories.IProfesorRepository;

@Service
public class ProfesorService {

    private final IProfesorRepository profesorRepository;

    public ProfesorService(IProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> obtenerProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor actualizarProfesor(Profesor profesor) {
        if (!existeProfesor(profesor.getId())) {
            return null;
        }
        return profesorRepository.save(profesor);
    }

    public boolean eliminarProfesor(int id) {
        if (!existeProfesor(id)) {
            return false;
        }
        profesorRepository.deleteById(id);
        return true;
    }

    private boolean existeProfesor(int id) {
        return profesorRepository.existsById(id);
    }

}
