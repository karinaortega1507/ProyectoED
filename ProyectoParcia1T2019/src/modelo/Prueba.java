/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author Hp
 */
public class Prueba {
    public static void main(String[] args){
        DoublyCircularLinkedList<Integer> personas = new DoublyCircularLinkedList<>();
        System.out.println("Ingrese n");
        Scanner s = new Scanner (System.in);
        int p = s.nextInt();
        for(int i = p; i > 0; i--){
            personas.addFirst(i);
        }
        System.out.println(">>> Usando ListIterator (NEXT)");
        ListIterator<Integer> lit = personas.listIterator(0);
        while(lit.hasNext()){
            //int n = lit.next();
            System.out.println(lit.next());
        }
        
        System.out.println(">>> Usando ListIterator (PREVIOUS)");
        lit = personas.listIterator(personas.size());
        while(lit.hasPrevious()){
            //int n = lit.previous();
            System.out.println(lit.previous());
        }
    }
}
