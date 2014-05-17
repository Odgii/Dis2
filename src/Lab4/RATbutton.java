/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab4;

import java.awt.Color;

/**
 *
 * @author DolceVita
 */
public class RATbutton extends RATlabel implements RATmouseListener {
    

    private Color clickedColor;

    
    

    @Override
    public void mouseClicked() {
        System.out.println("fuck u");//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the clickedColor
     */
    public Color getClickedColor() {
        return clickedColor;
    }

    /**
     * @param clickedColor the clickedColor to set
     */
    public void setClickedColor(Color clickedColor) {
        this.clickedColor = clickedColor;
    }

    
}
