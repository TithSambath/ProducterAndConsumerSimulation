

/**
 * Author: Dyly Tithsambath
 */
public class Main {
    public static void main(String arg[]){
        Resource resource = new Resource();
        MyCanvas canvas = new MyCanvas(resource);
        new Producer(canvas);
        new Consumer(canvas);
        new MyFrame(canvas);
    }
}