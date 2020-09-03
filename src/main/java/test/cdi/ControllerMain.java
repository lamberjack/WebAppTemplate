package test.cdi;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import test.annotations.FirstAlternative;
import utility.LoggerLP;

public class ControllerMain implements Serializable {

    @Inject
    private LoggerLP log;

    @Inject
    private FlatBean flatBean;

    /*
     * Avendo più di un implementazione di questa interfaccia viene specificato
     * quale implementazione istanziare con l'annotazione '@FirstAlternative'
     */
    @Inject
    @FirstAlternative
    private AlternativeExampleInterface alternativeExample;

    @PostConstruct
    private void initialize() {
        log.getLogger().info("controller post construct inizzializazione");
        alternativeExample.doTheBest();
    }

    public FlatBean getFlatBean() {
        return flatBean;
    }

}
