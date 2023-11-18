
package ActasDeNotas;

import HojaMatricula.Estudiante;
import java.util.Scanner;

public class Principal {
    
   public static void main(String[] args) {
        Principal p = new Principal();
        ClaseProcesos proc = new ClaseProcesos();
       proc.pedirDatosActa();
       proc.leerDatosActa();
        
        ActaNotas acta = new ActaNotas("Programacion I","2024","Ingenieria en Computacion","Diurno",30849,"1M11-Co","C1006","1006",28);
        proc.registrarNotas();
       Estudiante est = new Estudiante();
       
        System.out.println(ClaseProcesos.estudiantes.get(0).getNoCarnet());
        System.out.println(ClaseProcesos.estudiantes.get(0).getNombres());
        System.out.println(ClaseProcesos.estudiantes.get(0).getListaNotas().get(0).getPp());
       
       proc.escribirActa(acta);
        proc.leerDatosActa();
        
        
        
    }
}
