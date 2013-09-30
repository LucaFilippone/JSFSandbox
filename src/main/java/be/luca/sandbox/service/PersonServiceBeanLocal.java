/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.service;

import be.luca.sandbox.entity.Person;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author contribute
 */
@Local
public interface PersonServiceBeanLocal {

    List<Person> getAllPersons();
    
}
