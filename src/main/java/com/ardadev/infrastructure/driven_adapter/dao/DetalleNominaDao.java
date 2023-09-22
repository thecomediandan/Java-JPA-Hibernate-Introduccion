package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.DetalleNomina;
import com.ardadev.domain.entities.DetalleNomina;
import com.ardadev.domain.entities.gateways.DetalleNominaGateway;
import com.ardadev.domain.entities.gateways.DetalleNominaGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class DetalleNominaDao implements DetalleNominaGateway {

    private final EntityManager em;

    public DetalleNominaDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(DetalleNomina detalleNomina) {
        // em.merge(nuevoDetalleNomina); para actualizar
        em.persist(detalleNomina);
    }

    @Override
    public void actualizar(DetalleNomina detalleNomina) {
        em.merge(detalleNomina);
    }

    @Override
    public void eliminar(DetalleNomina detalleNomina) {
        detalleNomina = em.merge(detalleNomina);
        em.remove(detalleNomina);
    }

    @Override
    public DetalleNomina encontrarPorId(Integer id) {
        return em.find(DetalleNomina.class, id);
    }

    @Override
    public List<DetalleNomina> encontrarTodos() {
        return em.createQuery("SELECT P FROM DetalleNomina AS P", DetalleNomina.class).getResultList();
    }
}
