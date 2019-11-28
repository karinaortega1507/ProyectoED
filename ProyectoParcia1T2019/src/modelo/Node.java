/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Rodriguez-Ortega-Baquerizo
 */
public class Node<E> {
    
    private Node next;
    private Node previous;
    private E dato;
    /** 
     * Constructor para la clase Node
     */
    public Node(E dato){
        next = previous = null;
        this.dato = dato; //el dato se crea al momento de inicializar la lista con valores enteros
          
    }
    
    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
    @Override
    public String toString() {
        return "dato=" + dato ;
    }
    
}
