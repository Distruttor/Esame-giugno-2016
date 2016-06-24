/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.esame;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author mirko
 */
public class Griglia extends GridPane{
    public Griglia()
    {
        
        
        Terreno terr;
        for(int colonna = 0; colonna < Main.N; colonna++)
        {
            for(int riga = 0; riga < Main.N; riga++)
            {
                if(riga == 0 || riga == Main.N - 1 || colonna == 0 || colonna == Main.N - 1)
                    terr = new Strada(colonna,riga);
                else
                    terr = new Prato(colonna,riga);
                
                this.add(terr, colonna, riga);
            }
        }
        
    //        this.addEventHandler(MouseEvent.MOUSE_CLICKED, cambia);
        
        
        
    }
    
//    
//    EventHandler<MouseEvent> cambia = new EventHandler<MouseEvent>() {
//        @Override
//        public void handle(MouseEvent t) {
//           Terreno terr = (Terreno) t.getSource();
//           int colonna = GridPane.getColumnIndex(terr);
//           int riga = GridPane.getRowIndex(terr);
//           
//           
//           if(t.getSource() instanceof Prato)
//           {
//               System.out.println("Colonna " + colonna + "riga " + riga);
//               terr = new Strada();
//               
//               System.out.println("Prato");
//           }
//           else
//           {
//               terr = new Prato();
//               System.out.println("Strada");
//           }
//        }
//    };
}
