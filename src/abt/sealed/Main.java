package abt.sealed;

public class Main {
    public static void main(String[] args) {

        Shape shape = new SemiCircle();
        shape.draw();

        Shape shape2 = new SemiCircleImpl();
        shape2.draw();

        Shape shape3 = new TwoDRhombus();
        shape3.draw();

        if(shape instanceof Rectangle r){
            /* https://openjdk.org/jeps/394 */
            r.draw();
        }

    }
}