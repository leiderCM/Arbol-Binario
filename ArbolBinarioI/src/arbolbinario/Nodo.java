/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinario;

/**
 *
 * @author PABLO RUIZ
 */
public class Nodo {

    public Object valor;
    public  Nodo izquierdo;
    public Nodo derecho;
    

    public Nodo() {
        valor = null;
        izquierdo = null;
        derecho = null;
    }

    public Nodo(Object valor) {
        this.valor = valor;
        izquierdo = null;
        derecho = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}
