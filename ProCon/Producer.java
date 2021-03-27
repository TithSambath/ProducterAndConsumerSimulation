import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.lang.Thread;

public class Producer extends Thread{
    MyCanvas canvas;
    int turn = 0;
    int x = 450;
    int y = 350;
    int dynamicPos = 450;
    Producer(MyCanvas canvas){
        this.canvas = canvas;
        this.start();
    }

    public void produce() throws Exception{
        while (((canvas.resource.inQty + 1) % 10) == canvas.resource.outQty){Thread.sleep(60);}
        ;
        canvas.resource.put(canvas.resource.inQty, (new Ellipse2D.Double(x, y, 50, 50)));
        turn += 1;
        if (turn != 10){
            x -= 50;
        }else{
            x = 450;turn = 0;
        }
        System.out.println(canvas.resource.inQty);
        canvas.resource.NewValueIsSet = false;
        canvas.resource.inQty = (canvas.resource.inQty + 1) % 10;
        //while (!canvas.resource.IsConsuming);{Thread.sleep(100);}
        canvas.repaint();
        System.out.println("Produce : "+ canvas.resource.inQty);
    }

    @Override
    public void run(){
        while(true){
            try{
                produce();
                //animate();
                Thread.sleep(1500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void animate(){
        while (true){
            try{
                Thread.sleep(60);
                System.out.println("Start! : "+canvas.resource.inQty);
                if (canvas.resource.get(canvas.resource.inQty).getX() == dynamicPos){
                    x = 0;
                    dynamicPos -= 50;
                    break;
                }
                if (dynamicPos == 0){dynamicPos = 450;} // back to normal after reach 10 element
                canvas.resource.get(canvas.resource.inQty).setFrame(canvas.resource.get(canvas.resource.inQty).getX() + 50, y, 50,50);
                canvas.repaint();
                System.out.println("Being Animate...");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        canvas.resource.NewValueIsSet = false;
        System.out.println("End! : "+canvas.resource.inQty);
    }
}
