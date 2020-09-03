package patterns.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe client che lavora esclusivamente con oggetti di tipo {@link Shape}.
 *
 * @author lamberto.pauletti
 *
 */
public class ShapeCalculator {

    List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void areas() {
        shapes.stream().forEach(shape -> System.out.println(shape.getClass().getSimpleName() + " area: " + shape.area()));
    }

    public void perimeters() {
        shapes.stream().forEach(shape -> System.out.println(shape.getClass().getSimpleName() + " perimeter: " + shape.perimeter()));
    }
}
