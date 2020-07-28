/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Diego Duchimaza
 */
@Entity
public class CitaMedica implements Serializable{
      private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private double presion;
    private double frecuenciaCardiaca;
    private double frecuenciaRespiratoria;
    private double temperatura;
    private String Sistomas;
    private String Alergias;
    private String enfermedades;
    
    @ManyToOne
    private Paciente paciente;
    
    public CitaMedica(){
        
    }

    public CitaMedica(int codigo, double presion, double frecuenciaCardiaca, double frecuenciaRespiratoria, double temperatura, String Sistomas, String Alergias, String enfermedades, Paciente paciente) {
        this.codigo = codigo;
        this.presion = presion;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperatura = temperatura;
        this.Sistomas = Sistomas;
        this.Alergias = Alergias;
        this.enfermedades = enfermedades;
        this.paciente = paciente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CitaMedica other = (CitaMedica) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CitaMedica{" + "codigo=" + codigo + ", presion=" + presion + ", frecuenciaCardiaca=" + frecuenciaCardiaca + ", frecuenciaRespiratoria=" + frecuenciaRespiratoria + ", temperatura=" + temperatura + ", Sistomas=" + Sistomas + ", Alergias=" + Alergias + ", enfermedades=" + enfermedades + ", paciente=" + paciente + '}';
    }
    
    
    
}
