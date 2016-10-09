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
@Table(name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findByIdprofesor", query = "SELECT p FROM Profesor p WHERE p.idprofesor = :idprofesor"),
    @NamedQuery(name = "Profesor.findByNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Profesor.findByApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesor.findByDireccion", query = "SELECT p FROM Profesor p WHERE p.direccion = :direccion")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesor")
    private Integer idprofesor;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesor")
    private Collection<Curso> cursoCollection;

    public Profesor() {
    }

    public Profesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Integer getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Integer idprofesor) {
        this.idprofesor = idprofesor;
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
        hash += (idprofesor != null ? idprofesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.idprofesor == null && other.idprofesor != null) || (this.idprofesor != null && !this.idprofesor.equals(other.idprofesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Profesor[ idprofesor=" + idprofesor + " ]";
    }
    
}
