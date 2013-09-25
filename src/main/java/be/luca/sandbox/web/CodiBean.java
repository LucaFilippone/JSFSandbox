/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

/**
 *
 * @author contribute
 */
@Named
@ViewAccessScoped
public class CodiBean implements Serializable{

    private String name;
    
    @PostConstruct
    public void init(){
        name="Luca";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
