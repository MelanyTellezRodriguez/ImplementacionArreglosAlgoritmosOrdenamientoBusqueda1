
package ActasDeNotas;

import HojaMatricula.Asignatura;
import HojaMatricula.Estudiante;
import static HojaMatricula.Matricula.asignaturas;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import jxl.Sheet;
import jxl.Workbook;

public class ClaseProcesos<Workbook> {
    private static final String Workbook = null;
    private ArrayList<Notas> listNotas= new ArrayList<>();
    private static boolean encontrado=false;
    public static ArrayList<Estudiante> estudiantes = new ArrayList<>();
   
    public void registrarNotas(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Elija el tipo de nota a ingresar");
        int opc=0;
        Estudiante estudent;
        do{
            System.out.println(" 1. Primer Parcial \n 2. Segundo Parcial \n 3. Proyecto Final \n 4. Sistematicos \n 5. Cancelar");
            System.out.print("Opcion: ");
            opc=leer.nextInt();
            
            switch(opc){
                case 1: 
                    if(ActaNotas.pp == false){
                        leer.nextLine();
                        System.out.print("Escriba numero de Carnet del estudiante: ");
                        String noCarnet = leer.nextLine(); 
                        String nombre=leerDatosEstudiante(noCarnet);
                        if(!encontrado){
                            System.out.println(nombre);
                            break;
                        }
                        else{
                            estudent = new Estudiante(noCarnet,nombre);
                            System.out.println(nombre);
                            System.out.print("Escriba la nota: ");
                            float nota=leer.nextFloat();
                            if(nota <= 35){
                                Notas not = new Notas(noCarnet);
                                not.setPp(nota);
                                estudent.getListaNotas().add(not);
                                crearFileNotas(noCarnet);

                                System.out.println("Nota ingresada exitosamente, elija una opcion para continuar o para cancelar");
                                //ActaNotas.pp=true;
                            }
                            else{
                                System.out.println("Error, la nota no puede exceder a 35, vuelva a intentarlo");

                            }
                        }
                        estudiantes.add(estudent);
                        //System.out.println("Datos estudiante: "+estudent.getNoCarnet()+","+estudent.getNombres());
                    }
                    else
                        System.out.println("La nota del primer parcial ya fue ingresada, elija otra opcion");
                    break;
                case 2:
                    System.out.println("Este curso no incluye nota de segundo parcial, corresponde a proyecto final, por favor elija esta opcion");
//                    if(ActaNotas.sp == false){
//                        leer.nextLine();
//                        System.out.print("Escriba numero de Carnet del estudiante: ");
//                        String noCarnet = leer.nextLine(); 
//                    Notas not=new Notas(noCarnet);
//                        String nombre=leerDatosEstudiante(noCarnet);
//                        System.out.println(nombre);
//                        System.out.print("Escriba la nota: ");
//                        float nota=leer.nextFloat();
//                        if(nota <= 35){
     //                       not.setSp(nota);
//                            System.out.println("Nota ingresada exitosamente, elija una opcion para continuar o para cancelar");
//                            //ActaNotas.sp=true;
//                        }
//                        else{
//                            System.out.println("Error, la nota no puede exceder a 35, vuelva a intentarlo");
//
//                        }

//                         est.getListaNotas().add(not);
//                    }
//                    else
//                        System.out.println("La nota del segundo parcial ya fue ingresada, elija otra opcion");
                    break;
                case 3:
                    if(ActaNotas.pf == false){
                        leer.nextLine();
                        System.out.print("Escriba numero de Carnet del estudiante: ");
                        String noCarnet = leer.nextLine(); 
                        Notas not=new Notas(noCarnet);
                        String nombre=leerDatosEstudiante(noCarnet);
                        System.out.println(nombre);
                        System.out.print("Escriba la nota: ");
                        float nota=leer.nextFloat();
                        if(nota <= 35){
                            not.setPf(nota);
                            System.out.println("Nota ingresada exitosamente, elija una opcion para continuar o para cancelar");
                            //ActaNotas.pf=true;
                        }
                        else{
                            System.out.println("Error, la nota no puede exceder a 35, vuelva a intentarlo");

                        }
                    }
                    else
                        System.out.println("La nota del proyecto final ya fue ingresada, elija otra opcion");
                    break;
                case 4:
                    if(ActaNotas.sist == false){
                        leer.nextLine();
                        System.out.print("Escriba numero de Carnet del estudiante: ");
                        String noCarnet = leer.nextLine(); 
//                        Notas not=new Notas(noCarnet);
                        String nombre=leerDatosEstudiante(noCarnet);
                        System.out.println(nombre);
                        System.out.print("Escriba la nota de sistematicos: ");
                        float nota=leer.nextFloat();
                        if(nota <= 30){
                            Notas not=new Notas(noCarnet);
                            not.setSist(nota);
                            System.out.println("Nota ingresada exitosamente, elija una opcion para continuar o para cancelar");
                            //ActaNotas.sist=true;
                        }
                        else{
                            System.out.println("Error, la nota no puede exceder a 30, vuelva a intentarlo");

                        }
                        
                   }
                    else
                        System.out.println("La nota de sistematicos ya fue ingresada, elija otra opcion");
                    break;
            }
       
        
        }while(opc != 5);
        
    }
    public void leerDatosActa(){
        File f = new File("ActaNotas.txt");
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while(cadena != null){
                System.out.println(cadena);
                cadena = br.readLine();
            }
            
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
    
    }  
     public static String leerDatosEstudiante(String carnet){
        File f = new File("Estudiantes.txt");
        String nombre="";
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while(cadena != null){
                String ref[]=cadena.split(",");
                if(carnet.equalsIgnoreCase(ref[0])){
                    nombre=ref[1];
                    encontrado=true;
                    break;
                }
                else{
                    nombre="Estudiente no encontrado";
                    encontrado=false;
                }
                cadena = br.readLine();
            }
            
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
    return nombre;
    }  
     public void crearFileNotas(String carnet){
         Estudiante est= new Estudiante(carnet);
         Notas nota = new Notas(carnet);
         ArrayList<Float> notas=new ArrayList<>();
         File f = new File("NotasEstudiante.txt");
        //ActaNotas acta= new ActaNotas();
        try {
            FileWriter fw =  new FileWriter(f,true);
            BufferedWriter bf = new BufferedWriter(fw);
                        
            bf.write(est.getNoCarnet()); bf.write(",");
//            bf.write(est.getNombres()); bf.write(",");
            bf.write(String.valueOf(nota.getPp())); bf.write(",");
            bf.write(String.valueOf(nota.getSp())); bf.write(",");
            bf.write(String.valueOf(nota.getSist())); bf.write(",");
            bf.write(String.valueOf(nota.getPf())); bf.write(",");
            bf.write(String.valueOf(nota.getNotaF())); bf.write(",");
            bf.write(String.valueOf(nota.getConvoI())); bf.write(",");
            bf.write(String.valueOf(nota.getNotaFconvoI())); bf.write(",");
            bf.write(String.valueOf(nota.getConvoII())); bf.write(",");
            bf.newLine();
            bf.close();
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
     }
    
     private void leerArchivoExcel(String archivoDestino) { 
        try{ 
            Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino)); 
            System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets()); 
            for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre cada  hoja del libro de excel                                                                                                                                                      
            { 
                Sheet hoja = archivoExcel.getSheet(sheetNo); 
                int numColumnas = hoja.getColumns(); 
                int numFilas = hoja.getRows(); 
                String data; 
                System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(sheetNo).getName()); 
                for (int fila = 0; fila < numFilas; fila++) { // Recorre cada fila de la  hoja de excel
                    for (int columna = 0; columna < numColumnas; columna++) { // Recorre cada columna de la fila                         
                        data = hoja.getCell(columna, fila).getContents(); 
                        System.out.print(data + " "); 

                    } 
                    System.out.println("\n"); 
                } 
            } 
        } catch (Exception ioe) { 
            ioe.printStackTrace(); 
        } 

    } 


        public static void main(String arg[]) { 
            ClaseProcesos excel = new ClaseProcesos(); 
            //excel.leerArchivoExcel("Estudiantes2023.xls"); 
            System.out.println(leerDatosEstudiante("2022-0752U"));
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
        public void pedirDatosActa(){
            Scanner leer = new Scanner(System.in);
            System.out.println("Escriba la siguiente informacion para generacion de Acta de Notas");
            System.out.print("Nombre del curso: ");
            String curso= leer.nextLine();
            System.out.println("Periodo lectivo: ");
            String periodo = leer.nextLine();
            System.out.println("Carrera: ");
            String carrera = leer.nextLine();
            System.out.println("Modalidad: ");
            String modalidad = leer.nextLine();
            System.out.println("Codigo del curso: ");
            int codCurso = Integer.parseInt(leer.nextLine());
            System.out.println("Grupo: ");
            String grupo = leer.nextLine();
            System.out.println("Codigo Asignatura: ");
            String codAsig = leer.nextLine();
            System.out.println("Codigo Programa de Asignatura: ");
            String codProgram = leer.nextLine();
            System.out.println("Cantidad de Estudiantes: ");
            int cantEstudiantes =Integer.parseInt(leer.nextLine());
            
            ActaNotas acta = new ActaNotas(curso,periodo,carrera,modalidad,codCurso,grupo,codAsig,codProgram,cantEstudiantes);
            escribirActa(acta);
        }
        public void escribirActa(ActaNotas acta){
        File f = new File("ActaNotas.txt");
        //ActaNotas acta= new ActaNotas();
        try {
            FileWriter fw =  new FileWriter(f);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write("\t\t\t\t\t DATOS GENERALES ");bf.newLine();
            bf.write("\t Curso: \t  "+acta.getNombCurso()+ "\t\tCod.Curso: \t"+acta.getCodCurso()+"\t Primer Paracial:   "+acta.getPRIMER_PARACIAL());bf.newLine();
            bf.write("\t Periodo Lectivo: "+acta.getPeriodLectivo()+ "\t\t\t\tGrupo: \t\t"+acta.getGrupo()+"\t Segundo Paracial:  "+acta.getSEGUNDO_PARACIAL());bf.newLine();
            bf.write("\t Carrera: \t  "+acta.getCarrera()+ "\tCod.Asignatura: "+acta.getCodAsig()+"\t Sistematicos: \t    "+acta.getSISTEMATICOS());bf.newLine();
            bf.write("\t Modalidad: \t  "+acta.getModalida()+ "\t\t\tCod.Programa:   "+acta.getCodProgram()+"\t Proyecto de Curso: "+acta.getPROY_CURSO());
            bf.newLine();
            
            //Recorremos el arrayList para sacar los codigos de carrera y buscarlos en el archivo e imprimirlos
            for(int i=0; i<asignaturas.size(); i++){
                Asignatura clase= asignaturas.get(i);
                bf.write((i+1)+"\t "+clase.getCodigo()+" "+clase.getNombre()+"\t"+clase.getGrupo()+"\t"+clase.getAula()+"\t"+clase.getCreditos()+"\t"+clase.getFrecuencia());
                bf.newLine();
                bf.newLine();
            }
           
            bf.close();
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
    }
}
