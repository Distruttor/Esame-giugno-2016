/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unitn.disi.esame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author mirko
 */
public class Prato extends Terreno {
    
    public Prato(int col, int rig)
    {
        super(col, rig);
        canAuto = false;
    }
    
    public  Rectangle creaTile(int l)
    {
        Rectangle cella = new Rectangle(l, l);
        cella.setStrokeWidth(1);
        cella.setStroke(Color.BLACK);
        cella.setFill(Color.GREEN);  
        return cella;
    }
}
