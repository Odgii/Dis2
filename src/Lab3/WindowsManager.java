/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab3;

import java.awt.Color;

/**
 *
 * @author DolceVita
 */
public class WindowsManager extends WindowSystem{
    

    public WindowsManager(int width, int height) {
        super(width, height);
    }

    @Override
    protected void handlePaint() {
        super.handlePaint();
        addAll();
        
    }
    public void addAll(){
        int b = listOfWindows.size(); 
        for (int i = 1; i <= b  ; b--) {
            SimpleWindow simple = listOfWindows.get(b-1);  
            createBorder(simple);        
            if(b==1){
                showTitleBar(simple, Color.PINK);
                
            } else {
                showTitleBar(simple,Color.GRAY);           
            }
            drawString(simple.title, simple.beginX+20, simple.beginY+20);
       
            

                  
          
        }
    }    
    public void showTitleBar(SimpleWindow s, Color c)
    {
        setColor(c);
        fillRect(s.beginX, s.beginY, s.width, s.beginY+30);
        setColor(Color.RED);
        fillRect(s.width-30, s.beginY, s.width, s.beginY+30);        
        setColor(Color.BLACK);
        drawString("X", s.width-20, s.beginY+20);
    }
    
    public void createBorder(SimpleWindow s)
    {
        setColor(Color.DARK_GRAY);
        drawRect(s.beginX, s.beginY, s.width, s.height);
        setColor(Color.GREEN);
        
    }
      
    
    @Override
    public void handleMousePressed(int x, int y) {
        super.handleMousePressed(x, y);
        if (currentActiveWindow != null) {
            if ((currentActiveWindow.width - 30 <= x && x <= currentActiveWindow.width) && (currentActiveWindow.beginY + 25 <= y && y <= currentActiveWindow.beginY + 55)) {
                listOfWindows.remove(currentActiveWindow);
                requestRepaint();
            }
            else
            {
                requestRepaint();
            }
        }
    }
    
    @Override
    public void handleMouseDragged(int x, int y) {
        if (currentActiveWindow != null) {
            findClickedWindow(x, y);
            SimpleWindow s = new SimpleWindow();
            s.beginX = x;
            s.beginY = y;
            s.width = x + (currentActiveWindow.width - currentActiveWindow.beginX);
            s.height = y + (currentActiveWindow.height - currentActiveWindow.beginY);
            s.title = currentActiveWindow.title;
            if(listOfWindows.size()>currentIndex)
            {
                listOfWindows.remove(currentActiveWindow);
            }            
            listOfWindows.add(0,s); 
            currentActiveWindow = s;
            requestRepaint();
         }
        
    }
 
}
