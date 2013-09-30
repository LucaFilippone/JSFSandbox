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
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author contribute
 */
@Named
@ViewScoped
public class CodiBean implements Serializable {

    @EJB
    private PersonServiceBeanLocal personService;
    
    private List<Person> personList = new ArrayList<Person>();

    @PostConstruct
    public void init() {

        personList = personService.getAllPersons();
        System.out.println(personList.size() + " persons found!");
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
