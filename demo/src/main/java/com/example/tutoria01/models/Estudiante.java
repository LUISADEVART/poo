package com.example.tutoria01.models;

 

public class Estudiante {
    private int id;
    private String nombres;
    private String apellidos;
    private String documento;

    //getters y setters
    public int getId(){
        return this.id;
    }
    public void SetId(int id){
        this.id = id;
    }

    public String getNombres(){
    return this.nombres;

    }
    public void SetNombres(String nombres){
        this.nombres = nombres;
    }
    public String getApellidos(){
    return this.apellidos;

    }
    public void SetApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getDocumeto(){
    return this.documento;

    }
    public void SetDocumento(String documento){
        this.documento = documento;
    }

}
