
package OrdenacionYBusqueda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ordenacion {
    private static ArrayList<Float> notas =new ArrayList<>();
    
    
    public void ordIntercambioNotasAsc (ArrayList<Float> notas){
	int i, j; float aux;
	for (i = 0 ; i < notas.size()-1; i++)
            for (j = i+1 ; j < notas.size(); j++)
		if (notas.get(i) > notas.get(j))
		{   //Intercambio de valores del arreglo
                    aux = notas.get(i);
                    notas.set(i, notas.get(j));
                    notas.set(j, aux);
		}
    }
    public void ordIntercambioNotasDesc (ArrayList<Float> notas){
	int i, j; float aux;
	for (i = 0 ; i < notas.size()-1; i++)
            for (j = i+1 ; j < notas.size(); j++)
		if (notas.get(i) < notas.get(j))
		{
                    aux = notas.get(i);
                    notas.set(i, notas.get(j));
                    notas.set(j, aux);
		}
    }
    public static int busquedaBinaria(ArrayList<Float>notas, float notaBuscada, String noCarnet) {
        int result = -1;
        int limInf = 0;
        int limSup = notas.size();
        int indice;

        while (limInf <= limSup && result == -1) {
            indice = (limInf + limSup) / 2;

            if (notas.get(indice) == notaBuscada) {
                //System.out.println("Encontrado");
                result = indice;
            }else if (notaBuscada > notas.get(indice)) {
                limInf = indice + 1;
            }else if (notaBuscada < notas.get(indice)) {
                limSup = indice - 1;
            }
        }
        return result;
    }
    
    public static ArrayList<Float> buscarNotas(String tipoNota, String codAsig) {
        File f = new File("NotasEstudiante.txt");
        ArrayList<Float> notas=null;
        try {
            FileReader fr =  new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String cadena = br.readLine();
            while(cadena != null){
                String ref[]=cadena.split(",");
                if(codAsig.equalsIgnoreCase(ref[0])){
                    //notas.add(Float.parseFloat(ref[0]));
                    System.out.println("");
                    break;
                }
                cadena = br.readLine();
            }
            
        } catch (IOException ex) {
            System.out.println("Ocurrio un ERROR: "+ex.getMessage());
        }
     return notas;
    }
    
    
    public void imprimirOrden(ArrayList<Float> notas,String tipo){
        System.out.println("Notas ordenadas "+ tipo);
        for(int i=0;  i<notas.size(); i++){
            System.out.println(notas.get(i));
        }
        
    }
   

}
