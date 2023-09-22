package com.ardadev.infrastructure.driven_adapter.dao;

import com.ardadev.domain.entities.UsuariosHasRoles;
import com.ardadev.domain.entities.gateways.UsuariosHasRolesGateway;
import com.ardadev.domain.entities.gateways.UsuariosHasRolesGateway;

import javax.persistence.EntityManager;
import java.util.List;

public class UsuariosHasRolesDao implements UsuariosHasRolesGateway {

    private final EntityManager em;

    public UsuariosHasRolesDao(EntityManager em) {
        this.em = em;
    }
    @Override
    public void guardar(UsuariosHasRoles usuariosHasRoles) {
        // em.merge(nuevoUsuariosHasRoles); para actualizar
        em.persist(usuariosHasRoles);
    }

    @Override
    public void actualizar(UsuariosHasRoles usuariosHasRoles) {
        em.merge(usuariosHasRoles);
    }

    @Override
    public void eliminar(UsuariosHasRoles usuariosHasRoles) {
        usuariosHasRoles = em.merge(usuariosHasRoles);
        em.remove(usuariosHasRoles);
    }

    @Override
    public UsuariosHasRoles encontrarPorId(Integer idUsuario, Integer idRol) {
        // TODO
        // return em.find(UsuariosHasRoles.class, id);
        return null;
    }

    @Override
    public List<UsuariosHasRoles> encontrarTodos() {
        return em.createQuery("SELECT P FROM UsuariosHasRoles AS P", UsuariosHasRoles.class).getResultList();
    }
}
