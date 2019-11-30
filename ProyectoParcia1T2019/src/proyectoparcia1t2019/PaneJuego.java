/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcia1t2019;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modelo.DoublyCircularLinkedList;
import modelo.Persona;

/**
 *
 * @author Grupo POO
 */
public class PaneJuego {

    private BorderPane areaJuego;
    private StackPane centro;
    private Pane parteInferior;

    public PaneJuego() {

        areaJuego = new BorderPane();
        centro = new StackPane();

        Image image = new Image("imagenes/fondo3.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(650);
        imageView.setFitWidth(650);

        Group root = new Group();
        Circle circulo = new Circle();
        Circle circulo2,circulo3;
        circulo.setCenterX(280.0f);
        circulo.setCenterY(280.0f);

        // Cambiamos el radio del circullo
        circulo.setRadius(150);
        // Fill color.
        //ellipse.setStroke(Color.BLACK);
        circulo2 = new Circle(280.0f+200,280.0f,20);
        circulo3 = new Circle(280.0f+200,240.0f,20);
        circulo.setFill(Color.WHITESMOKE);
        circulo2.setFill(Color.AQUAMARINE);
        circulo3.setFill(Color.BLUEVIOLET);
        System.out.println("angulo "+Math.atan2(circulo.getCenterY(),circulo.getCenterX()));
        
        cargarPersonas(circulo,root);
        //root.getChildren().addAll(circulo,circulo2,circulo3);
        centro.getChildren().addAll(imageView, root);
        
        areaJuego.setCenter(centro);
        

    }

    public void cargarPersonas(Circle c,Group root) {
        // Pedir el numero de personas o recuperarlo del slider
        // Asumiendo un valor fijo de personas
        double angulo, posX, posY;
        int n = 8;
        Circle circulo;
        Persona soldado;
        //DoublyCircularLinkedList<Persona> personas = new DoublyCircularLinkedList<>();
        angulo = 0;
        for(int i = n; i > 0; i--){
            angulo+=360/n;
            posX = c.getRadius() * Math.cos(Math.toRadians(angulo));
            posY = c.getRadius() * Math.sin(Math.toRadians(angulo));
            circulo = new Circle( posX, posY,15);
            circulo.setFill(Color.CHOCOLATE);        
            
            root.getChildren().addAll(circulo);
        }
    }
    
    // public void mostrarJUgadores(Ubicacion u, String tipo, StackPane st) {
    // }
    public BorderPane getRoot() {
        return areaJuego;

    }
}
