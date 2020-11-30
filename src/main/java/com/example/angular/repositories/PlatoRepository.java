package com.example.angular.repositories;

import com.example.angular.entities.Plato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoRepository extends BaseRepository<Plato,Long> {



    //original sin pageable
    List<Plato> findByNombreContaining(String nombre);

    //Boolean existByDni(int dni);

    //jpql
    @Query(value = "SELECT p FROM Plato p WHERE p.nombre LIKE %:filtro%")
    List<Plato> search(@Param("filtro") String filtro);

    //sql
    @Query(value = "SELECT * FROM plato Where plato.nombre LIKE %:filtro%"
            ,nativeQuery = true)
    List<Plato> searchNativo(@Param("filtro") String filtro);



    //modificado con pageable

    Page<Plato> findByNombreContaining(String nombre, Pageable pageable);


    //jpql
    @Query(value = "SELECT p FROM Plato p WHERE p.nombre LIKE %:filtro% ")
    Page<Plato> search(@Param("filtro") String filtro, Pageable pageable);

    //sql
    @Query(value = "SELECT * FROM plato Where plato.nombre LIKE %:filtro%"
            ,countQuery = "SELECT count(*) FROM plato"
            ,nativeQuery = true)
    Page<Plato> searchNativo(@Param("filtro") String filtro, Pageable pageable);



}
