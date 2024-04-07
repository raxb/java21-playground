package abt.sealed;

public abstract sealed class Shape permits Circle, Rectangle, Square, Rhombus {
    public abstract void draw();
}
