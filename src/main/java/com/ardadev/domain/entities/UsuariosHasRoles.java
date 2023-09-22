package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.Objects;

// Esta entidad es la union producida por una relacion n:n entre usuarios y roles
@Entity
@Table(name = "usuarios_has_roles")
public class UsuariosHasRoles {
    @EmbeddedId
    //@AttributeOverrides()
    protected UsuariosHasRolesPK usuariosHasRolesPK;

    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Activo activo;

    //@Basic(optional = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Usuario usuario;

    //@Basic(optional = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Rol rol;

    public UsuariosHasRoles() {
        this.usuariosHasRolesPK = new UsuariosHasRolesPK();
    }

    public UsuariosHasRoles(Activo activo) {
        //this.usuariosHasRolesPK = new UsuariosHasRolesPK(usuario, rol);
        //this.usuario = usuario;
        //this.rol = rol;
        this.activo = activo;
    }

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

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public void setUsuariosHasRolesPK(UsuariosHasRolesPK usuariosHasRolesPK) {
        this.usuariosHasRolesPK = usuariosHasRolesPK;
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
                "usuarios_id=" + usuariosHasRolesPK.getUsuarioId() +
                "roles_id=" + usuariosHasRolesPK.getRolId() +
                ", activo=" + activo.name() +
                '}';
    }
}