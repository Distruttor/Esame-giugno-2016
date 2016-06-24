/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.esame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author mirko
 */
public class Main extends Application {

    public static final int N = 8;
    public static Griglia griglia = new Griglia();
    public static Bottoni bottoni = new Bottoni();
    public static int AUTO = 3;
    public static boolean aggiuntaAbilitata = false;
    
    @Override
    public void start(Stage primaryStage) {
        
        
        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(20));
        bp.setCenter(griglia);
        bp.setBottom(bottoni);
        
        Scene scene = new Scene(bp,600,600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String args[])
    {
        launch(args);
    }
    
}
