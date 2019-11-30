/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javafx.scene.shape.Circle;

/**
 *
 * @author Rodriguez-Ortega-Baquerizo
 */
/*
 * La clase Persona tiene un circulo que se dibujará 
 * en la posX y en la posY con ur radio específico.
 * Además, la variable espada cuando sea true me permitirá
 * conocer la posición en la que se encuentra esa persona y
 * la variable estado cuando sea true me indicará si la 
 * persona esta viva caso contrario ya ha sido eliminada.
*/
public class Persona {
    private Circle circulo; 
    private int posX, posY;
    private int indicePersona;
    private boolean espada;
    private boolean estado;
    private double radio;
    
    public Persona(){
        circulo.applyCss();
        circulo.getRadius();
     
    }
    
    public Persona(Circle circulo, int posX, int posY, int indicePersona, boolean espada) {
        this.circulo = circulo;
        this.circulo.applyCss();
        this.circulo.getRadius();
        this.posX = posX;
        this.posY = posY;
        this.indicePersona = indicePersona;
        this.espada = espada;
    }

    public void setCirculo(Circle circulo) {
        this.circulo = circulo;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setIndicePersona(int indicePersona) {
        this.indicePersona = indicePersona;
    }

    public void setEspada(boolean espada) {
        this.espada = espada;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Circle getCirculo() {
        return circulo;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getIndicePersona() {
        return indicePersona;
    }

    public boolean isEspada() {
        return espada;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public String toString() {
        return "Persona{" + "posX=" + posX + ", posY=" + posY + ", indicePersona=" + indicePersona + ", espada=" + espada + ", estado=" + estado + ", radio=" + radio + '}';
    }
    
    
}
