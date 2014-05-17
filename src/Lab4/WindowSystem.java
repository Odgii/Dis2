/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab4;

/**
 *
 * @author DolceVita
 */
import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author DolceVita
 */
public class WindowSystem extends GraphicsEventSystem {

    ArrayList<SimpleWindow> listOfWindows = new ArrayList<>();
    ArrayList<SimpleWindow> listOfMinimizedWindows = new ArrayList<>();
    private final double width, height;
    private double originX, originY, destinationX, destinationY;
    SimpleWindow currentActiveWindow;
    int currentIndex;

    public WindowSystem(int width, int height) {
        super(width, height);
        this.width = (double) width;
        this.height = (double) height;
    }

    @Override
    protected void handlePaint() {
        int b = listOfWindows.size();
        for (int i = 1; i <= b; b--) {            
            SimpleWindow simple = listOfWindows.get(b - 1);
            createBorder(simple);
            setColor(Color.lightGray);
            fillRect(simple.beginX, simple.beginY, simple.width, simple.height);
            if (simple.equals(currentActiveWindow) || b == 1) {
                showTitleBar(simple, Color.PINK);
            } else {
                showTitleBar(simple, Color.GRAY);
            }
            drawString(simple.title, simple.beginX + 20, simple.beginY + 20);
        }
        int minb = listOfMinimizedWindows.size();
        for (int j = 0; j < minb; j++) {
            System.out.println("list:"+minb);
            if (j % 2 == 0) {
                setColor(Color.lightGray);
                SimpleWindow minSimple = listOfMinimizedWindows.get(j);
                System.out.println("x:" + minSimple.beginX + " y:"+ minSimple.beginY+" width:"+ minSimple.width + " height:"+ minSimple.height);
                fillRect(minSimple.beginX, minSimple.beginY, minSimple.width, minSimple.height);
                setColor(Color.black);
                drawString(minSimple.title, minSimple.beginX, minSimple.height+10);
            }
            // j++;
        }
    }

    public void showTitleBar(SimpleWindow s, Color c) {
        setColor(c);
        fillRect(s.beginX, s.beginY, s.width, s.beginY + 30);
        setColor(Color.RED);
        fillRect(s.width - 30, s.beginY, s.width, s.beginY + 30);
        setColor(Color.YELLOW);
        fillRect(s.width - 60, s.beginY, s.width - 30, s.beginY + 30);
        setColor(Color.BLACK);
        drawString("X", s.width - 20, s.beginY + 20);
        drawString("__", s.width - 52, s.beginY + 20);
    }

    public void createBorder(SimpleWindow s) {
        setColor(Color.DARK_GRAY);
        drawRect(s.beginX - 1, s.beginY - 1, s.width, s.height);
    }

    public SimpleWindow createNewWindows(double originXt, double originYt, double destinationXt, double destinationYt, String originTitle) {
        convertToAbstractCoordinateSystem(originXt, originYt, destinationXt, destinationYt);
        SimpleWindow s = new SimpleWindow();
        s.beginX = this.originX;
        s.beginY = this.originY;
        s.width = this.destinationX + this.originX;
        s.height = this.destinationY + this.originY;
        s.title = originTitle;
        listOfWindows.add(0, s);
        return s;
    }

    public SimpleWindow findClickedWindow(int x, int y) {
        for (int i = 0; i < listOfWindows.size(); i++) {
            SimpleWindow s = listOfWindows.get(i);
            if ((s.beginX <= x && x <= s.width) && (s.beginY <= y && y <= s.height)) {
                listOfWindows.remove(s);
                listOfWindows.add(0, s);
                return s;
            }
        }
        for (int j = 0; j < listOfMinimizedWindows.size(); j++) {
            SimpleWindow mins = listOfMinimizedWindows.get(j);
                if ((j % 2 == 0)&&(mins.beginX <= x && x <= mins.width) && (mins.beginY <= y && y <= mins.height)) {
                    listOfWindows.add(0,listOfMinimizedWindows.get(j+1));
                    listOfMinimizedWindows.remove(j);
                     listOfMinimizedWindows.remove(j);
                    return mins;
                }
        }
        return null;
    }

    void convertToAbstractCoordinateSystem(double originXd, double originYd, double destinationXd, double destinationYd) {
        if (0 <= originXd && originXd <= 1 && originYd >= 0 && originYd <= 1 && destinationXd >= 0 && destinationXd <= 1 && destinationYd >= 0 && destinationYd <= 1) {
            this.originX = originXd * this.width;
            this.originY = originYd * this.height;
            this.destinationX = destinationXd * this.width;
            this.destinationY = destinationYd * this.height;
        }
    }

    @Override
    public void handleMousePressed(int x, int y) {
        currentActiveWindow = findClickedWindow(x, y);
    }

}
