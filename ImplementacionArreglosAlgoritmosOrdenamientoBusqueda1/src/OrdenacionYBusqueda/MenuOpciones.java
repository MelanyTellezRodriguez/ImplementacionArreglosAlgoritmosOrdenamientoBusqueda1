
package OrdenacionYBusqueda;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOpciones {
    static Scanner leer = new Scanner(System.in);
    private static ArrayList<Float> notas =new ArrayList<>();
    static Ordenacion orden = new Ordenacion();
    
    public static int Menu(){
        int opc;
        System.out.println("Elija la opcion que desee ejecutar:");
        System.out.println("A: Orden Ascendente \n\t 1. Por nota final \n\t 2. Por nota final despues de Convocatoria \n\t 3. Por nota despues de segunda convocatoria");
        System.out.println("B Orden Descendente \n\t 4. Por nota final \n\t 5. Por nota final despues de Convocatoria \n\t 6. Por nota despues de segunda convocatoria");
        System.out.println("C: Busqueda de Notas \n\t 7. Por nota final \n\t 8. Por nota final despues de Convocatoria \n\t 9. Por nota despues de segunda convocatoria");
        System.out.println("D: Mostrar notas antes de Convocataoria \n\t 10. Reprobado (0 - 59) \n\t 11. Regular (60 - 69) \n\t "
                + "12. Bueno (70 - 79) \n\t 13. Muy bueno (80 - 89) \n\t 14. Excelente (90 - 100) 15. \n\t Todas " );
        System.out.println("E: Pulse 0 para salir");
        System.out.print("Opcion: "); 
        opc=leer.nextInt();
        
        return opc;
        
    }
    public static void main(String[] args) {
        notas.add(50.9f); notas.add(85.2f); notas.add(90.7f); notas.add(78.0f);notas.add(68.7f);
        
        int opcion = 0;
        do{
             opcion = Menu();
             switch(opcion){
                 case 1: orden.ordIntercambioNotasAsc(notas); orden.imprimirOrden(notas,"Ascendente");
                 case 4: orden.ordIntercambioNotasDesc(notas); orden.imprimirOrden(notas,"Descendente");
             }
            
        }while (opcion != 0);
       
    }
}
