package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    //@Basic(optional = false)
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "departamentos_id", referencedColumnName = "id", nullable = false)
    private Departamento departamento;

    //@Transient
    @OneToMany(mappedBy = "ciudadesId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuario> usuarioList;

    public Ciudad() {}
    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.usuarioList = new ArrayList<>();
    }

    public void addUsuarioList(Usuario usuario) {
        usuario.setCiudadesId(this);
        this.usuarioList.add(usuario);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ciudad)) return false;
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(getId(), ciudad.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}