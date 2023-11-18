
package HojaMatricula;

import ActasDeNotas.ActaNotas;
import ActasDeNotas.Notas;
import java.util.ArrayList;

public class Estudiante {
    private String noCarnet;
    private String nombres;
    private String codInscripcion;
    private String telefono;
    private String email;
    private String direccion;
    public ArrayList<Notas> listaNotas= new ArrayList<>();

    public Estudiante() {
    }

    public Estudiante(String noCarnet, String nombres, String codInscripcion, String telefono, String email, String direccion, ArrayList<Float> notas) {
        this.noCarnet = noCarnet;
        this.nombres = nombres;
        this.codInscripcion = codInscripcion;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }
    public Estudiante(String noCarnet){
        this.noCarnet= noCarnet;
    }


    public Estudiante(String noCarnet, String nombres) {
        this.noCarnet = noCarnet;
        this.nombres = nombres;
    }

    public ArrayList<Notas> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Notas> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCodInscripcion() {
        return codInscripcion;
    }

    public void setCodInscripcion(String codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
