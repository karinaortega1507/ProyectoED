/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcia1t2019;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author windows
 */
public class ProyectoParcia1T2019 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        PaneJuego pane=new PaneJuego();
        
        
        Scene scene = new Scene(pane.getRoot(), 600, 650);
        primaryStage.setTitle("Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
