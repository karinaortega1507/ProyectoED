/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcia1t2019;

import javafx.scene.text.Font;
import java.util.ListIterator;
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
    private Group root = new Group();
    private Circle circulo = new Circle();
    public static DoublyCircularLinkedList<Persona> listaPersonas= new DoublyCircularLinkedList<Persona>();
    public static DoublyCircularLinkedList<Integer> listaP= new DoublyCircularLinkedList<Integer>();

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
        cajonOpciones = new VBox();
        Image image = new Image("imagenes/fondo3.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(650);
        imageView.setFitWidth(800);
        //centro en X y centro en Y
        circulo.setCenterX(280.0f);
        circulo.setCenterY(280.0f);
        // Cambiamos el radio del circullo
        circulo.setRadius(150);
        circulo.setFill(Color.WHITESMOKE);
        centro.getChildren().addAll(imageView, root);
        areaJuego.setCenter(centro);
        panelOpciones();
        botonSimulacion.setOnAction(e -> {
            try {
                String dir = elegirDireccion.getSelectionModel().getSelectedItem().toString();//Donde se encontraran contenidas la categorias de ingreso
                String indice = elegirIndice.getText();
                String numeroParticipantes = l.getText();
                System.out.println(dir + ", " + indice + ", " + numeroParticipantes);
                simular(Integer.parseInt(numeroParticipantes), Integer.parseInt(indice), dir);
            } catch (InterruptedException ex) {
                Logger.getLogger(PaneJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        botonStop.setOnAction(e -> {
            elegirIndice.setText(null);
            l.setText("8");
            elegirDireccion.getSelectionModel().select(0);
            sob.setText("      ");
        });

    }
     public void simular(int numPersonas, int personaInicia, String direccion) throws InterruptedException{
        
        cargarPersonas(circulo, root,numPersonas,personaInicia,direccion);
         System.out.println(listaPersonas.size());
         System.out.println(listaP.size());
         int cont = listaPersonas.size();
         try{
            ListIterator<Persona> iterator = listaPersonas.listIterator(personaInicia); 
            while (iterator.hasNext()) { 
                Persona p1 = iterator.next();
                HiloTenerEspada h = new HiloTenerEspada(p1);
                if(p1.getIndicePersona() == personaInicia){
                    new Thread(h).start();
                }
                ejecutarSoldado(p1,cont);
            } 
        } 
  
        catch (IndexOutOfBoundsException e) { 
            System.out.println("Exception thrown : " + e); 
        } 
        
    }

    private void ejecutarSoldado(Persona p1, int cont) {
        Persona vivo, espada;
        int indice = p1.getIndicePersona();
        ListIterator<Persona> iterator = listaPersonas.listIterator(indice); 
        while(iterator.hasNext()){
            vivo = iterator.next();
            HiloCambiarColorVivo h = new HiloCambiarColorVivo(p1);
            new Thread(h).start();
            if (vivo.isEstado()){
                HiloCambiarColorMuerto m = new HiloCambiarColorMuerto(vivo);
                new Thread(m).start();
                vivo.setEstado(false);
                if(p1.isEspada() && p1.isEstado())
                    new Thread(h).start();
                espada = iterator.next();
                HiloTenerEspada e = new HiloTenerEspada(espada);
                new Thread(e).start();
                p1 = iterator.next();
                cont--;
            }  
        }
        while(cont!=1){
            ListIterator<Persona> iterator2 = listaPersonas.listIterator(1); 
            while(iterator2.hasNext()){
                vivo = iterator2.next();
                HiloCambiarColorVivo h = new HiloCambiarColorVivo(p1);
                new Thread(h).start();
                if (vivo.isEstado()){
                    HiloCambiarColorMuerto m = new HiloCambiarColorMuerto(vivo);
                    new Thread(m).start();
                    vivo.setEstado(false);
                if(p1.isEspada() && p1.isEstado())
                    new Thread(h).start();
                    espada = iterator2.next();
                    HiloTenerEspada e = new HiloTenerEspada(espada);
                    new Thread(e).start();
                    p1 = iterator2.next();
                    cont--;
            }
        }
        
           
        }
                
         
    }
               
      class HiloCambiarColorMuerto implements Runnable {
        Persona c;
        public HiloCambiarColorMuerto(Persona c) {
            this.c = c;      
        }
        public  void run() {
            try {
                Thread.sleep(4000);
                Platform.runLater(()->{
                    c.getCirculo().setFill(Color.LIGHTGRAY);
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(PaneJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class HiloCambiarColorVivo implements Runnable {
        Persona c;
        public HiloCambiarColorVivo(Persona c) {
            this.c = c;      
        }
        public  void run() {
            try {
                Thread.sleep(3000);
                Platform.runLater(()->{
                    c.getCirculo().setFill(Color.VIOLET);
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
                Thread.sleep(3000);
                Platform.runLater(()->{                      
                    c.getCirculo().setFill(Color.YELLOW);
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(PaneJuego.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void cargarPersonas(Circle c, Group root,int numeroParticipantes,int personaInicia,String direccion) {
        
        // public Persona(Circle circulo, double posX, double posY, int indicePersona, boolean estado) {
        // Pedir el numero de personas o recuperarlo del slider
        // Asumiendo un valor fijo de personas
        double angulo, posX, posY;
        int n = numeroParticipantes;
        double distancia=360/n;
        angulo=0;
        Circle circulo;
        Persona soldado;
        
        while( n > 0 ){
            System.out.println(n);
            posX = c.getRadius() * Math.cos(Math.toRadians(angulo));
            posY = c.getRadius() * Math.sin(Math.toRadians(angulo));
            circulo = new Circle(posX,posY,20);
            circulo.setFill(Color.VIOLET);
            
            
            soldado = new Persona(circulo, posX, posY,n, true);
            
            listaPersonas.addFirst(soldado);
            
            Label numero= new Label(String.valueOf(n));
            numero.setFont(new Font("Arial",14));
            numero.relocate(posX,posY);
            //StackPane ls= new StackPane(numero,circulo);
            //ls.relocate(posX, posY);
            
            
            
            root.getChildren().addAll(circulo,numero);
             n--;
             angulo+=distancia;
        }
}

    public BorderPane getRoot() {
        return areaJuego;

    }

    public void panelOpciones() {

        //-------------------------------------------------------------------------
        //CREANDO OPCIONES: TODAS LAS OPCIONES ESTÁN EN UN VBOX
        //1)NUMERO DE GUERREROS EN LA SIMULACIÓN/SLIDE
        Guerreros = new Slider(8, 30, 8); //Creo el Slider
        Guerreros.setShowTickMarks(false);
        Guerreros.setShowTickLabels(true);//No se muestran los milimetros y se muestran las etiquetas de numeros enteros
        Guerreros.setMajorTickUnit(1);
        Guerreros.setBlockIncrement(1);//Se establece las etiquetas de cuanto en cuanto serán visibles y el incremento que va a tener por cada salto en teclado
        Label GuerreroLabel = new Label("Escoja el número de soldados para hacer la simulación");

        HBox h = new HBox();
        Label l2 = new Label("Valor Elegido: ");
        l = new Label("");//Establecida para mostrar los numeros cambiantes en pantalla
        //Método para mostrar en pantalla el número
        Guerreros.valueProperty().addListener(
                new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                String num = String.valueOf(newValue.intValue());
                l.setText(num); //selecciona solo números enteros
            }
        });

        //2)ORIENTACIÓN DE LA SIMULACIÓN/COMBOBOX
        ObservableList<String> direccion = FXCollections.observableArrayList();
        direccion.addAll("Derecha", "Izquierda");
        Label direccionLabel = new Label("Escoja la orientación del juego para hacer la simulación");
        elegirDireccion = new ComboBox<>(direccion);//Se elegirá el índice que comienza a eliminar
        //cajonOpciones.getChildren().add(elegirDireccion);
        elegirDireccion.getSelectionModel().select(0);

        //3) Elegir quien inicia la matanza/TEXTFIELD
        elegirIndice = new TextField();
        Label indiceLabel = new Label("Ingrese un número, representará el soldado que comenzará la simulación");
        elegirIndice.setMinWidth(50);
        elegirIndice.setMaxWidth(50);

        //4)Botón Simulación/BUTTON
        botonSimulacion = new Button("Comenzar Simulación");
        botonStop = new Button("Jugar De Nuevo");

        h.getChildren().addAll(l2, l);

        Label sobText = new Label("Jugador Sobreviviente:      ");
        sob = new Button("        ");
        	Circle c1= new Circle(15);   
        Circle c2=new Circle(15);
        Circle c3= new Circle(15);
        Circle c4= new Circle(15);
        
         c1.setFill(Color.VIOLET);
         c2.setFill(Color.LIGHTGRAY);
         c3.setFill(Color.YELLOW);
         
         
         
        Label ll1= new Label("Vivo");
        Label ll2= new Label ("Muerto");
        Label ll3= new Label("Con Espada");
        
        ll1.setFont(new Font("Arial",18));
        ll2.setFont(new Font("Arial",18));
        ll3.setFont(new Font("Arial",18));
        
        
        StackPane n1= new StackPane(c1,ll1);
        StackPane n2=new StackPane(c2,ll2);
        StackPane n3= new StackPane(c3,ll3);
        
        //PONIENDO EN EL VBOX LAS OPCIONES 
        cajonOpciones.setPadding(new Insets(20)); //Separa el VBox del borde de la ventana 20 pixeles
        cajonOpciones.setSpacing(10); //Espacio entre cada VBox
        cajonOpciones.getChildren().addAll(GuerreroLabel, Guerreros, h, direccionLabel, elegirDireccion, indiceLabel, elegirIndice, botonSimulacion, sobText, sob, botonStop,n1,n2,n3);
        
        //------------------------------------------------------------------------------------
        //Comenzamos a poner en el root los elementos de la simulación
        areaJuego.setRight(cajonOpciones);
    }

}
