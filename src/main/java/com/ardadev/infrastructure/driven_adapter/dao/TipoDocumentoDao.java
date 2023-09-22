package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.TipoDocumento;
import com.ardadev.domain.entities.gateways.TipoDocumentoGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class TipoDocumentoDao implements TipoDocumentoGateway {

    private final EntityManager em;

    public TipoDocumentoDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(TipoDocumento tipoDocumento) {
        // em.merge(nuevoTipoDocumento); para actualizar
        em.persist(tipoDocumento);
    }

    @Override
    public void actualizar(TipoDocumento tipoDocumento) {
        em.merge(tipoDocumento);
    }

    @Override
    public void eliminar(TipoDocumento tipoDocumento) {
        tipoDocumento = em.merge(tipoDocumento);
        em.remove(tipoDocumento);
    }

    @Override
    public TipoDocumento encontrarPorId(Integer id) {
        return em.find(TipoDocumento.class, id);
    }

    @Override
    public List<TipoDocumento> encontrarTodos() {
        return em.createQuery("SELECT P FROM TipoDocumento AS P", TipoDocumento.class).getResultList();
    }
}
