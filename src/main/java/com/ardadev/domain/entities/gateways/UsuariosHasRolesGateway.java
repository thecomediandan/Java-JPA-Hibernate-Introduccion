package com.ardadev.domain.entities.gateways;

import com.ardadev.domain.entities.UsuariosHasRoles;

import java.util.List;

public interface UsuariosHasRolesGateway {
    void guardar(UsuariosHasRoles usuariosHasRoles);
    void actualizar(UsuariosHasRoles usuariosHasRoles);
    void eliminar(UsuariosHasRoles usuariosHasRoles);
    UsuariosHasRoles encontrarPorId(Integer idUsuario, Integer idRol);
    List<UsuariosHasRoles> encontrarTodos();
}
