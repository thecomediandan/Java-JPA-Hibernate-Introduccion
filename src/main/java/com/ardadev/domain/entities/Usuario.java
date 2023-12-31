package com.ardadev.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    // GenerationType.IDENTITY sirve cuando configuramos autoincrement en el atributo id
    // GenerationType.AUTO sirve para jpa disponga la mejor manera de tratar el id para la generación
    // GenerationType.SEQUENCE sirve cuando la base de datos esta configurada con una secuencia para generar las id, esta se debe especificar en el atributo generator
    // GenerationType.TABLE sirve cuando la base de datos tiene configurada una tabla para la generación de las id, se especifica en el atributo generator
    @Id
    @Basic(optional = false) // Indicamos que el atributo debe ser considerado para formar parte de la configuracion de mapeo para persistencia tanto para extraer como introducir en la base de datos es decir @Basic es la marca, ademas indicamos que no puede ser nulo con optional=false generalmente no se pone porque jpa lo configura como persistente automaticamente
    @Column(name = "id", nullable = false, length = 11) // nullable es para configurar la persistencia del campo como la tenemos en la base de datos en este caso no puede ser nula
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Averiguar que tipo de generación tiene los id de la base de datos
    private Integer id;

    @Basic
    @Column(name = "activo", length = 4)
    @Enumerated(EnumType.ORDINAL) // EnumType.STRING, EnumType.ORDINAL para configurar un objeto Enum, para este caso es mejor el Ordinal por la configuracion en la base de datos
    private Activo activo;

    @Basic(optional = false)
    @Column(name = "apellidos", length = 20, nullable = false)
    private String apellidos;

    @Basic(optional = false)
    @Column(name = "direccion", length = 40, nullable = false)
    private String direccion;

    @Basic(optional = false)
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Basic(optional = false)
    @Column(name = "nombres", length = 20, nullable = false)
    private String nombres;

    @Basic(optional = false)
    @Column(name = "num_documento", length = 15, nullable = false)
    private String numDocumento;

    @Basic(optional = false)
    @Column(name = "password", length = 100, nullable = false)
    private String contrasena;

    @Basic(optional = false)
    @Column(name = "sueldo_basico", nullable = false)
    private Double sueldoBasico;


    //@Basic(optional = false)
    @ManyToOne(optional = true)
    @JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = true)
    private Cargo cargoId;

    //@Basic(optional = false)
    @ManyToOne(optional = true)
    @JoinColumn(name = "ciudades_id", nullable = true, referencedColumnName = "id")
    private Ciudad ciudadesId;

    //@Basic(optional = false)
    @ManyToOne(optional = true)
    @JoinColumn(name = "tipos_documento_id", nullable = true, referencedColumnName = "id")
    private TipoDocumento tipoDocumentoId;

    @Basic
    @ManyToOne(optional = true)
    @JoinColumn(name = "id_jefe_inmediato", nullable = true, referencedColumnName = "id")
    private Usuario idJefeInmediato;

    // @Transient usado por jpa para excluir este campo como parte de la db
    // @jakarta.json.bind.annotation.JsonbTransient exclusivo de jakarta usado para excluir la serializacion/deserializacion de este campo, las librerias de serializacion y deserializacion como gson tienen sus propias notaciones para esto
    // @Expose es usado por gson para decir que este campo es serializable si no lo tiene lo omitara
    // cascade = CascadeType.ALL, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE
    // CASCADE sirve para ejecutar cambios en forma de cascada, es decir que la persistencia que implique mas de un objeto o entidad será tambien ejecutada
    // Como cuando queramos agregar una entidad que a su vez depende de otra, caso de las entidades relacionadas con una clave foránea
    //@Transient // con transient marcamos el campo como no considerado por jpa para operaciones de persistencia guardado, actualizado o eliminado
    @OneToMany(mappedBy = "idJefeInmediato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> empleadosConJefe;

    //@Transient
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@jakarta.json.bind.annotation.JsonbTransient
    private List<UsuariosHasRoles> usuariosHasRolesList = new ArrayList<>();

    //@Transient
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleNomina> detalleNominaList;

    /**
     * Ejemplo de una relacion uno a uno (OneToOne)
     * En la tabla la cual mapea Usuario
     * @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     * private Perfil perfil;
     *
     * En la tabla que se saca el campo de union Perfil
     * @OneToOne(fetch = FetchType.LAZY)
     * @JoinColumn(name = "usuario_id", referencedColumnName = "id")
     * private Usuario usuario;
     */

    public Usuario() {}

    public Usuario(
            String nombres,
            String apellidos,
            String numDocumento,
            String email,
            String password,
            String direccion,
            Double sueldoBasico,
            Activo activo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numDocumento = numDocumento;
        this.email = email;
        this.contrasena = password;
        this.direccion = direccion;
        this.sueldoBasico = sueldoBasico;
        this.activo = activo;
        this.empleadosConJefe = new ArrayList<>();
        //this.usuariosHasRolesList = new ArrayList<>();
        this.detalleNominaList = new ArrayList<>();
    }

    // Aqui trataremos el relacionamiento bidireccional OneToMany con la configuracion cascade
    // de los campos que tienen relacion con una clave foránea
    public void addDetalleNominaList(DetalleNomina detalleNomina) {
        detalleNomina.setUsuario(this);
        this.detalleNominaList.add(detalleNomina);
    }

    public void addEmpleadosConJefe(Usuario idJefeInmediato) {
        idJefeInmediato.setIdJefeInmediato(this);
        this.empleadosConJefe.add(idJefeInmediato);
    }

    public void addUsuariosHasRolesList(UsuariosHasRoles usuariosHasRoles) {
        usuariosHasRoles.setUsuario(this);
        this.usuariosHasRolesList.add(usuariosHasRoles);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Cargo getCargoId() {
        return cargoId;
    }

    public void setCargoId(Cargo cargoId) {
        this.cargoId = cargoId;
    }

    public Ciudad getCiudadesId() {
        return ciudadesId;
    }

    public void setCiudadesId(Ciudad ciudadesId) {
        this.ciudadesId = ciudadesId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getIdJefeInmediato() {
        return idJefeInmediato;
    }

    public void setIdJefeInmediato(Usuario idJefeInmediato) {
        this.idJefeInmediato = idJefeInmediato;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public TipoDocumento getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(TipoDocumento tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public List<UsuariosHasRoles> getUsuariosHasRolesList() {
        return usuariosHasRolesList;
    }

    public void setUsuariosHasRolesList(List<UsuariosHasRoles> usuariosHasRolesList) {
        this.usuariosHasRolesList = usuariosHasRolesList;
    }

    public List<Usuario> getEmpleadosConJefe() {
        return empleadosConJefe;
    }

    public void setEmpleadosConJefe(List<Usuario> empleadosConJefe) {
        this.empleadosConJefe = empleadosConJefe;
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
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", activo=" + activo.name() +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", nombres='" + nombres + '\'' +
                ", num_documento='" + numDocumento + '\'' +
                ", password='" + contrasena + '\'' +
                ", sueldo_basico=" + sueldoBasico +
                '}';
    }
}