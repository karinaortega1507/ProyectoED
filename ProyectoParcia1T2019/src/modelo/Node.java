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
    private E dato;
    private Node<E> next, previous;
    
    public Node(E dato){
        this.dato = dato;
        next = previous = null;
    }

    public E getDato() {
        return dato;
    }

    public void setData(E dato) {
        this.dato = dato;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}
