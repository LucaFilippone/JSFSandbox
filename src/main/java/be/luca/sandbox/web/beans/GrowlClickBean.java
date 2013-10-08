/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.Messages;

/**
 *
 * @author Luca
 */
@Named
@RequestScoped
public class GrowlClickBean {
    
    public void showGrowl(){
        Messages.addGlobalInfo("This is the global info growl!");
    }
    
}
