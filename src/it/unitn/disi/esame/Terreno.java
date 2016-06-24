/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.esame;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author mirko
 */
public abstract class Terreno extends StackPane {
    public Color sfondo;
    public boolean canAuto;
    public int col;
    public int rig;
    
   
    public Terreno(int col, int rig)
    {
        this.col = col;
        this.rig = rig;
        getChildren().add(creaTile(50));
        addEventHandler(MouseEvent.MOUSE_CLICKED, cambia);
        addEventHandler(MouseEvent.MOUSE_CLICKED, aggiungiAuto);
    }
    
    public abstract Rectangle creaTile(int l);
    
    
 
    
       
    EventHandler<MouseEvent> cambia = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
           Terreno terr = (Terreno) t.getSource();          
           int colonna = GridPane.getColumnIndex(terr);
           int riga = GridPane.getRowIndex(terr);
           
           if(Main.aggiuntaAbilitata == false)
           {
                Main.griglia.getChildren().remove(terr);
                if(t.getSource() instanceof Prato)
                {      
                    terr = new Strada();          
//                    System.out.println("Prato");
                }
                else if(t.getSource() instanceof Strada && ((Strada)t.getSource()).autoPresente == false && terr.getChildren().size() == 1)
                {
                    terr = new Prato();
//                    System.out.println("Strada");
                }
                
                Main.griglia.add(terr, colonna, riga);
                
           }
        }
    };
    
    
    
    EventHandler<MouseEvent> aggiungiAuto = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent t) {
            
            
            if(! (t.getSource() instanceof Auto))
            {
                Terreno terr = (Terreno) t.getSource();
                int colonna = GridPane.getColumnIndex(terr);
                int riga = GridPane.getRowIndex(terr);
                if(Main.aggiuntaAbilitata == true && canAuto == true)
                {
                    
                    System.out.println("Aggiunta");
                    ((Strada)terr).autoPresente = true;
                    Main.aggiuntaAbilitata = false;
                    terr.getChildren().add(new Auto());
                    Main.AUTO--;
                    
                    ((Contatore)Main.bottoni.getChildren().get(1)).setText("" + Main.AUTO);
                    if(Main.AUTO == 0)
                    {
                        Main.bottoni.getChildren().get(2).setDisable(true);
                    }
                }
            }
        }
    };
}
