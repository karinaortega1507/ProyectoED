/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcia1t2019;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.beans.value.ChangeListener; 
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import modelo.DoublyCircularLinkedList;
import modelo.Persona;
import javafx.scene.control.Button;
/**
 *
 * @author Grupo POO
 */
public class PaneJuego {

    private BorderPane areaJuego;
    private StackPane centro;
    private Pane parteInferior;
    private VBox cajonOpciones;
    private HBox ordenarBotones;
    
    
    //Opciones menu
    public Slider Guerreros;
    public ComboBox<String> elegirDireccion;
    public TextField elegirIndice;
    public Label l;
    Button botonSimulacion;
    Button botonStop;
    Button sob;  //Caja para saber el jugador Sobreviviente
    
    
    
    public PaneJuego() {

        areaJuego = new BorderPane();
        centro = new StackPane();
        cajonOpciones=new VBox();
        Image image = new Image("imagenes/fondo3.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(650);
        imageView.setFitWidth(800);
 

        Group root = new Group();
        Circle circulo = new Circle();
        Circle circulo2,circulo3;
        circulo.setCenterX(280.0f);
        circulo.setCenterY(280.0f);

        // Cambiamos el radio del circullo
        circulo.setRadius(150);
        circulo.setFill(Color.WHITESMOKE);
        System.out.println("angulo "+Math.atan2(circulo.getCenterY(),circulo.getCenterX()));
       
        cargarPersonas(circulo,root);
        centro.getChildren().addAll(imageView, root);
       
        areaJuego.setCenter(centro);
        panelOpciones();
        
        
        
        
        
        
        botonSimulacion.setOnAction(e->{
            String dir= elegirDireccion.getSelectionModel().getSelectedItem().toString();//Donde se encontraran contenidas la categorias de ingreso
            String indice =elegirIndice.getText();
            String numeroParticipantes= l.getText();
            
            System.out.println(dir+", "+indice+", "+numeroParticipantes);
        });
        botonStop.setOnAction(e->{
            
            elegirIndice.setText(null);
            l.setText("1");
             elegirDireccion.getSelectionModel().select(0);
             sob.setText("      ");
        });
        
    }
    public void cargarPersonas(Circle c,Group root) {
        // Pedir el numero de personas o recuperarlo del slider
        // Asumiendo un valor fijo de personas
        double angulo, posX, posY;
        int n = 10;
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
    public void panelOpciones(){
        
                //-------------------------------------------------------------------------
        //CREANDO OPCIONES: TODAS LAS OPCIONES ESTÁN EN UN VBOX
        //1)NUMERO DE GUERREROS EN LA SIMULACIÓN/SLIDE
        Guerreros = new Slider(8, 30, 8); //Creo el Slider
        Guerreros.setShowTickMarks(false); Guerreros.setShowTickLabels(true);//No se muestran los milimetros y se muestran las etiquetas de numeros enteros
        Guerreros.setMajorTickUnit(1); Guerreros.setBlockIncrement(1);//Se establece las etiquetas de cuanto en cuanto serán visibles y el incremento que va a tener por cada salto en teclado
        Label GuerreroLabel=new Label("Escoja el número de soldados para hacer la simulación"); 
       
        HBox h= new HBox();
        Label l2=new Label("Valor Elegido: ");
        l=new Label("");//Establecida para mostrar los numeros cambiantes en pantalla
        //Método para mostrar en pantalla el número
        Guerreros.valueProperty().addListener( 
            new ChangeListener<Number>() { 
            public void changed(ObservableValue <? extends Number >  
                      observable, Number oldValue, Number newValue) 
            { 
                String num= String.valueOf(newValue.intValue());
                l.setText(num); //selecciona solo números enteros
            } 
        }); 
        
        //2)ORIENTACIÓN DE LA SIMULACIÓN/COMBOBOX
        ObservableList<String> direccion = FXCollections.observableArrayList();
        direccion.addAll("Derecha", "Izquierda");
        Label direccionLabel=new Label("Escoja la orientación del juego para hacer la simulación"); 
        elegirDireccion = new ComboBox<>(direccion);//Se elegirá el índice que comienza a eliminar
        //cajonOpciones.getChildren().add(elegirDireccion);
        elegirDireccion.getSelectionModel().select(0);

        
        
        
       //3) Elegir quien inicia la matanza/TEXTFIELD
       elegirIndice=new TextField();
       Label indiceLabel=new Label("Ingrese un número, representará el soldado que comenzará la simulación"); 
       elegirIndice.setMinWidth(50);
       elegirIndice.setMaxWidth(50);
       
       //4)Botón Simulación/BUTTON
        botonSimulacion=new Button("Comenzar Simulación");
        botonStop=new Button("Jugar De Nuevo");
        
        h.getChildren().addAll(l2,l);
        
        Label sobText= new Label("Jugador Sobreviviente:      ");
        sob= new Button("        ");
        
        //PONIENDO EN EL VBOX LAS OPCIONES 
        cajonOpciones.setPadding(new Insets(20)); //Separa el VBox del borde de la ventana 20 pixeles
        cajonOpciones.setSpacing(10); //Espacio entre cada VBox
        cajonOpciones.getChildren().addAll(GuerreroLabel, Guerreros, h,direccionLabel,elegirDireccion,indiceLabel,elegirIndice,botonSimulacion,sobText,sob,botonStop);
        //------------------------------------------------------------------------------------
        //Comenzamos a poner en el root los elementos de la simulación
        areaJuego.setRight(cajonOpciones);
    }
   
    
    
     
    
    
    
    
      
      
      
      
      
    class HiloCambiarColor implements Runnable {
        Persona c;
       

        public HiloCambiarColor(Persona c) {
            this.c = c;
         
        }

        public void run() {

            try {
                
                Thread.sleep(1000);
                Platform.runLater(()->{
                    c.getCirculo().setFill(Color.BLACK);
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(PaneJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    class HiloTenerEspada implements Runnable {
        Persona c;
       

        public HiloTenerEspada(Persona c) {
            this.c = c;
         
        }

        public void run() {

            try {
                
                Thread.sleep(1000);
                Platform.runLater(()->{
                    
                    
                    
                    //////////Colocar la espada en el jugador
                    
                  ////  c.getCirculo().setFill(Color.BLACK);
                });

            } catch (InterruptedException ex) {
                Logger.getLogger(PaneJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
    
          
        
    
