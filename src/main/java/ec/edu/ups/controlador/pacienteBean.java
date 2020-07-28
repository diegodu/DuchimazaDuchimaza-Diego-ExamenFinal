/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.PacienteFacade;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.Column;

/**
 *
 * @author Diego Duchimaza
 */
@Named(value = "pacienteBean")
@Dependent
public class pacienteBean {

    /**
     * Creates a new instance of pacienteBean
     */
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    
     private String email;
     
     private PacienteFacade pacienteFacade;
    public pacienteBean() {
    }
    
}
