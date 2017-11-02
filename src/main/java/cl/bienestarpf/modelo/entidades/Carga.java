/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bienestarpf.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Franco
 */
@Entity
@Table(name = "carga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carga.findAll", query = "SELECT c FROM Carga c")
    , @NamedQuery(name = "Carga.findById", query = "SELECT c FROM Carga c WHERE c.id = :id")
    , @NamedQuery(name = "Carga.findByRut", query = "SELECT c FROM Carga c WHERE c.rut = :rut")
    , @NamedQuery(name = "Carga.findByNombres", query = "SELECT c FROM Carga c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Carga.findByApellidos", query = "SELECT c FROM Carga c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Carga.findByNacimiento", query = "SELECT c FROM Carga c WHERE c.nacimiento = :nacimiento")
    , @NamedQuery(name = "Carga.findByGenero", query = "SELECT c FROM Carga c WHERE c.genero = :genero")})
public class Carga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "rut")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nacimiento")
    @Temporal(TemporalType.DATE)
    private Date nacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "genero")
    private String genero;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "id_bono_escolar", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BonoEscolar idBonoEscolar;
    @JoinColumn(name = "id_bono_navidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BonoNavidad idBonoNavidad;

    public Carga() {
    }

    public Carga(Integer id) {
        this.id = id;
    }

    public Carga(Integer id, String rut, String nombres, String apellidos, Date nacimiento, String genero) {
        this.id = id;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public BonoEscolar getIdBonoEscolar() {
        return idBonoEscolar;
    }

    public void setIdBonoEscolar(BonoEscolar idBonoEscolar) {
        this.idBonoEscolar = idBonoEscolar;
    }

    public BonoNavidad getIdBonoNavidad() {
        return idBonoNavidad;
    }

    public void setIdBonoNavidad(BonoNavidad idBonoNavidad) {
        this.idBonoNavidad = idBonoNavidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carga)) {
            return false;
        }
        Carga other = (Carga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.bienestarpf.modelo.entidades.Carga[ id=" + id + " ]";
    }
    
}
