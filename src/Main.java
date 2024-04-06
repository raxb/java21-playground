public class Main {
    public static void main(String[] args) {

        Shape shape = new SemiCircle();
        shape.draw();

        Shape shape2 = new SemiCircleImpl();
        shape2.draw();

        Shape shape3 = new TwoDRhombus();
        shape3.draw();

    }
}