package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Nomina;
import com.ardadev.domain.entities.gateways.NominaGateway;
import com.ardadev.domain.entities.gateways.NominaGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class NominaDao implements NominaGateway {

    private final EntityManager em;

    public NominaDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Nomina nomina) {
        // em.merge(nuevoNomina); para actualizar
        em.persist(nomina);
    }

    @Override
    public void actualizar(Nomina nomina) {
        em.merge(nomina);
    }

    @Override
    public void eliminar(Nomina nomina) {
        nomina = em.merge(nomina);
        em.remove(nomina);
    }

    @Override
    public Nomina encontrarPorId(Integer id) {
        return em.find(Nomina.class, id);
    }

    @Override
    public List<Nomina> encontrarTodos() {
        return em.createQuery("SELECT P FROM Nomina AS P", Nomina.class).getResultList();
    }
}
