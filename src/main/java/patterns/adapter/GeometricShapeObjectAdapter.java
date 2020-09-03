package patterns.adapter;

/**
 * Classe adapter. Implementa l'interfaccia {@link Shape} (target) e contiene al
 * suo interno un istanza dell' interfaccia {@link GeometricShape} (adaptee)
 *
 * @author lamberto.pauletti
 *
 */
public class GeometricShapeObjectAdapter implements Shape {

    // istanza della classe da adattare
    private GeometricShape adaptee;

    public GeometricShapeObjectAdapter(GeometricShape adaptee) {
        this.adaptee = adaptee;
    }

    // vengono riesposti i metodi dell'interfaccia target
    @Override
    public double perimeter() {
        return adaptee.getPerimeter();
    }

    @Override
    public double area() {
        return adaptee.getArea();
    }
}
