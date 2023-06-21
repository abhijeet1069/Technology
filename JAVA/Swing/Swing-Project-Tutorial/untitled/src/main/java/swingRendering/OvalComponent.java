package swingRendering;

import javax.swing.*;
import java.awt.*;

/**
 Basics of swing rendering:
    Events - How application threads interact with Swing and AWT events
    Painting - How system requests to update the display
    Rendering - Render components
    Double-Buffering - Using back buffer to ensure smooth updates to the screen
    Threading - Event mechanism

 Events:
    All events are put in a queue of events java.awt.EventQueue
    The dispatch mechanism of EventQueue is run on a single thread, called the Event Dispatch Thread(EDT)
 * */

public class OvalComponent extends JComponent {
    public void paintComponent(Graphics g){
        g.setColor(getBackground());
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.GRAY);
        g.fillOval(0,0,getWidth(),getHeight());
    }

    private static void createAndShowGUI(){
        JFrame f = new JFrame("Oval");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200,200);
        f.add(new OvalComponent());
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable doCreateAndShowGUI = new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }
}
