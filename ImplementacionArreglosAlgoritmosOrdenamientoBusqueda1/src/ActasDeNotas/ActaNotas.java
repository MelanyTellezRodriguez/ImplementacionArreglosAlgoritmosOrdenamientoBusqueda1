
package ActasDeNotas;

import HojaMatricula.Estudiante;
import java.util.ArrayList;

public class ActaNotas {
    private String nombCurso;
    private String periodLectivo;
    private String carrera;
    private String modalida;
    private int codCurso;
    private String grupo;
    private String codAsig;
    private String codProgram;
    private int cantEstudiantes;
    private final float PRIMER_PARACIAL=35.00f;
    private final float SEGUNDO_PARACIAL=35.00f;
    private final float SISTEMATICOS=30.00f;
    private final float PROY_CURSO=0.00f;
    public static boolean pp=false,sp=false,sist=false,pf=false;
    public static ArrayList<Estudiante> notasEst = new ArrayList<>();
    
    public ActaNotas() {
    }

    public float getPRIMER_PARACIAL() {
        return PRIMER_PARACIAL;
    }

    public float getSEGUNDO_PARACIAL() {
        return SEGUNDO_PARACIAL;
    }

    public float getSISTEMATICOS() {
        return SISTEMATICOS;
    }

    public float getPROY_CURSO() {
        return PROY_CURSO;
    }

    public ActaNotas(String nombCurso, String periodLectivo, String carrera, String modalida, int codCurso, String grupo, String codAsig, String codProgram, int cantEstudiantes) {
        this.nombCurso = nombCurso;
        this.periodLectivo = periodLectivo;
        this.carrera = carrera;
        this.modalida = modalida;
        this.codCurso = codCurso;
        this.grupo = grupo;
        this.codAsig = codAsig;
        this.codProgram = codProgram;
        this.cantEstudiantes = cantEstudiantes;
    }

    public String getNombCurso() {
        return nombCurso;
    }

    public void setNombCurso(String nombCurso) {
        this.nombCurso = nombCurso;
    }

    public String getPeriodLectivo() {
        return periodLectivo;
    }

    public void setPeriodLectivo(String periodLectivo) {
        this.periodLectivo = periodLectivo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getModalida() {
        return modalida;
    }

    public void setModalida(String modalida) {
        this.modalida = modalida;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCodAsig() {
        return codAsig;
    }

    public void setCodAsig(String codAsig) {
        this.codAsig = codAsig;
    }

    public String getCodProgram() {
        return codProgram;
    }

    public void setCodProgram(String codProgram) {
        this.codProgram = codProgram;
    }

    public int getCantEstudiantes() {
        return cantEstudiantes;
    }

    public void setCantEstudiantes(int cantEstudiantes) {
        this.cantEstudiantes = cantEstudiantes;
    }
    
    
}
