/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web;

import be.luca.sandbox.entity.Person;
import be.luca.sandbox.service.PersonServiceBeanLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Luca
 */
@Named
@RequestScoped
public class ClientSideValidationBean implements Serializable {
    
    @EJB
    private PersonServiceBeanLocal personServiceBean;
    
    private Person person;
    
    @PostConstruct
    public void init(){
        person = new Person();
    }
    
    public void addPerson(){
        person = personServiceBean.mergePerson(person);
        
        Messages.addGlobalInfo(person.getFirstName()+" "+person.getName()+" added!");
        
        person = new Person();
        
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
   
}
