package patterns.decorator;

/**
 * Implementazione concreta di Application.
 *
 * @author lamberto.pauletti
 *
 */
public class ApplicationWeb implements Application {

    @Override
    public void doSomething() {
        System.out.println("Questa è la specializzazione ApplicationWEB");

    }

}
