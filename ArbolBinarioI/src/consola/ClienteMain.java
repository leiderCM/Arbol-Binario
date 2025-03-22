
package consola;

import arbolbinario.ArbolBinario;


/**
 *
 * @author 
 */
public class ClienteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner entrada = new Scanner(System.in);
        ArbolBinario ab = new ArbolBinario();
        ab.inicializar();
/*        int opcion = 0;
        int opcion1 = 0;

        do {
            System.out.println("MENU");
            System.out.println("Elija la opcion ha ejecutar");
            System.out.println("1: Recorridos en preorden, inorden, posorden");
            System.out.println("2: imprimir el camino recorrido");
            System.out.println("3: inversion del arbol");
            System.out.println("4: duplicado del arbol");
            System.out.println("5: Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("recorrido preorden");
                    ab.recorridoPreordenRecursivo();
                    System.out.println("recorrido inorden");
                    ab.recorridoInordenRecursivo();
                    System.out.println("reccorrido posorden");
                    ab.recorridoPosOrdenRecursivo();
                    break;
                case 2:
                    System.out.println("Elija el nodo ");
                    opcion1 = entrada.nextInt();
                    ab.imprimiraTodo(opcion1);
                    break;
                case 3:
                    ab.invertirArbolRecursivo();
                    break;
                case 4:
                    System.out.println("duplicado del arbol");
                    ab.clonarArbol();
                case 5:
                    System.out.println("Salir del programa");
                default:
                    System.out.println("has salido");
            }
        } while (opcion != 5);
*/
        //ab.clonarArbol();
        //ab.numeroNivel(16 );
        //ab.podarArbol(2);
        //ab.nodoMayorValor();
        //ab.nodoMenorValor();
       ab.sumaNodos();

        
    }

}
