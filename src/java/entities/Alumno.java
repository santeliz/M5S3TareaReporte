/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
@Table(name = "alumno")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdalumno", query = "SELECT a FROM Alumno a WHERE a.idalumno = :idalumno"),
    @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alumno.findByApellido", query = "SELECT a FROM Alumno a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalumno")
    private Integer idalumno;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalumno")
    private Collection<Curso> cursoCollection;

    public Alumno() {
    }

    public Alumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alumno[ idalumno=" + idalumno + " ]";
    }
    
}
