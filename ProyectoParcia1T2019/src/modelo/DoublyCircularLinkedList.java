/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;
import java.util.Iterator;
import java.util.ListIterator;

/**

 @author 
 * @param <E>
 */
public class DoublyCircularLinkedList<E> implements List<E>, Iterable<E> {

    private Node<E> last;
    private int efectivo;

    public DoublyCircularLinkedList () {
        last = null;
        efectivo = 0;
    }

    @Override
    public boolean addFirst (E element) {
        Node<E> nodo = new Node<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            last = nodo;
            nodo.setNext(nodo);
            nodo.setPrevious(nodo);
        } else {
            nodo.setNext(last.getNext());
            nodo.setPrevious(last);
            last.getNext().setPrevious(nodo);
            nodo.setNext(last.getNext());
            last.setNext(nodo);
        }
        efectivo++;
        return true;

    }

    @Override
    public boolean addLast (E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeFirst () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeLast () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getFirst () {
        return (E) last.getNext().getDato();
    }

    @Override
    public E getLast () {
        return last.getDato();
    }

    @Override
    public boolean insert (int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains (E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get (int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf (E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty () {
        return last == null;
    }

    @Override
    public E remove (int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove (E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set (int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int size () {
        return efectivo;
    }

    /**
     * @param index
     * @return 
     */
    public ListIterator<E> listIterator (int index) {
        if(last == null || index > efectivo)
            return null;
        
        ListIterator<E> it;
        it = new ListIterator<E>() {

            private Node<E> p = jump();
            private int currentIndex = index;
            
            private Node<E> jump(){
                Node<E> nodoSalto = last.getNext();
                for(int i= 0; i !=index; i++){
                    nodoSalto = nodoSalto.getNext();
                }
                return nodoSalto;
            }
            
            @Override
            public boolean hasNext () {
                return currentIndex < efectivo;
            }

            @Override
            public E next () {
                E tmp = p.getDato();
                p = p.getNext();
                currentIndex++;
                return tmp;
            }

            @Override
            public boolean hasPrevious () {
                return currentIndex > 0;
            }

            @Override
            public E previous () {
                p = p.getPrevious();
                currentIndex --;
                return p.getDato();
            }

            @Override
            public int nextIndex () {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex () {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove () {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set (E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add (E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        return it;
    }

     @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            
            private Node<E> p = last.getNext();
            private int currentIndex = 0;

            @Override
            public boolean hasNext () {
                return currentIndex < efectivo;
            }

            @Override
            public E next () {
                E tmp = p.getDato();
                p = p.getNext();
                currentIndex++;
                return tmp;
            }
        };
        
        return it;
    }
}


