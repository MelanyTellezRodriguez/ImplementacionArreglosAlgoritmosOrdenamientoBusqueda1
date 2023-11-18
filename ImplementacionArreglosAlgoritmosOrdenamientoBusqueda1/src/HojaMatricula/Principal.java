
package HojaMatricula;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
    static Date fecha = new Date();
    static LocalDate date = LocalDate.now();
    static int annio = date.getYear();
    static Scanner leer = new Scanner(System.in);
    static String semestre;
    static int numInscrip =800;
    static ArrayList<Asignatura> asignatu = new ArrayList<>();
        
    public static void main(String[] args) {
        iniciarMatricula();
    }
    
    public static void iniciarMatricula(){
        int cont=0,numClases=0;
        Asignatura asig = new Asignatura();
        System.out.println("");
        System.out.println("MATRICULA AÑO LECTIVO 2024 - UNIVERSIDAD NACIONAL DE INGENIERIA");
        System.out.println("FACULTAD DE CIENCIAS Y SISTEMAS");
        System.out.println("");
        System.out.println("Por favor completar los siguientes datos");
        System.out.print("Nombre completo: ");
        String nombre = leer.nextLine();
        System.out.print("Nombre de la Carrera: ");
        String nombCarrera = leer.nextLine();
        System.out.print("Numero de recibo de pago: ");
        int nuRecibof = leer.nextInt();
        leer.nextLine();
        System.out.print("Semestre a inscribir: ");
        semestre = leer.nextLine();
        limpiarConsola();
        System.out.println("");
        
        System.out.println("Para el "+ semestre+ " tiene disponible las siguinetes asignaturas tomando en cuenta la cantidad de creditos que tiene cada una ");
        System.out.println(asig.leerDatosAsignatura(""));
        System.out.print("\nCuantas asignaturas inscribira? : ");
        numClases = leer.nextInt();
        leer.nextLine();
        
        Matricula matricula = new Matricula();
        
        matricula.setNoRecibo(nuRecibof);
        matricula.setNombCompleto(nombre);
        matricula.setNoCarnet(nombre);
        matricula.setCarrera(nombCarrera);
        String current_year;
        matricula.setNoCarnet(annio+"-"+numInscrip+"U");
        matricula.setTurno("Diurno");
        matricula.setPlanEstudio("2020");
        matricula.setSemestre(semestre);
        matricula.setFecha(formato.format(fecha));
        
        //Obtener los codigos de las clases y crear objetos Asignatura
        do{
            if(numClases > 7){
                System.out.println("No puede elegir mas de 7 asignaturas, volver a elegir");
                System.out.print("\nCuantas asignaturas inscribira? : ");
                numClases = leer.nextInt();
                
            }
            else{
                System.out.println("Elegir las Asignaturas escribiendo el codigo");
                System.out.print("Asignatura"+(cont+1)+": "); //leer.nextLine();
                String codigo = leer.nextLine();
                System.out.println(asig.leerDatosAsignatura(codigo));
               
                //Creamos objeto Asignatura y lo agregamos al ArrayList de asignaturas de la clase Matricula
                String cadena[]= asig.leerDatosAsignatura(codigo).split(",");
                String grupo = matricula.asignarGrupo();
                int aula = asig.leerDatosAulas(grupo);
                asig.setCodigo(codigo);
                System.out.println("Codigo creado: "+codigo);
                asig.setNombre(cadena[1]); asig.setGrupo(grupo); asig.setAula(aula);
                //System.out.println("Nombre de la creada: "+cadena[1]);
                System.out.println("");
                asig.setCreditos(Float.parseFloat(cadena[2])); 
                asig.setFrecuencia(Integer.parseInt(cadena[3]));
                asig.leerDatosAsignatura(codigo);
                asignatu.add(new Asignatura(codigo,cadena[1],grupo,aula,Float.parseFloat(cadena[2]),Integer.parseInt(cadena[3])));
                cont++;
            }
        }while (cont < numClases);
        
        matricula.setAsignaturas(asignatu);
        limpiarConsola();
        matricula.crearMatricula(); //Crea el fichero hoja de matricula
        matricula.leerDatosMatricula(); //Muestra la hoja de matricula por consola
    }

    public static void limpiarConsola(){
        try{
            Robot limpiar = new Robot();
            limpiar.keyPress(KeyEvent.VK_CONTROL);
            limpiar.keyPress(KeyEvent.VK_L);
            limpiar.keyRelease(KeyEvent.VK_CONTROL);
            limpiar.keyRelease(KeyEvent.VK_L);
        }  catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }
    
    
}
