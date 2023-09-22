package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Ciudad;
import com.ardadev.domain.entities.gateways.CiudadGateway;
import com.ardadev.domain.entities.gateways.CiudadGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class CiudadDao implements CiudadGateway {

    private final EntityManager em;

    public CiudadDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Ciudad ciudad) {
        // em.merge(nuevoCiudad); para actualizar
        em.persist(ciudad);
    }

    @Override
    public void actualizar(Ciudad ciudad) {
        em.merge(ciudad);
    }

    @Override
    public void eliminar(Ciudad ciudad) {
        ciudad = em.merge(ciudad);
        em.remove(ciudad);
    }

    @Override
    public Ciudad encontrarPorId(Integer id) {
        return em.find(Ciudad.class, id);
    }

    @Override
    public List<Ciudad> encontrarTodos() {
        return em.createQuery("SELECT P FROM Ciudad AS P", Ciudad.class).getResultList();
    }
}
