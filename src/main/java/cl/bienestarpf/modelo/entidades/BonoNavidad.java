/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bienestarpf.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Franco
 */
@Entity
@Table(name = "bono_navidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonoNavidad.findAll", query = "SELECT b FROM BonoNavidad b")
    , @NamedQuery(name = "BonoNavidad.findById", query = "SELECT b FROM BonoNavidad b WHERE b.id = :id")
    , @NamedQuery(name = "BonoNavidad.findByNombre", query = "SELECT b FROM BonoNavidad b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "BonoNavidad.findByMonto", query = "SELECT b FROM BonoNavidad b WHERE b.monto = :monto")})
public class BonoNavidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private int monto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBonoNavidad")
    private List<Carga> cargaList;

    public BonoNavidad() {
    }

    public BonoNavidad(Integer id) {
        this.id = id;
    }

    public BonoNavidad(Integer id, String nombre, int monto) {
        this.id = id;
        this.nombre = nombre;
        this.monto = monto;
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

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @XmlTransient
    public List<Carga> getCargaList() {
        return cargaList;
    }

    public void setCargaList(List<Carga> cargaList) {
        this.cargaList = cargaList;
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
        if (!(object instanceof BonoNavidad)) {
            return false;
        }
        BonoNavidad other = (BonoNavidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
}
