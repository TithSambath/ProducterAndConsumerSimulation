import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.GridLayout;

public class MyFrame extends JFrame{
    private final int PANEL_WIDTH = 1010;
    private final int PANEL_HEIGHT = 600;

    MyFrame(MyCanvas canvas){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setTitle("Producer & Consumer Simulation");
        this.add(canvas);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
