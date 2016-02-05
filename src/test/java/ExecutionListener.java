
import org.apache.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sdj
 */
public class ExecutionListener extends RunListener {
    private static final Logger logger = LocaleGreetingTest.logger;

    /**
     * Called before any tests have been run.
	 *
     */
    @Override
    public void testRunStarted(Description description) throws java.lang.Exception {
        logger.info("Number of testcases to execute : " + description.testCount());
    }

    /**
     * Called when all tests have finished
	 *
     */
    @Override
    public void testRunFinished(Result result) throws java.lang.Exception {
        logger.info("Number of testcases executed : " + result.getRunCount());
    }

    /**
     * Called when an atomic test is about to be started.
	 *
     */
    @Override
    public void testStarted(Description description) throws java.lang.Exception {
        logger.info("Starting execution of test case : " + description.getMethodName());
    }

    /**
     * Called when an atomic test has finished, whether the test succeeds or
     * fails.
	 *
     */
    @Override
    public void testFinished(Description description) throws java.lang.Exception {
        logger.info("Finished execution of test case : " + description.getMethodName());
    }

    /**
     * Called when an atomic test fails.
	 *
     */
    @Override
    public void testFailure(Failure failure) throws java.lang.Exception {
        logger.info("Execution of test case failed : " + failure.getMessage());
    }

    /**
     * Called when a test will not be run, generally because a test method is
     * annotated with Ignore.
	 *
     */
    @Override
    public void testIgnored(Description description) throws java.lang.Exception {
        logger.info("Execution of test case ignored : " + description.getMethodName());
    }
}
