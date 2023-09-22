package com.ardadev.domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuariosHasRolesPK implements Serializable {
    @Transient
    private static final long serialVersionUID = 5299687226859963380L;

    //@Basic(optional = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarios_id")
    private Integer usuarioId;

    //@Basic(optional = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private Integer rolId;

    public UsuariosHasRolesPK() {
    }
    public UsuariosHasRolesPK(Integer usuarioId, Integer rolId) {
        this.usuarioId = usuarioId;
        this.rolId = rolId;
    }

    /*No permitido con Hibernate porque lo genera automáticamente con el constructor vacío
    public UsuariosHasRolesPK(Usuario usuario, Rol rol) {
        this.usuarioId = 1;
        this.rolId = 1;
    }*/

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuariosHasRolesPK)) return false;
        UsuariosHasRolesPK that = (UsuariosHasRolesPK) o;
        return Objects.equals(getUsuarioId(), that.getUsuarioId()) && Objects.equals(getRolId(), that.getRolId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuarioId(), getRolId());
    }

    @Override
    public String toString() {
        return "UsuariosHasRolesPK{" +
                "usuarioId=" + usuarioId +
                ", rolId=" + rolId +
                '}';
    }
}