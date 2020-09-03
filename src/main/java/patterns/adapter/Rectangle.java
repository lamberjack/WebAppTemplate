package patterns.adapter;

public class Rectangle implements GeometricShape {
    private double base = 1.0;
    private double height = 1.0;

    @Override
    public double getPerimeter() {
        return base * 2 + height * 2;
    }

    @Override
    public double getArea() {
        return base * height;
    }

}
