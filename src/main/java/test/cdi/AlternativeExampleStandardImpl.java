package test.cdi;

import javax.inject.Inject;

import utility.LoggerLP;

public class AlternativeExampleStandardImpl implements AlternativeExampleInterface {

    @Inject
    private LoggerLP log;

    @Override
    public void doTheBest() {
        log.getLogger().info("Standard implementation do the best!");

    }

}
