
public class Consumer extends Thread {
    MyCanvas canvas;
    int turn = 0;
    int dynamicPos = 950;
    int x = 0;
    int y = 350;

    Consumer(MyCanvas canvas) {
        this.canvas = canvas;
        this.start();
    }

    @Override
    public void run(){
        while (true) {
            try {
                //if (canvas.resource.NewValueIsSet){
                    Thread.sleep(60);
                    consume();
                    Thread.sleep(10);
                    animate();
                //}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void consume() throws Exception{
        while (canvas.resource.inQty == canvas.resource.outQty) {Thread.sleep(100);}
        ;
        canvas.resource.next_consume = canvas.resource.product[canvas.resource.outQty];
        // remove from main product
        canvas.resource.put(canvas.resource.outQty, null);
        System.out.println("Start Consume : "+canvas.resource.inQty);
        canvas.resource.outQty = (canvas.resource.outQty + 1) % 10;
        canvas.repaint();
    }
    public void animate(){
        while (true){
            try{
                Thread.sleep(30);
                canvas.resource.IsConsuming = true;
                if (canvas.resource.next_consume.getX() == dynamicPos){
                    break;
                }
                canvas.resource.next_consume.setFrame(canvas.resource.next_consume.getX() + 10, y, 50,50);
                canvas.repaint();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Finished Consume! : "+canvas.resource.inQty);
        canvas.resource.IsConsuming = false;
    }
}
