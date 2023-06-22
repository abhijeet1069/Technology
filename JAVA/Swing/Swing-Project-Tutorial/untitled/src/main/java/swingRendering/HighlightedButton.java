package swingRendering;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class HighlightedButton extends JButton {
    static final int HIGHLIGHT_SIZE = 18;
    BufferedImage highlight = new BufferedImage(HIGHLIGHT_SIZE,HIGHLIGHT_SIZE,BufferedImage.TYPE_INT_ARGB);

    public HighlightedButton(String label){
        super(label);
        Graphics2D g2d = highlight.createGraphics();
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0,0,HIGHLIGHT_SIZE,HIGHLIGHT_SIZE);
        g2d.setComposite(AlphaComposite.SrcOver);

        Point2D center = new Point2D.Float((float)HIGHLIGHT_SIZE/2.0f, (float)HIGHLIGHT_SIZE/2.0f);
        float radius = (float)HIGHLIGHT_SIZE/2.0f;
        float[] dist = {0.0f,0.85f};
        Color[] colors = {Color.white, new Color(255,255,0,0)};
        RadialGradientPaint paint = new RadialGradientPaint(center,radius,dist,colors);
        g2d.setPaint(paint);
        g2d.fillOval(0,0,HIGHLIGHT_SIZE,HIGHLIGHT_SIZE);
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(highlight,getWidth()/4,getHeight()/4,null); //superimpose highlight on JButton
    }

    private static void createAndShowGUI(){
        JFrame f = new JFrame();
        f.getContentPane().setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200,200);
        f.add(new JButton("Standard"));
        f.add(new HighlightedButton("Highlighted"));
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
