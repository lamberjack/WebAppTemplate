package test.cdi;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import utility.LoggerLP;

public class FlatBean implements Serializable {

    @Inject
    private LoggerLP log;

    @PostConstruct
    private void initializeBean() {
        // operazioni preliminari eseguite prima che questo bean venga effettivamente injectato
        log.getLogger().info("Inizializzazione post Construct del bean 'FlatBean'");

    }
}
