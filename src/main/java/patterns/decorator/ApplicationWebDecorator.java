package patterns.decorator;

/**
 *
 * Implementazione concreta Decorator per {@link ApplicationWeb}. Nel
 * costruttore riceve la classe delegate.
 *
 * @author lamberto.pauletti
 *
 */
public class ApplicationWebDecorator extends AbstractApplicationDecorator {

    public ApplicationWebDecorator(Application delegate) {
        this.delegate = delegate;
    }

    @Override
    public void doSomething() {
        this.delegate.doSomething();
        System.out.println("Aggiunta specilizzazione WEB!");

    }

}
