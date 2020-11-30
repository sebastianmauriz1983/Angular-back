package com.example.angular.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="plato")
@Audited
public class Plato extends Base {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;

    @Column(name = "rubro")
    private String rubro;

    @Column(name = "ingredientes")
    private ArrayList<String> ingrediente = new ArrayList<>();
    //imagen BLOB

    @Column(name = "pathImagen")
    private String pathImagen;

}
