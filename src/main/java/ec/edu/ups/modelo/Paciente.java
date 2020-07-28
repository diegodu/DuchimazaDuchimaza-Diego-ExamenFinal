/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Diego Duchimaza
 */
@Entity
public class Paciente implements Serializable{
      private static final long serialVersionUID = 1L;
    @Id
    private int cedula;
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    
    @Column(unique = true)
    private String email;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CitaMedica> citas;
    
    public Paciente(){
        
    }

    public Paciente(int cedula, String nombre, String apellido, String telefono, String direccion, String email, List<CitaMedica> citas) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.citas = citas;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public List<CitaMedica> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaMedica> citas) {
        this.citas = citas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.cedula;
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
        final Paciente other = (Paciente) obj;
        if (this.cedula != other.cedula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Paciente{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", direccion=" + direccion + ", email=" + email + ", citas=" + citas + '}';
    }
    
    

    
}
