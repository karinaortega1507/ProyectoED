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
    private Node prev;
    private E dato;
    /** 
     * Constructor para la clase Node
     */
    public Node(){
        next=null;
        prev= null;
       
       // dato=(Integer)0; //pendiente ver si es necesario inicializar el dato
          
    }
    /**
     * Constructor para la clase Node que recibe parametros
     * @param anterior hace referencia al nodo anterior
     * @param siguiente hace referencia al nodo siguiente
     * @param dato hace referencia al dato
     */
    
    public Node(Node prev, Node next, E dato){
        this.prev=prev;
        this.next=next;
        this.dato=dato;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }
    
}
