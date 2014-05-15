/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import de.rwth.hci.Graphics.GraphicsEventSystem;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author DolceVita
 */
public class WindowSystem extends GraphicsEventSystem {

    ArrayList<SimpleWindow> listOfWindows = new ArrayList<>();
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
    }

    public void showTitleBar(SimpleWindow s, Color c) {
        setColor(c);
        fillRect(s.beginX, s.beginY, s.width, s.beginY + 30);
        setColor(Color.RED);
        fillRect(s.width - 30, s.beginY, s.width, s.beginY + 30);
        setColor(Color.BLACK);
        drawString("X", s.width - 20, s.beginY + 20);
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
                currentIndex = i;
                listOfWindows.remove(s);
                listOfWindows.add(0, s);
                return s;
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
