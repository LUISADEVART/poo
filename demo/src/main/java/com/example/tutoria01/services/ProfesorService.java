package com.example.tutoria01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tutoria01.repositories.IProfesorRepository;


@Service
public class ProfesorService {
    IProfesorRepository profesorRepository;

    public Profesor creaProfesor(Profesor profesor){

        //
        profesorRepository.save(profesor);
        
        return null;
        }
    }
