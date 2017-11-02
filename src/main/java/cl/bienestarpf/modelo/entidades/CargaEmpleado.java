/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bienestarpf.modelo.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Franco
 */
@Entity
@Table(name = "carga_empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargaEmpleado.findAll", query = "SELECT c FROM CargaEmpleado c")
    , @NamedQuery(name = "CargaEmpleado.findByIdEmpleado", query = "SELECT c FROM CargaEmpleado c WHERE c.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "CargaEmpleado.departamentos", query = "SELECT c.departamento, SUM(c.bonoEscolar) , SUM(c.bonoNavidad)  FROM CargaEmpleado c GROUP BY c.departamento")
    , @NamedQuery(name = "CargaEmpleado.findByRutEmpleado", query = "SELECT c FROM CargaEmpleado c WHERE c.rutEmpleado = :rutEmpleado")
    , @NamedQuery(name = "CargaEmpleado.findByDepartamento", query = "SELECT c FROM CargaEmpleado c WHERE c.departamento = :departamento")
    , @NamedQuery(name = "CargaEmpleado.findByCantidadCargas", query = "SELECT c FROM CargaEmpleado c WHERE c.cantidadCargas = :cantidadCargas")
    , @NamedQuery(name = "CargaEmpleado.findByBonoEscolar", query = "SELECT c FROM CargaEmpleado c WHERE c.bonoEscolar = :bonoEscolar")
    , @NamedQuery(name = "CargaEmpleado.findByBonoNavidad", query = "SELECT c FROM CargaEmpleado c WHERE c.bonoNavidad = :bonoNavidad")})
public class CargaEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado")
    @Id
    private int idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "rut_empleado")
    private String rutEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "departamento")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_cargas")
    private long cantidadCargas;
    @Column(name = "bono_escolar")
    private BigInteger bonoEscolar;
    @Column(name = "bono_navidad")
    private BigInteger bonoNavidad;

    public CargaEmpleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public long getCantidadCargas() {
        return cantidadCargas;
    }

    public void setCantidadCargas(long cantidadCargas) {
        this.cantidadCargas = cantidadCargas;
    }

    public BigInteger getBonoEscolar() {
        return bonoEscolar;
    }

    public void setBonoEscolar(BigInteger bonoEscolar) {
        this.bonoEscolar = bonoEscolar;
    }

    public BigInteger getBonoNavidad() {
        return bonoNavidad;
    }

    public void setBonoNavidad(BigInteger bonoNavidad) {
        this.bonoNavidad = bonoNavidad;
    }
    
}
