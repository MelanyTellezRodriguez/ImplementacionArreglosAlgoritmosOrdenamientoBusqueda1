
package ActasDeNotas;

public class Notas {
    private float pp;
    private float sp ;
    private float pf;
    private float sist;
    private float notaF;
    private float convoI;
    private float convoII;
    private float notaFconvoI;
    

    public Notas(String noCarnet) {
        this.pp = 0.00f;
        this.sp = 0.00f;
        this.pf = 0.00f;
        this.sist = 0.00f;
        this.convoI = 0.00f;
        this.convoII = 0.00f;
        this.notaFconvoI = 0.00f;
    }


    public float getPp() {
        return pp;
    }

    public void setPp(float pp) {
        this.pp = pp;
    }

    public float getSp() {
        return sp;
    }

    public void setSp(float sp) {
        this.sp = sp;
    }

    public float getPf() {
        return pf;
    }

    public void setPf(float pf) {
        this.pf = pf;
    }

    public float getSist() {
        return sist;
    }

    public void setSist(float sist) {
        this.sist = sist;
    }

    public float getNotaF() {
        if(ActaNotas.pf == true)
            return (this.getPp()+this.getSist()+this.getPf());
        else
            return (this.getPp()+this.getSist()+this.getSp());
    }

    public void setNotaF(float notaF) {
        this.notaF = notaF;
    }

    public float getConvoI() {
        return convoI;
    }

    public void setConvoI(float convoI) {
        this.convoI = convoI;
    }

    public float getConvoII() {
        return convoII;
    }

    public void setConvoII(float convoII) {
        this.convoII = convoII;
    }

    public float getNotaFconvoI() {
        return this.getSist()+this.getConvoI();
    }

    public void setNotaFconvoI(float notaFconvoI) {
        this.notaFconvoI = notaFconvoI;
    }
    
    
}
