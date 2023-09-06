package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Pais;
import com.ardadev.domain.entities.gateways.PaisGateway;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Locale;

public class PaisDao implements PaisGateway {

    private final EntityManager em;

    public PaisDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Pais pais) {
        // em.merge(nuevoPais); para actualizar
        em.persist(pais);
    }

    @Override
    public void actualizar(Pais pais) {
        em.merge(pais);
    }

    @Override
    public void eliminar(Pais pais) {
        pais = em.merge(pais);
        em.remove(pais);
    }

    @Override
    public Pais encontrarPorId(Integer id) {
        return em.find(Pais.class, id);
    }

    @Override
    public List<Pais> encontrarTodos() {
        return em.createQuery("SELECT P FROM Pais AS P", Pais.class).getResultList();
    }

    public Pais encontrarPorNombre(String nombre) {
        // En verdad P hace referencia a la entidad o clase, al hacer P. accedemos directamente a los atributos de la entidad
        return em.createQuery("SELECT P FROM Pais AS P WHERE P.nombre=:nombre", Pais.class).setParameter("nombre", nombre).getSingleResult();
    }

    public String encontrarNombrePorId(Integer id) {
        return em.createQuery("SELECT P.nombre FROM Pais AS P WHERE P.id=:id", String.class)
                .setParameter("id", id).getSingleResult();
    }
}
