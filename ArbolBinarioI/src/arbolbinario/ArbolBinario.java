/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {

    private Nodo raiz;
    public int nivel = 0;
    public int nivelActual = -1;

    public ArbolBinario() {
        raiz = null;
    }

    public void inicializar() {
        Nodo nodo60 = new Nodo(60);
        // IZQUIERDO
        Nodo nodo41 = new Nodo(41);
        Nodo nodo16 = new Nodo(16);
        Nodo nodo25 = new Nodo(25);
        Nodo nodo53 = new Nodo(53);
        Nodo nodo46 = new Nodo(46);
        Nodo nodo42 = new Nodo(42);
        Nodo nodo55 = new Nodo(55);
        // DERECHO
        Nodo nodo74 = new Nodo(74);
        Nodo nodo65 = new Nodo(65);
        Nodo nodo63 = new Nodo(63);
        Nodo nodo62 = new Nodo(62);
        Nodo nodo64 = new Nodo(64);
        Nodo nodo70 = new Nodo(70);

        raiz = nodo60;
        raiz.setIzquierdo(nodo41);
        nodo41.setIzquierdo(nodo16);
        nodo16.setDerecho(nodo25);

        nodo41.setDerecho(nodo53);
        nodo53.setIzquierdo(nodo46);
        nodo46.setIzquierdo(nodo42);
        nodo53.setDerecho(nodo55);

        raiz.setDerecho(nodo74);
        nodo74.setIzquierdo(nodo65);
        nodo65.setIzquierdo(nodo63);
        nodo63.setIzquierdo(nodo62);
        nodo63.setDerecho(nodo64);
        nodo65.setDerecho(nodo70);

    }

    public void visitar(Nodo aux) {
        System.out.print(aux.getValor() + " ");
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void recorridoPreordenRecursivo() {
        recorridoPreordenRecursivo(raiz);
    }

    public void recorridoPreordenRecursivo(Nodo raiz) {
        if (raiz != null) {
            visitar(raiz);
            recorridoPreordenRecursivo(raiz.getIzquierdo());
            recorridoPreordenRecursivo(raiz.getDerecho());
        }
    }

    public void recorridoInordenRecursivo() {
        recorridoInordenRecursivo(raiz);
    }

    public void recorridoInordenRecursivo(Nodo raiz) {
        if (raiz != null) {
            recorridoInordenRecursivo(raiz.getIzquierdo());
            visitar(raiz);
            recorridoInordenRecursivo(raiz.getDerecho());
        }
    }

    public void recorridoPosOrdenRecursivo() {
        recorridoPosOrdenRecursivo(raiz);
    }

    public void recorridoPosOrdenRecursivo(Nodo raiz) {
        if (raiz != null) {
            recorridoPosOrdenRecursivo(raiz.getIzquierdo());
            recorridoPosOrdenRecursivo(raiz.getDerecho());
            visitar(raiz);
        }
    }
    //inversion del arbol
    public void invertirArbolRecursivo() {
        if (raiz != null) {
            invertirSubarbol(raiz);
        }
    }
    private void invertirSubarbol(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
            Nodo temp = nodo.getIzquierdo();
            nodo.izquierdo = nodo.derecho;
            nodo.derecho = temp;
        }
        invertirSubarbol(nodo.getIzquierdo());
        invertirSubarbol(nodo.getDerecho());
    }
    //retorna el vamino recorrido 
    public void imprimiraTodo(int valor) {
        List<Nodo> camino = new ArrayList<>();
        encontrarCaminoRecursivo(raiz, camino, valor);
        System.out.println("camino recorrido");
        for (Nodo nodo : camino) {
            System.out.println(nodo.getValor() + "");
        }

    }
    private boolean encontrarCaminoRecursivo(Nodo nodo, List<Nodo> camino, int valor) {
        if (nodo == null) {
            return false;
        }
        camino.add(nodo);
        if ((int) nodo.getValor() == valor) {
            return true;
        }
        if (encontrarCaminoRecursivo(nodo.getIzquierdo(), camino, valor)
                || encontrarCaminoRecursivo(nodo.getDerecho(), camino, valor)) {
            return true;
        }
        camino.remove(camino.size() - 1);
        return false;
    }
    //clonar el arbol
    public void clonarArbol() {
        clonarArbol(raiz);
    }
    public Nodo clonarArbol(Nodo raiz) {
        if (raiz == null) {
            return null;
        }
        Nodo nuevoNodo = new Nodo(raiz.getValor());
        visitar(raiz);
        nuevoNodo.setIzquierdo(clonarArbol(raiz.getIzquierdo()));
        nuevoNodo.setDerecho(clonarArbol(raiz.getDerecho()));
        return nuevoNodo;
    }
   //retorna el numeron de nivel
    public void numeroNivel(int valor) {
        int numeroNivel = retornaNivel(raiz, valor, nivel);
        System.out.println("\nNivel del nodo" + numeroNivel);
    }
    public int retornaNivel(Nodo raiz, int valorBuscar, int nivel) {
        if (raiz == null) {
            return -1;
        }
        nivel++;
        if ((int) raiz.getValor() == valorBuscar) {
            return nivel;
        }
        if ((int) raiz.getValor() > valorBuscar) {

            return retornaNivel(raiz.getIzquierdo(), valorBuscar, nivel++);
        }
        if ((int) raiz.getValor() < valorBuscar) {
            return retornaNivel(raiz.getDerecho(), valorBuscar, nivel++);
        }
        return nivel;
    }
    //apodar el arbol desde el nivel -1
    public void podarArbol(int nivelObjetivo) {
        podarArbol(raiz, nivelActual, nivelObjetivo);

    }
    public Nodo podarArbol(Nodo raiz, int nivelActual, int nivelObjetivo) {
        if (raiz == null) {
            return null;
        }
        if (nivelActual == nivelObjetivo) {
            raiz.setIzquierdo(null);
            raiz.setDerecho(null);
            return raiz;
        }
        visitar(raiz);
        raiz.setIzquierdo(podarArbol(raiz.getIzquierdo(), nivelActual + 1, nivelObjetivo));
        raiz.setDerecho(podarArbol(raiz.getDerecho(), nivelActual + 1, nivelObjetivo));
        return raiz;
    }
    // nodo mayor de todo el arbol
    public void nodoMayorValor() {
        nodoMayorValor(raiz);

    }
    public Nodo nodoMayorValor(Nodo raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.getDerecho() == null) {
            visitar(raiz);
            return raiz;
        }
        return nodoMayorValor(raiz.getDerecho());
    }
    //nodo menor de todo el arbol
    public void nodoMenorValor(){
        nodoMenorValor(raiz);
    }
    public Nodo nodoMenorValor(Nodo raiz) { 
        if (raiz == null) {
            return null;
        }
        if (raiz.getIzquierdo() == null) {
            visitar(raiz);
            return raiz;
        }
        return nodoMenorValor(raiz.getIzquierdo());
    } 
    //suma de todos los nodos del arbol
    public void sumaNodos(){
       int summm= sumaNodos(raiz);
        System.out.println(summm);
    }
    public int sumaNodos(Nodo raiz){
        if(raiz == null){
            return 0;
        }
        return (int)raiz.getValor() + sumaNodos(raiz.getIzquierdo()) + sumaNodos(raiz.getDerecho());    
    }
    

     
    

} 
