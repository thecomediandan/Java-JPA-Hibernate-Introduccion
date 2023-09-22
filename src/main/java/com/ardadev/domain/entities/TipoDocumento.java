package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tipos_documento")
public class TipoDocumento {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    private String descripcion;

    //@Transient
    @OneToMany(mappedBy = "tipoDocumentoId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public TipoDocumento() {}
    public TipoDocumento(String descripcion) {
        this.descripcion = descripcion;
        this.usuarioList = new ArrayList<>();
    }

    public void addUsuarioList(Usuario usuario) {
        usuario.setTipoDocumentoId(this);
        this.usuarioList.add(usuario);
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

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDocumento)) return false;
        TipoDocumento that = (TipoDocumento) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TipoDocumento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}