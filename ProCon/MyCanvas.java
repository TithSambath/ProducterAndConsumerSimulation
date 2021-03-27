import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyCanvas extends JPanel {

    public Resource resource;

    MyCanvas(Resource resource) {
        this.setBackground(Color.decode("#CACCCE"));
        this.resource = resource;
        JLabel proLabel= new JLabel("Producer");
        proLabel.setSize(100,100);
        proLabel.setLocation(200,150);
        this.setLayout(null);
        this.add(proLabel);
        JLabel conLabel = new JLabel("Consumer");
        conLabel.setSize(100,100);
        conLabel.setLocation(700,150);
        this.setLayout(null);
        this.add(conLabel);
        // Describtion
        JLabel des = new JLabel("The one that is consume will be color as white.");
        des.setSize(400,200);
        des.setLocation(300,350);
        this.setLayout(null);
        this.add(des);

        JLabel remind = new JLabel("The first start might be fast so that why we seen white ball first.");
        remind.setSize(500,200);
        remind.setLocation(250,400);
        this.setLayout(null);
        this.add(remind);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.decode("#1DB954"));
        g2d.fill(resource.ProducerBox);

        g2d.setColor(Color.decode("#000000"));
        g2d.fill(resource.ConsumerBox);

        g2d.setColor(Color.decode("#000000"));
        for (int i = 0; i < resource.product.length; i++) {
            if (resource.product[i] != null)
                g2d.fill(resource.product[i]);
        }

        if (resource.next_consume != null) {
            g2d.setColor(Color.decode("#FFFFFF"));
            g2d.fill(resource.next_consume);
        }

    }
}
