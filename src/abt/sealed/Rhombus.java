package abt.sealed;

public abstract sealed class Rhombus extends Shape permits TwoDRhombus {
    @Override
    public void draw() {
        System.out.println("from abt.sealed.Rhombus");
    }

    public abstract void twoDDraw();
}
