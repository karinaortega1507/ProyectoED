/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Iterator;
import java.util.ListIterator;



/**
 *
 * @author Rodriguez-Ortega-Baquerizo
 * @param <E>
 */
public interface List<E> extends ListIterator<E> {
    public boolean isEmpty();
    public int getSize();
    public void addHead(E dato);
    public void addTail(E dato);
    public void insertPos(E dato, int pos);
    public void removePos(int pos);
    public void imprimirPorValor();
    
    
    
}
