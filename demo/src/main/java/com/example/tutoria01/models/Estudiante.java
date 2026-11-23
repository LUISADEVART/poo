package com.example.tutoria01.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Estudiante independiente: no depende de otra clase ni de otra tabla.
 *
 * Atributos propuestos además de id, documento y nombres:
 * apellidos (String) — apellidos del estudiante. Ejemplo: "García López"
 * correo (String) — correo electrónico. Ejemplo: "ana@correo.com"
 * programa (String) — programa académico. Ejemplo: "Ingeniería de Sistemas"
 */
@Entity
@Table(name = "estudiante")
public class Estudiante {

    public static final int DOCUMENTO_MAX = 20;
    public static final int NOMBRES_MAX = 80;
    public static final int APELLIDOS_MAX = 80;
    public static final int CORREO_MAX = 120;
    public static final int PROGRAMA_MAX = 100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = DOCUMENTO_MAX)
    private String documento;

    @Column(nullable = false, length = NOMBRES_MAX)
    private String nombres;

    @Column(length = APELLIDOS_MAX)
    private String apellidos;

    @Column(length = CORREO_MAX)
    private String correo;

    @Column(length = PROGRAMA_MAX)
    private String programa;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrograma() {
        return this.programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

}
