package com.example.tutoria01.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutoria01.Models.Profesor;
import com.example.tutoria01.repositories.IProfesorRepository;

@Service
public class ProfesorService {

    @Autowired
    IProfesorRepository profesorRepository;

    public Profesor creaProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
    public ArrayList<Profesor> obtenerProfesores(){

       return (ArrayList<Profesor>) profesorRepository.findAll();

       
    }
}