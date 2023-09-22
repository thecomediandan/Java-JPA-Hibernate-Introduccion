package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 60)
    private String descripcion;

    //@Transient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoId", fetch = FetchType.LAZY)
    //@jakarta.json.bind.annotation.JsonbTransient
    private List<Usuario> usuariosCollection;

    public Cargo() {}
    public Cargo(String descripcion) {
        this.descripcion = descripcion;
        this.usuariosCollection = new ArrayList<>();
    }

    public void addUsuariosCollection(Usuario usuario) {
        usuario.setCargoId(this);
        this.usuariosCollection.add(usuario);
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

    public List<Usuario> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(List<Usuario> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cargo)) return false;
        Cargo cargo = (Cargo) o;
        return Objects.equals(getId(), cargo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}