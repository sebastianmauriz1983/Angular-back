package com.example.angular.services;


import com.example.angular.entities.Plato;
import com.example.angular.repositories.BaseRepository;
import com.example.angular.repositories.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl extends BaseServiceImpl<Plato,Long> implements PlatoService {

    @Autowired
    private PlatoRepository personaRepository;


    public PlatoServiceImpl(BaseRepository<Plato,Long> baseRepository){
        super(baseRepository);
    }


    //sin paginacion
    @Override
    public List<Plato> search(String filtro) throws Exception {
        try {

            //List<Persona> plato = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);

            //jpql
            //List<Persona> plato = personaRepository.search(filtro);

            //sql nativo
            List<Plato> plato = personaRepository.searchNativo(filtro);

            return plato;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //con paginacion
    @Override
    public Page<Plato> search(String filtro, Pageable pageable) throws Exception {
        try {

            //Page<Persona> plato = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro,pageable);

            //jpql
            //Page<Persona> plato = personaRepository.search(filtro,pageable);

            //sql nativo
            Page<Plato> plato = personaRepository.searchNativo(filtro,pageable);

            return plato;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
