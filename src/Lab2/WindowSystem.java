/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Color;
import java.util.Hashtable;
/**
 *
 * @author DolceVita
 */
public class WindowSystem extends GraphicsEventSystem{
    
 //   Hashtable<State, SimpleWindow> trackOfWindows = new Hashtable<State,SimpleWindow>(); -- To keep track of SimpleWindows file

    private final double width, height;
    private double originX, originY, destinationX, destinationY;
    private double originXt, originYt, destinationXt, destinationYt;
    
    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = (double)width;
        this.height =(double)height;      
    }
	
    @Override
    protected void handlePaint() {
        setColor(Color.BLACK);
        convertToAbstractCoordinateSystem(0.2, 0.3, 0.8, 0.7);
        drawLine((int)originXt, (int)originYt,(int) destinationXt, (int)destinationYt);
    }
    
    void convertToAbstractCoordinateSystem(double originX, double originY, double destinationX, double destinationY)
    {       
        if(0<=originX && originX<=1 && originY>=0 && originY<=1 &&destinationX>=0 && destinationX<=1 &&destinationY>=0 && destinationY<=1)
        {
            this.originXt = originX * this.width;
            this.originYt = originY * this.height;
            this.destinationXt = destinationX * this.width;
            this.destinationYt = destinationY * this.height;
        }    
    }

}
