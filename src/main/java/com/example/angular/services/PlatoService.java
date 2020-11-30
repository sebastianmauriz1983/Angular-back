package com.example.angular.services;

import com.example.angular.entities.Plato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlatoService extends BaseService<Plato,Long> {


    List<Plato> search(String filtro) throws Exception;
    Page<Plato> search(String filtro, Pageable pageable) throws Exception;
}
