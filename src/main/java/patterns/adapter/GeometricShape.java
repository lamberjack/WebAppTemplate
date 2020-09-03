package patterns.adapter;

/**
 * Interfaccia da adattare (adaptee) e da rendere compatibile con {@link Shape}
 * (target). I metodi al suo interno hanno la stessa funzionalità di quelli di
 * {@link Shape}.
 *
 * @author lamberto.pauletti
 *
 */
public interface GeometricShape {

    public double getPerimeter();

    public double getArea();

}
