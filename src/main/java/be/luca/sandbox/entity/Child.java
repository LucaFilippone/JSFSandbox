/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Luca
 */
@Entity
@Table(name = "CHILD")
@NamedQueries({
    @NamedQuery(name = "Child.findAll", query = "SELECT c FROM Child c"),
    @NamedQuery(name = "Child.findById", query = "SELECT c FROM Child c WHERE c.id = :id"),
    @NamedQuery(name = "Child.findByFirstName", query = "SELECT c FROM Child c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Child.findByName", query = "SELECT c FROM Child c WHERE c.name = :name")})
public class Child implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "CHILD_ID_GENERATOR", sequenceName = "SEQ_CHILD", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_ID_GENERATOR")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "FIRST_NAME")
    private String firstName;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    
    @JoinColumn(name = "PERSON_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;

    public Child() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof Child)) {
            return false;
        }
        Child other = (Child) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.luca.sandbox.entity.Child[ id=" + id + " ]";
    }
    
}
