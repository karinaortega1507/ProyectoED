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


/**
 *
 * @author Grupo POO
 */
public class PaneJuego {
    private BorderPane areaJuego;
    private StackPane centro;
    private Pane parteInferior;

    public PaneJuego() {
    
        areaJuego= new BorderPane();
        centro= new StackPane();
        
        Image image = new Image("imagenes/fondo3.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(650);
        imageView.setFitWidth(650);
        
 
       Group root = new Group();
       Circle circulo= new Circle();
       
       circulo.setCenterX(280.0f);
       circulo.setCenterY(280.0f);
 
       // Cambiamos el radio del circullo
       
        circulo.setRadius(200);
       // Fill color.
       //ellipse.setStroke(Color.BLACK);
       
       circulo.setFill(Color.WHITESMOKE);
 
       root.getChildren().add(circulo);
       
      
        centro.getChildren().addAll(imageView,root);      
        
        areaJuego.setCenter(centro);
       

    }

    public void cargarJugadores() {
//      
    }
    
  // public void mostrarJUgadores(Ubicacion u, String tipo, StackPane st) {
        

   // }
     public BorderPane getRoot() {
        return areaJuego;

    }
     
}