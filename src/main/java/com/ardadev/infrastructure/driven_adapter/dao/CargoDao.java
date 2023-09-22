package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Cargo;
import com.ardadev.domain.entities.gateways.CargoGateway;
import com.ardadev.domain.entities.gateways.CargoGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class CargoDao implements CargoGateway {

    private final EntityManager em;

    public CargoDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Cargo cargo) {
        // em.merge(nuevoCargo); para actualizar
        em.persist(cargo);
    }

    @Override
    public void actualizar(Cargo cargo) {
        em.merge(cargo);
    }

    @Override
    public void eliminar(Cargo cargo) {
        cargo = em.merge(cargo);
        em.remove(cargo);
    }

    @Override
    public Cargo encontrarPorId(Integer id) {
        return em.find(Cargo.class, id);
    }

    @Override
    public List<Cargo> encontrarTodos() {
        return em.createQuery("SELECT P FROM Cargo AS P", Cargo.class).getResultList();
    }
}
