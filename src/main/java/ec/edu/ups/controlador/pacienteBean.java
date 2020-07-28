/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.CitaMedicaFacade;
import ec.edu.ups.ejb.PacienteFacade;
import ec.edu.ups.modelo.CitaMedica;
import ec.edu.ups.modelo.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;

import javax.persistence.Column;

/**
 *
 * @author Diego Duchimaza
 */

@Named(value = "pacienteBean")
@SessionScoped
public class pacienteBean implements Serializable{

    /**
     * Creates a new instance of pacienteBean
     */
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    
     private String email;
     
     
    private double presion;
    private double frecuenciaCardiaca;
    private double frecuenciaRespiratoria;
    private double temperatura;
    private String Sistomas;
    private String Alergias;
    private String enfermedades;
     
     @EJB
     private PacienteFacade pacienteFacade;
     @EJB
     private CitaMedicaFacade citaFacade;
     
     private List<Paciente> pacientes;
     private List<CitaMedica> citas;
     
     private Paciente paciente;
     private CitaMedica cita;
     
     
    public pacienteBean() {
        
    }
    
    
    @PostConstruct
    public void init() {
        this.pacientes = new ArrayList<>();

        try {
            this.citas = this.citaFacade.findAll();
            
            
            System.out.println("lista de pacientes en el init.." + this.pacientes);

        } catch (Exception e) {
            System.out.println("Error --- " + e);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<CitaMedica> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaMedica> citas) {
        this.citas = citas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public CitaMedica getCita() {
        return cita;
    }

    public void setCita(CitaMedica cita) {
        this.cita = cita;
    }

    public double getPresion() {
        return presion;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public double getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(double frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getSistomas() {
        return Sistomas;
    }

    public void setSistomas(String Sistomas) {
        this.Sistomas = Sistomas;
    }

    public String getAlergias() {
        return Alergias;
    }

    public void setAlergias(String Alergias) {
        this.Alergias = Alergias;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }
    
     public void buscarPorNombre() {
        if (nombre != null) {
           
            this.pacientes = pacienteFacade.findByName(this.nombre);
            //System.out.println("autoresssss..... " + this.autores );
        } else {
            //System.out.println("Es nulo... ");
            this.pacientes = this.pacienteFacade.findAll();
        }
        //System.out.println("Nombreee............ " + nombredeAutor);
        System.out.println("pacientess..... " + this.pacientes );
        nombre = null;
    }
    
    
    
       public void listar() {
        try {
            this.pacientes = this.pacienteFacade.findAll();
            this.citas = this.citaFacade.findAll();
            System.out.println("lista de pacientes---------- " + this.pacientes);
        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
       }
        
       public void guardarCita(){
        System.out.println("entrando al metodo de gaurdar capitulo----------------");
        CitaMedica cita= new CitaMedica();
        cita.setPresion(this.presion);
        cita.setFrecuenciaCardiaca(this.frecuenciaCardiaca);
        cita.setFrecuenciaRespiratoria(this.frecuenciaRespiratoria);
        cita.setTemperatura(this.temperatura);
        cita.setSistomas(this.Sistomas);
        cita.setAlergias(this.Alergias);
        cita.setEnfermedades(this.enfermedades);
       

        System.out.println("citas " + this.citas.toString());

        cita.setPaciente(this.paciente);
  
        paciente.addCita(cita);
        citaFacade.create(cita);

        this.citas.add(cita);

       

        //this.capitulos.add(capitulo);
    }
    
    
    
}
