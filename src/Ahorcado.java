import java.util.Scanner;
import java.io.IOException;
import java.util.Date;

/**
 * Clase Ahorcado. 
 * Se encarga de generar los funcionalidades necesarias para implementar 
 * los métodos de control y gestión de la partida de nuestro juego.
 *
 * @author Odei
 * @version 30.06.2013
 */
public class Ahorcado {
    
    /**
     * Genera y ejecuta una instancia de la aplicación Ahorcado mostrando
     * mediante línea de comandos las intrucciones a seguir.
     * 
     * @param args String[]: argumentos de la línea de comandos
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        String palabras[] = { "arlequin", "ambrosio",  "macgyver", "chiquetete",
                              "torrente", "chanquete", "mortadelo","paquirrin",
                              "espinete", "povedilla", "romualdo", "barcenas"};
        String eleccion = palabras[(int)(Math.random()*palabras.length)]; 
        String letrasUsadas = "", aux = "";
        int comparar[] = new int[eleccion.length()], errores=0;
        char caracter;	
        boolean sw=false;

        System.out.println("!!Juego del Ahorcado con Personajes¡¡\n");
        for(int i=0;i<eleccion.length();i++)
            aux=aux+"_ ";

        long ti=new Date().getTime();
        do {
            System.out.print(aux+"\tErrores: "+errores);
            if(letrasUsadas.length()>0) {
                System.out.print("\tLetras usadas: ");
                for(int i=0;i<letrasUsadas.length();i++)
                    System.out.print(letrasUsadas.charAt(i)+", ");
            }

            System.out.print("\n\nIntroduce Letra: ");
            caracter=input.next().charAt(0);
                letrasUsadas+=caracter;

                if(eleccion.indexOf(caracter)>=0) {
                    aux="";sw=true;
                    for(int i=0;i<comparar.length;i++) {
                        if(caracter==eleccion.charAt(i))
                                comparar[i]=1;
                        if(comparar[i]==1)
                                aux+=eleccion.charAt(i)+" ";
                        else
                                aux += "_ ";
                    }
                    for(int j=0;j<comparar.length;j++)
                        if(comparar[j]!=1)
                            sw=false;
                    if(sw)
                        System.out.println("\nFelicidades. Acertaste el Nombre :)");
                } else {
                        errores++;
                        System.out.println();
                        switch(errores) {
                            case 1:	
                                        System.out.println("\t\t\t   _ _");
                            break;
                            case 2:	System.out.println("\t\t\t    /");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t   _|_");
                            break;
                            case 3:     System.out.println("\t\t\t    /¯¯¯¯¯");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t   _|_");
                            break;
                            case 4:	System.out.println("\t\t\t    /¯¯¯¯¯|");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t   _|_");
                            break;
                            case 5:     System.out.println("\t\t\t    /¯¯¯¯¯|");
                                        System.out.println("\t\t\t    |     o");
                                        System.out.println("\t\t\t    |");
                                        System.out.println("\t\t\t   _|_");
                            break;
                            case 6:	System.out.println("\t\t\t    /¯¯¯¯¯|");
                                        System.out.println("\t\t\t    |     o");
                                        System.out.println("\t\t\t    |     |");
                                        System.out.println("\t\t\t   _|_");
                            break;
                            case 7:	System.out.println("\t\t\t    /¯¯¯¯¯|");
                                        System.out.println("\t\t\t    |    _o_");
                                        System.out.println("\t\t\t    |     |");
                                        System.out.println("\t\t\t   _|_");
                            break;
                            case 8:	System.out.println("\t\t\t    /¯¯¯¯¯|");
                                        System.out.println("\t\t\t    |    _o_");
                                        System.out.println("\t\t\t    |    _|_");
                                        System.out.println("\t\t\t   _|_");
                                        System.out.println("\nLo siento. "
                                                + "Has perdido el juego :(");
                        }
                }System.out.println();
        } while(errores<8 && !sw);
        
        System.out.println("___________________________________\n");
        System.out.println("La palabra a adivinar era: '" + eleccion + "'");
        System.out.println("Nº Intentos: " + (letrasUsadas.length()-1) +
                           ".\tDuración de Partida: "
                           + (new Date().getTime()-ti) / 1000 + " segundos");
    }
}