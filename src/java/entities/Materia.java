/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.Size;

/**
 *
 * @author santeliz
 */
@Entity
@Table(name = "materia")
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByIdmateria", query = "SELECT m FROM Materia m WHERE m.idmateria = :idmateria"),
    @NamedQuery(name = "Materia.findByDescripcion", query = "SELECT m FROM Materia m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Materia.findByPonde1", query = "SELECT m FROM Materia m WHERE m.ponde1 = :ponde1"),
    @NamedQuery(name = "Materia.findByPonde2", query = "SELECT m FROM Materia m WHERE m.ponde2 = :ponde2"),
    @NamedQuery(name = "Materia.findByPonde3", query = "SELECT m FROM Materia m WHERE m.ponde3 = :ponde3")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmateria")
    private Integer idmateria;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ponde1")
    private BigDecimal ponde1;
    @Column(name = "ponde2")
    private BigDecimal ponde2;
    @Column(name = "ponde3")
    private BigDecimal ponde3;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmateria")
    private Collection<Curso> cursoCollection;

    public Materia() {
    }

    public Materia(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public Integer getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Integer idmateria) {
        this.idmateria = idmateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPonde1() {
        return ponde1;
    }

    public void setPonde1(BigDecimal ponde1) {
        this.ponde1 = ponde1;
    }

    public BigDecimal getPonde2() {
        return ponde2;
    }

    public void setPonde2(BigDecimal ponde2) {
        this.ponde2 = ponde2;
    }

    public BigDecimal getPonde3() {
        return ponde3;
    }

    public void setPonde3(BigDecimal ponde3) {
        this.ponde3 = ponde3;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmateria != null ? idmateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.idmateria == null && other.idmateria != null) || (this.idmateria != null && !this.idmateria.equals(other.idmateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Materia[ idmateria=" + idmateria + " ]";
    }
    
}
