/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.esame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author mirko
 */
public class Secondaria extends Stage{
    public Secondaria()
    {
        
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20));
        
        hbox.getChildren().addAll(new GrigliaDirezionale(),new RandomButton(),new Start(),new Stop());
        
        Scene scene = new Scene(hbox);
        this.setScene(scene);
        this.show();
    }
    
    
    
}


class GrigliaDirezionale extends GridPane
{
    public GrigliaDirezionale()
        {
            Button destra = new Button("Destra");
            destra.setPrefSize(80, 30);
            Button sinistra = new Button("Sinistra");
            sinistra.setPrefSize(80, 30);
            Button su = new Button("Su");
            su.setPrefSize(80, 30);
            Button giu = new Button("Giù");
            giu.setPrefSize(80, 30);


            this.add(su, 1, 0);
            this.add(giu, 1, 2);
            this.add(destra, 2, 1);
            this.add(sinistra, 0, 1);
            
            this.addEventHandler(ActionEvent.ACTION, muovi);
        }
    
    EventHandler<ActionEvent> muovi = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            for(int i = 0; i < Main.N * Main.N; i++)
            {
                Terreno terr = (Terreno) Main.griglia.getChildren().get(i);
                
              
                if(terr instanceof Strada)
                {
                    if(((Strada)terr).autoPresente == true)
                    {
                        Terreno nuovaPosizione = (Terreno) Main.griglia.getChildren().get(i - 1);
                        
                        terr.getChildren().remove(1);
                        ((Strada) terr).autoPresente = false;
                        
                        nuovaPosizione.getChildren().add(new Auto());
                        ((Strada) nuovaPosizione).autoPresente = true;
                        System.out.println(i);
                        
                    }
                }
            }
        }
    };
    
}

class RandomButton extends Button
{
    public RandomButton()
    {
        this.setText("Random");
    }
}


class Start extends Button
{
    public Start()
    {
        this.setText("Start");
    }
}

class Stop extends Button
{
    public Stop()
    {
        this.setText("Stop");
        this.setDisable(true);     
    }
}



