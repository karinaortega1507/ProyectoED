/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author Rodriguez-Ortega-Baquerizo
 */
public class CircularDoublyLinkedList<E> implements List<E> {
    private Node head;
    private Node tail;
    private int size;
    
    @Override
    public boolean isEmpty() {
        return size==0;
    }
/**
 * El constructor CircularDoublyLinkedList recibe dos parámetros para ser creada.
 * @param head indica el inicio de la lista doblemente enlazada (parámetro que 
 * depende del ingreso del usuario al escoger el número de la persona que inicia 
 * la ejecución)
 * @param size indica el tamaño de la lista doblemente enlazada (parámetro que 
 * depende del ingreso del usuario al escoger la cantidad de personas) 
 */
    public CircularDoublyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public void add(E e) {
        Node<E> nuevo = new Node<E>(e);
        if (e == null)
            return;
        else if(isEmpty()){
            tail = nuevo;
            nuevo.setNext(nuevo);
            nuevo.setPrev(nuevo);
        }
        else{
            nuevo.setNext(tail.getNext());
            nuevo.setPrev(tail.getPrev());
            tail.setNext(nuevo);
            tail = nuevo;
        
        }
        size++;  
    }

    @Override
    public void addHead(E dato) {
    }
    
     @Override
    public void addTail(E dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void insertPos(E dato, int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePos(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimirPorValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasPrevious() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E previous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void forEachRemaining(Consumer<? super E> action) {
        List.super.forEachRemaining(action); //To change body of generated methods, choose Tools | Templates.
    }

    

  
    
}
