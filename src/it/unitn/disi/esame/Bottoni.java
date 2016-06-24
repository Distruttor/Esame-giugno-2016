/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.esame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author mirko
 */
public class Bottoni extends HBox{
   
    
    public Bottoni()
    {
         this.setSpacing(20);
         this.getChildren().addAll(new AutoDisponibili(),new Contatore(),new AggiungiAuto(), new Avvia());
    }
}



class AutoDisponibili extends Label
{
    public AutoDisponibili()
    {
        this.setText("Auto disponibili");
        this.setFont(Font.font("Verdana", FontWeight.LIGHT, 12));
    }
}

class Contatore extends TextField
{
    public Contatore()
    {
        this.setText("" + 3);
        this.setPrefWidth(50);
        this.setEditable(false);
    }
}

class AggiungiAuto extends Button
{
    public AggiungiAuto()
    {
        this.setText("Aggiungi auto");
        this.addEventHandler(ActionEvent.ACTION, abilitaAggiunta);
    }
    
    EventHandler<ActionEvent> abilitaAggiunta = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            Main.aggiuntaAbilitata = true;
        }
    };
}

class Avvia extends Button
{
    public Avvia()
    {
        this.setText("Avvia");
        this.setOnAction(avvia);
    }
    
    
    EventHandler<ActionEvent> avvia = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            new Secondaria();
        }
    };
}


