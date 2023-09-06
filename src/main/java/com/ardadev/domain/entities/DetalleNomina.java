package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "detalle_nomina")
public class DetalleNomina {
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "dias_laborados", nullable = false)
    private Integer diasLaborados;

    @Basic(optional = false)
    @Column(name = "sueldo_devengado", nullable = false)
    private Double sueldoDevengado;

    @Basic(optional = true)
    @Column(name = "auxilio_transporte", nullable = true)
    private Double auxilioTransporte;

    @Basic(optional = true)
    @Column(name = "valor_horas_extras", nullable = true)
    private Double valorHorasExtras;

    @Basic(optional = false)
    @Column(name = "descuento_salud", nullable = false)
    private Double descuentoSalud;

    @Basic(optional = false)
    @Column(name = "descuento_pension", nullable = false)
    private Double descuentoPension;

    @Basic(optional = true)
    @Column(name = "descuento_fondo_solidaridad", nullable = true)
    private Double descuentoFondoSolidaridad;

    @Basic(optional = true)
    @Column(name = "otros_descuentos", nullable = true)
    private Double otrosDescuentos;

    @Basic(optional = false)
    @Column(name = "total_devengado", nullable = false)
    private Double totalDevengado;

    @Basic(optional = false)
    @Column(name = "total_descuento", nullable = false)
    private Double totalDescuento;

    @Basic(optional = false)
    @Column(name = "neto_pagar", nullable = false)
    private Double netoPagar;

    @Basic(optional = false, fetch = FetchType.LAZY)
    @ManyToOne(optional = true)
    @JoinColumn(name = "usuarios_id", nullable = false, referencedColumnName = "id")
    private Usuario usuario;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @ManyToOne(optional = true)
    @JoinColumn(name = "nomina_id", nullable = false, referencedColumnName = "id")
    private Nomina nomina;

    public DetalleNomina() {}

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(Integer diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public Double getSueldoDevengado() {
        return sueldoDevengado;
    }

    public void setSueldoDevengado(Double sueldoDevengado) {
        this.sueldoDevengado = sueldoDevengado;
    }

    public Double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(Double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public Double getValorHorasExtras() {
        return valorHorasExtras;
    }

    public void setValorHorasExtras(Double valorHorasExtras) {
        this.valorHorasExtras = valorHorasExtras;
    }

    public Double getDescuentoSalud() {
        return descuentoSalud;
    }

    public void setDescuentoSalud(Double descuentoSalud) {
        this.descuentoSalud = descuentoSalud;
    }

    public Double getDescuentoPension() {
        return descuentoPension;
    }

    public void setDescuentoPension(Double descuentoPension) {
        this.descuentoPension = descuentoPension;
    }

    public Double getDescuentoFondoSolidaridad() {
        return descuentoFondoSolidaridad;
    }

    public void setDescuentoFondoSolidaridad(Double descuentoFondoSolidaridad) {
        this.descuentoFondoSolidaridad = descuentoFondoSolidaridad;
    }

    public Double getOtrosDescuentos() {
        return otrosDescuentos;
    }

    public void setOtrosDescuentos(Double otrosDescuentos) {
        this.otrosDescuentos = otrosDescuentos;
    }

    public Double getTotalDevengado() {
        return totalDevengado;
    }

    public void setTotalDevengado(Double totalDevengado) {
        this.totalDevengado = totalDevengado;
    }

    public Double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(Double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public Double getNetoPagar() {
        return netoPagar;
    }

    public void setNetoPagar(Double netoPagar) {
        this.netoPagar = netoPagar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleNomina)) return false;
        DetalleNomina that = (DetalleNomina) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "DetalleNomina{" +
                "id=" + id +
                ", diasLaborados=" + diasLaborados +
                ", sueldoDevengado=" + sueldoDevengado +
                ", auxilioTransporte=" + auxilioTransporte +
                ", valorHorasExtras=" + valorHorasExtras +
                ", descuentoSalud=" + descuentoSalud +
                ", descuentoPension=" + descuentoPension +
                ", descuentoFondoSolidaridad=" + descuentoFondoSolidaridad +
                ", otrosDescuentos=" + otrosDescuentos +
                ", totalDevengado=" + totalDevengado +
                ", totalDescuento=" + totalDescuento +
                ", netoPagar=" + netoPagar +
                ", usuario=" + usuario +
                ", nomina=" + nomina +
                '}';
    }
}