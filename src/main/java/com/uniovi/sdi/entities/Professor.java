package com.uniovi.sdi.entities;

import com.uniovi.sdi.services.MarksService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String name;
    private String apellido;
    private String categoria;

    public Professor(){

    }

    public Professor(Long i, String d, String n, String a, String c) {
        this.id=i;
        this.dni=d;
        this.name=n;
        this.apellido=a;
        this.categoria=c;
    }

    @Override
    public String toString() {
        return "Professor(id"+id+", dni="+dni+", nombre="+name+" "+apellido+", categoria="+categoria+")";
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni) {
        this.dni=dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido=apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria=categoria;
    }
}
