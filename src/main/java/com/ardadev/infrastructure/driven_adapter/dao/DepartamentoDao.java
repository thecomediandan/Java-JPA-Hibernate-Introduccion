package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Departamento;
import com.ardadev.domain.entities.gateways.DepartamentoGateway;
import com.ardadev.domain.entities.gateways.DepartamentoGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartamentoDao implements DepartamentoGateway {

    private final EntityManager em;

    public DepartamentoDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Departamento departamento) {
        // em.merge(nuevoDepartamento); para actualizar
        em.persist(departamento);
    }

    @Override
    public void actualizar(Departamento departamento) {
        em.merge(departamento);
    }

    @Override
    public void eliminar(Departamento departamento) {
        departamento = em.merge(departamento);
        em.remove(departamento);
    }

    @Override
    public Departamento encontrarPorId(Integer id) {
        return em.find(Departamento.class, id);
    }

    @Override
    public List<Departamento> encontrarTodos() {
        return em.createQuery("SELECT P FROM Departamento AS P", Departamento.class).getResultList();
    }
}
