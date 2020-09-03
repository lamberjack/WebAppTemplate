package patterns.singleton;

public class SingletonExample {

    private static SingletonExample singletonExampleInstance = null;

    // costruttore privato per impedire di istanziare questa classe
    private SingletonExample() {

    }

    /*
     * Funzione che restituisce l'unica istanza della classe, inizializzandola
     * eventualmente. Il metodo è synchronized per consentire l'accesso
     * sincronizzato ad eventuali thread che potrebbero richiedere l'istanza
     * contemporaneamente. In questo modo solo un thread per volta potrà
     * richiedere l'oggetto ed al massimo un unica istanza sarà creata.
     */
    public static synchronized SingletonExample getSingletonExampleInstance() {
        if (singletonExampleInstance == null) {
            singletonExampleInstance = new SingletonExample();
        }
        return singletonExampleInstance;
    }

    public void getInformation() {
        System.out.println("Ciao sono l'istanza :" + singletonExampleInstance);
    }

}
