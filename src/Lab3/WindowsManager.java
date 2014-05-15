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
public class WindowsManager extends WindowSystem {

    public WindowsManager(int width, int height) {
        super(width, height);
    }

    @Override
    protected void handlePaint() {
        super.handlePaint();
    }

    @Override
    public void handleMousePressed(int x, int y) {
        super.handleMousePressed(x, y);
        if (currentActiveWindow != null) {
            if ((currentActiveWindow.width - 30 <= x && x <= currentActiveWindow.width) && (currentActiveWindow.beginY + 25 <= y && y <= currentActiveWindow.beginY + 55)) {
                listOfWindows.remove(currentActiveWindow);
                requestRepaint();
            } else {
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
            if (listOfWindows.size() > currentIndex) {
                listOfWindows.remove(currentActiveWindow);
            }
            listOfWindows.add(0, s);
            currentActiveWindow = s;
            requestRepaint();
        }

    }

}
