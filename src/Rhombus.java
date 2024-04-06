public abstract sealed class Rhombus extends Shape permits TwoDRhombus {
    @Override
    public void draw() {
        System.out.println("from Rhombus");
    }

    public abstract void twoDDraw();
}
