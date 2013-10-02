/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.service;

import be.luca.sandbox.entity.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author contribute
 */
@Stateless
public class PersonServiceBean implements PersonServiceBeanLocal {
    
    @PersistenceContext(name = "SandboxPU")
    private EntityManager em;
    
    @Override
    public List<Person> getAllPersons() {
        return em.createNamedQuery("Person.findAll").getResultList();
    }

    @Override
    public Person mergePerson(Person p) {
        return em.merge(p);
    }

    @Override
    public void deletePerson(Person p) {
        em.remove(em.find(Person.class, p.getId()));
    }

}
