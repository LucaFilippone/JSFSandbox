/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web.beans;

import be.luca.sandbox.entity.Person;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@RequestScoped
public class PersonDialogBean {
    
    private Person person;
    
    @PostConstruct
    public void init(){
        createNewPerson();
    }
    
    public void returnPerson(){
        RequestContext.getCurrentInstance().closeDialog(getPerson());
    }
    
    public void createNewPerson(){
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
