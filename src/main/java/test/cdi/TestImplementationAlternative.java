package test.cdi;

import test.annotations.FirstAlternative;

@FirstAlternative
public class TestImplementationAlternative implements TestInterface {

    @Override
    public void doSomething() {
        System.out.println("Implementazione ALTERNATIVA");
    }

}
