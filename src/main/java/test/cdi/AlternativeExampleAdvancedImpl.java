package test.cdi;

import javax.inject.Inject;

import test.annotations.FirstAlternative;
import utility.LoggerLP;

@FirstAlternative
public class AlternativeExampleAdvancedImpl implements AlternativeExampleInterface {

    @Inject
    private LoggerLP log;

    @Override
    public void doTheBest() {
        log.getLogger().info("Advanced implementation do the best!");

    }

}
