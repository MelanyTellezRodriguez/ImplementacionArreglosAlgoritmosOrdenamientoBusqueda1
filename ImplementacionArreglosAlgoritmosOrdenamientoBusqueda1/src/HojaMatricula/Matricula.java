
package HojaMatricula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Matricula {
    private  int noRecibo;
    private String carrera;
    private int noIncripcion=0;
    private String nombCompleto;
    private String noCarnet;
    private String turno;
    private String planEstudio;
    private String semestre;
    private String fecha;
    public static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private static int contGrupo=0;

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
   
    public Matricula() {
        
    }

    public Matricula(int noRecibo, String nombCompleto, String noCarnet, String carrera, String turno, String planEstudio, String semestre,String fecha,String grupo) {
        this.noRecibo = noRecibo;
        this.carrera = carrera;
        this.noIncripcion ++;
        this.nombCompleto = nombCompleto;
        this.noCarnet = noCarnet;
        this.turno = turno;
        this.planEstudio = planEstudio;
        this.semestre = semestre;
        this.fecha= fecha;
        contGrupo++;
    }


    public int getNoRecibo() {
        return noRecibo;
    }

    public void setNoRecibo(int noRecibo) {
        this.noRecibo = noRecibo;
    }

    public int getNoIncripcion() {
        return noIncripcion;
    }

    public String getNombCompleto() {
        return nombCompleto;
    }

    public void setNombCompleto(String nombCompleto) {
        this.nombCompleto = nombCompleto;
    }

    public String getNoCarnet() {
        return noCarnet;
    }

    public void setNoCarnet(String noCarnet) {
        this.noCarnet = noCarnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(String planEstudio) {
        this.planEstudio = planEstudio;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void crearMatricula(){
         File f = new File("Matricula.txt");
         Asignatura asig = new Asignatura();
        try {
            FileWriter fw =  new FileWriter(f);
            BufferedWriter bf = new BufferedWriter(fw);
            //PrintWriter pw = new PrintWriter(fw);
            
            bf.write("\t\t\t\t\t HOJA DE MATRICULA ");bf.newLine();
            bf.write("\t\t\t\t\t AÑO ACADEMICO "+Principal.annio);bf.newLine();
            bf.write("------------------------------------------------------------------------------------------------------------------");
            bf.newLine();
            bf.write("No. Recibo "+this.getNoRecibo() + "\t\t\t\t\t\t\t No. Inscripcion "+Principal.numInscrip);
            bf.newLine();
            bf.write("--------------------------------------------------------------------------------------------------------------------");
            bf.newLine();
            bf.write("NOMBRE Y APELLIDOS: "+this.getNombCompleto()); 
            bf.newLine(); bf.newLine();
            bf.write("CARRERA: "+this.getCarrera()+"\t\t CARNET: "+this.getNoCarnet()+"\t\t TURNO: "+this.getTurno()); 
            bf.newLine(); bf.newLine();
            bf.write("PLAN DE ESTUDIO: "+this.getPlanEstudio()+"\t\t SEMESTRE: "+this.getSemestre()+"\t\t FECHA: "+this.getFecha());
            bf.newLine();
            bf.write("--------------------------------------------------------------------------------------------------------------------");
            bf.newLine();
            bf.write("No. |\t\t\t ASIGNATURA \t\t | GRUPO\t | AULA  |CRED.  | F  | R "); bf.newLine();
            bf.write("--------------------------------------------------------------------------------------------------------------------");
            bf.newLine();
            //Recorremos el arrayList para sacar los codigos de carrera y buscarlos en el archivo e imprimirlos
            for(int i=0; i<asignaturas.size(); i++){
                Asignatura clase= asignaturas.get(i);
                bf.write((i+1)+"\t "+clase.getCodigo()+" "+clase.getNombre()+"\t\t "+clase.getGrupo()+"\t\t "+clase.getAula()+"\t "+clase.getCreditos()+"\t "+clase.getFrecuencia());
                //pw.printf("%d", args)
                bf.newLine();
            }
            bf.write("--------------------------------------------------- ULTIMA LINEA -----------------------------------------------------------");
            bf.close();
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
        
    }
    public void leerDatosMatricula(){
        File f = new File("Matricula.txt");
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
    public String asignarGrupo(){
        if(this.getCarrera().equalsIgnoreCase("Ingenieria en Sistemas") && Matricula.contGrupo < 30)
            return "1M1-IS";
        else if(this.getCarrera().equalsIgnoreCase("Ingenieria en Sistemas") && Matricula.contGrupo >= 30 && Matricula.contGrupo < 60)
            return "1M2-IS";
        else if(this.getCarrera().equalsIgnoreCase("Ingenieria en Sistemas") && Matricula.contGrupo >= 60 && Matricula.contGrupo < 90)
            return "1M3-IS";
        else if(this.getCarrera().equalsIgnoreCase("Ingenieria en Sistemas") && Matricula.contGrupo >= 90 && Matricula.contGrupo < 120)
            return "1M4-IS";
        else return "Ya no hay cupos para la carrera Ingenieria en Sistemas";
    }
}
