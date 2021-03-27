import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;

public class Resource{
    public Ellipse2D product [] = new Ellipse2D[10];
    public Ellipse2D next_consume;
    public Rectangle ProducerBox;
    public Rectangle ConsumerBox;
    public int inQty = 0;
    public int outQty = 0;
    public boolean NewValueIsSet = true;
    public boolean IsConsuming = false;
    Resource(){
        createProducerBox();
        createConsumerBox();
    }
    public void put(int idx, Ellipse2D ellipse2d) throws InterruptedException {
        // while(valueSet){
        //     wait();
        // }
        this.product[idx] = ellipse2d;
        // valueSet = true;
        // notify();
    }
    public Ellipse2D get(int idx){
        // while(!valueSet){
        //     wait();
        // }
        return product[idx];
        // valueSet = true;
        // notify();
    }

    public void createProducerBox(){
        ProducerBox = new Rectangle(0, 350, 500, 50);
    }
    public void createConsumerBox() {
         ConsumerBox = new Rectangle(500, 350, 500, 50);
    }
}