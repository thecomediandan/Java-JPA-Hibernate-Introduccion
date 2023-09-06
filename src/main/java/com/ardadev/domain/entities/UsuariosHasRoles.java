package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.Objects;

// Esta entidad es la union producida por una relacion n:n entre usuarios y roles
@Entity
@Table(name = "usuarios_has_roles")
public class UsuariosHasRoles {
    @EmbeddedId
    protected UsuariosHasRolesPK usuariosHasRolesPK;

    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private Byte activo;

    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;

    @Basic(optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Rol rol;

    public UsuariosHasRoles() {}

    public UsuariosHasRolesPK getUsuariosHasRolesPK() {
        return usuariosHasRolesPK;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Byte getActivo() {
        return activo;
    }

    public void setActivo(Byte activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuariosHasRoles)) return false;
        UsuariosHasRoles that = (UsuariosHasRoles) o;
        return Objects.equals(getUsuariosHasRolesPK(), that.getUsuariosHasRolesPK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuariosHasRolesPK());
    }

    @Override
    public String toString() {
        return "UsuariosHasRoles{" +
                "usuariosHasRolesPK=" + usuariosHasRolesPK +
                ", activo=" + activo +
                ", usuario=" + usuario +
                ", rol=" + rol +
                '}';
    }
}