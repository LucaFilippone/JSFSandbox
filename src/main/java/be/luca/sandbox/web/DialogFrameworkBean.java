/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web;

import be.luca.sandbox.entity.Person;
import be.luca.sandbox.service.PersonServiceBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Luca
 */
@Named
@ViewScoped
public class DialogFrameworkBean implements Serializable{
    
    @EJB
    private PersonServiceBeanLocal personServiceBean;

    private List<Person> allPersons = new ArrayList<Person>();
    private List<Person> filteredPersons;
    
    @PostConstruct
    public void init(){
        loadAllPersons();
    }
    
    public void deletePerson(Person p){
        personServiceBean.deletePerson(p);
        Messages.addGlobalInfo("Person "+p.getFirstName()+" "+p.getName()+" has been removed");
     
        loadAllPersons();
    }
    
    private void loadAllPersons(){
        allPersons = personServiceBean.getAllPersons();
    }

    public List<Person> getAllPersons() {
        return allPersons;
    }

    public void setAllPersons(List<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public List<Person> getFilteredPersons() {
        return filteredPersons;
    }

    public void setFilteredPersons(List<Person> filteredPersons) {
        this.filteredPersons = filteredPersons;
    }
    
}
