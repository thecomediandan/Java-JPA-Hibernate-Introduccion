package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.Usuario;
import com.ardadev.domain.entities.gateways.UsuarioGateway;
import com.ardadev.domain.entities.gateways.UsuarioGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuarioDao implements UsuarioGateway {

    private final EntityManager em;

    public UsuarioDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(Usuario usuario) {
        // em.merge(nuevoUsuario); para actualizar
        em.persist(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuario = em.merge(usuario);
        em.remove(usuario);
    }

    @Override
    public Usuario encontrarPorId(Integer id) {
        return em.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> encontrarTodos() {
        return em.createQuery("SELECT P FROM Usuario AS P", Usuario.class).getResultList();
    }
}
