
package HojaMatricula;

import ActasDeNotas.ActaNotas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Asignatura {
    private String codigo;
    private String nombre;
    private String grupo;
    private int aula;
    private float creditos;
    private int frecuencia;
    private boolean retiro;

    public Asignatura() {
        
    }

    public Asignatura(String codigo, String nombre, String grupo, int aula,float creditos, int frecuencia) {
        this.codigo = codigo;
        this.nombre=nombre;
        this.grupo= grupo;
        this.aula = aula;
        this.creditos = creditos;
        this.frecuencia = frecuencia;
        this.retiro=false;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public boolean isRetiro() {
        return retiro;
    }

    public void setRetiro(boolean retiro) {
        this.retiro = retiro;
    }
    
    //Leer fichero Asignaturas para mostrarla en la creacion del codigo de la asignatura elegida
    public String leerDatosAsignatura(String cod){
        File f = new File("Asignaturas.txt");
        String cadena="";
        String cad ="";
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            cad = br.readLine();
            while(cad != null){
                if(cod.equals("")){
                    cadena+=cad + "\n";
                }
                else{
                    String codigo[]=cad.split(",");
                    if(cod.equalsIgnoreCase(codigo[0])){
                        cadena= cad;
                        break;
                    }
                }
                cad = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
        return cadena;
    }
    //Leer datos de aulas
    public int leerDatosAulas(String grupo){
        File f = new File("Aulas.txt");
        int dato=0;
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();

            while(cadena != null){
                String grup[]=cadena.split(",");
                    if(grupo.equalsIgnoreCase(grup[0])){
                        dato= Integer.parseInt(grup[1]);
                        break;
                    }
                }
                cadena = br.readLine();
            } catch (IOException ex) {
                System.out.println("Ocurrio un ERROR: "+ex.getMessage());
            }
        return dato;
        }  
    
}
