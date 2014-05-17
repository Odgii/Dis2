/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

/**
 *
 * @author DolceVita
 */
public class WindowsManager extends WindowSystem {

    public WindowsManager(int width, int height) {
        super(width, height);
    }

    @Override
    protected void handlePaint() {
        super.handlePaint();
    }
    public void minimizeWindow(SimpleWindow s)
    {
         int size = listOfMinimizedWindows.size()/2;
         listOfMinimizedWindows.add(0,s); 
         SimpleWindow minS = new SimpleWindow(); 
         minS.beginX =10;
         minS.beginY=size*70+size*20+10;
         minS.width =60;
         minS.height=70;
         minS.title=s.title;
         listOfMinimizedWindows.add(0,minS);   
         listOfWindows.remove(s);
    }
      
    
    @Override
    public void handleMousePressed(int x, int y) {
        super.handleMousePressed(x, y);
        
        if ( currentActiveWindow != null && listOfWindows.contains(currentActiveWindow)) {
            System.out.println("current:" + currentActiveWindow.title);
            if ((currentActiveWindow.width - 30 <= x && x <= currentActiveWindow.width) && (currentActiveWindow.beginY + 25 <= y && y <= currentActiveWindow.beginY + 55)) {
                listOfWindows.remove(0);
                requestRepaint();
            }
            else if ((currentActiveWindow.width - 67 <= x && x <= currentActiveWindow.width-37) && (currentActiveWindow.beginY + 25 <= y && y <= currentActiveWindow.beginY + 55)) {
                minimizeWindow(currentActiveWindow);       
                requestRepaint();                  
            }
            else if((currentActiveWindow.beginX <= x && x <= currentActiveWindow.width-60) && (currentActiveWindow.beginY + 25 <= y && y <= currentActiveWindow.beginY + 55)) {
                requestRepaint();
            }
        }
        else if(!listOfWindows.contains(currentActiveWindow)){
            requestRepaint();
        }
    }
    
    @Override
    public void handleMouseDragged(int x, int y) {
        if (currentActiveWindow != null && listOfWindows.contains(currentActiveWindow)) {
            SimpleWindow s = new SimpleWindow();
            s.beginX = x;
            s.beginY = y;
            s.width = x + (currentActiveWindow.width - currentActiveWindow.beginX);
            s.height = y + (currentActiveWindow.height - currentActiveWindow.beginY);
            s.title = currentActiveWindow.title;
            if(listOfWindows.contains(currentActiveWindow))
            {
                listOfWindows.remove(currentActiveWindow);
            }            
            listOfWindows.add(0,s); 
            currentActiveWindow = s;
            requestRepaint();
         }    
    }
    
}
