package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = true)
    @Column(name = "descripcion", nullable = true, length = 40)
    private String descripcion;

    //@Transient
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsuariosHasRoles> usuariosHasRolesList = new ArrayList<>();

    public Rol() {}
    public Rol(String descripcion) {
        this.descripcion = descripcion;
        //this.usuariosHasRolesList = new ArrayList<>();
    }

    public void addUsuariosHasRolesList(UsuariosHasRoles usuariosHasRoles) {
        usuariosHasRoles.setRol(this);
        this.usuariosHasRolesList.add(usuariosHasRoles);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<UsuariosHasRoles> getUsuariosHasRolesList() {
        return usuariosHasRolesList;
    }

    public void setUsuariosHasRolesList(List<UsuariosHasRoles> usuariosHasRolesList) {
        this.usuariosHasRolesList = usuariosHasRolesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol)) return false;
        Rol rol = (Rol) o;
        return Objects.equals(getId(), rol.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}