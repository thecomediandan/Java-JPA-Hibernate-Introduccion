package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Rol;
import com.ardadev.domain.entities.gateways.RolGateway;
import com.ardadev.domain.entities.gateways.RolGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class RolDao implements RolGateway {

    private final EntityManager em;

    public RolDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Rol rol) {
        // em.merge(nuevoRol); para actualizar
        em.persist(rol);
    }

    @Override
    public void actualizar(Rol rol) {
        em.merge(rol);
    }

    @Override
    public void eliminar(Rol rol) {
        rol = em.merge(rol);
        em.remove(rol);
    }

    @Override
    public Rol encontrarPorId(Integer id) {
        return em.find(Rol.class, id);
    }

    @Override
    public List<Rol> encontrarTodos() {
        return em.createQuery("SELECT P FROM Rol AS P", Rol.class).getResultList();
    }
}
