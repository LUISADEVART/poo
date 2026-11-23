package com.example.tutoria01.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tutoria01.exceptions.DatoInvalidoException;
import com.example.tutoria01.exceptions.DocumentoDuplicadoException;
import com.example.tutoria01.exceptions.EstudianteNoEncontradoException;
import com.example.tutoria01.models.Estudiante;
import com.example.tutoria01.repositories.IEstudianteRepository;

@Service
public class EstudianteService {

    private final IEstudianteRepository estudianteRepository;

    public EstudianteService(IEstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        estudiante.setId(0);
        normalizarYValidar(estudiante);
        if (estudianteRepository.existsByDocumento(estudiante.getDocumento())) {
            throw new DocumentoDuplicadoException(
                    "Ya existe un estudiante con el documento " + estudiante.getDocumento());
        }
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        if (!estudianteRepository.existsById(estudiante.getId())) {
            throw new EstudianteNoEncontradoException(
                    "No se puede actualizar: no existe un estudiante con el id " + estudiante.getId());
        }
        normalizarYValidar(estudiante);
        estudianteRepository.findByDocumento(estudiante.getDocumento())
                .filter(otro -> otro.getId() != estudiante.getId())
                .ifPresent(otro -> {
                    throw new DocumentoDuplicadoException(
                            "Ya existe un estudiante con el documento " + estudiante.getDocumento());
                });
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(int id) {
        if (!estudianteRepository.existsById(id)) {
            throw new EstudianteNoEncontradoException(
                    "No se puede eliminar: no existe un estudiante con el id " + id);
        }
        estudianteRepository.deleteById(id);
    }

    private void normalizarYValidar(Estudiante estudiante) {
        estudiante.setDocumento(validarObligatorio("documento", estudiante.getDocumento(), Estudiante.DOCUMENTO_MAX));
        estudiante.setNombres(validarObligatorio("nombres", estudiante.getNombres(), Estudiante.NOMBRES_MAX));
        estudiante.setApellidos(validarOpcional("apellidos", estudiante.getApellidos(), Estudiante.APELLIDOS_MAX));
        estudiante.setCorreo(validarOpcional("correo", estudiante.getCorreo(), Estudiante.CORREO_MAX));
        estudiante.setPrograma(validarOpcional("programa", estudiante.getPrograma(), Estudiante.PROGRAMA_MAX));
    }

    private String validarObligatorio(String campo, String valor, int maximo) {
        if (valor == null || valor.isBlank()) {
            throw new DatoInvalidoException("El campo " + campo + " es obligatorio");
        }
        String limpio = valor.trim();
        if (limpio.length() > maximo) {
            throw new DatoInvalidoException(
                    "El campo " + campo + " no puede superar " + maximo + " caracteres");
        }
        return limpio;
    }

    private String validarOpcional(String campo, String valor, int maximo) {
        if (valor == null || valor.isBlank()) {
            return null;
        }
        String limpio = valor.trim();
        if (limpio.length() > maximo) {
            throw new DatoInvalidoException(
                    "El campo " + campo + " no puede superar " + maximo + " caracteres");
        }
        return limpio;
    }

}
