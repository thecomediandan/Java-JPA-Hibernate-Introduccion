package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "nomina")
public class Nomina {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 60)
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Transient
    @OneToMany(mappedBy = "nomina", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleNomina> detalleNominaList;

    public Nomina() {}

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

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public List<DetalleNomina> getDetalleNominaList() {
        return detalleNominaList;
    }

    public void setDetalleNominaList(List<DetalleNomina> detalleNominaList) {
        this.detalleNominaList = detalleNominaList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nomina)) return false;
        Nomina nomina = (Nomina) o;
        return Objects.equals(getId(), nomina.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Nomina{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", mes=" + mes +
                ", detalleNominaList=" + detalleNominaList +
                '}';
    }
}