package examples;

@FunctionalInterface
public interface TriFunctionExample<R, A, B, C> {

    R apply(A a, B b, C c);

}
