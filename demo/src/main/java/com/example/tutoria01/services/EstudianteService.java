package com.example.tutoria01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tutoria01.models.Estudiante;
import com.example.tutoria01.repositories.IEstudianteRepository;


@Service
public class EstudianteService {

    private final IEstudianteRepository estudianteRepository;

    public EstudianteService(IEstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        if (!existeEstudiante(estudiante.getId())) {
            return null;
        }
        return estudianteRepository.save(estudiante);
    }

    public boolean eliminarEstudiante(int id) {
        if (!existeEstudiante(id)) {
            return false;
        }
        estudianteRepository.deleteById(id);
        return true;
    }

    private boolean existeEstudiante(int id) {
        return estudianteRepository.existsById(id);
    }
    
}
