
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.apache.log4j.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sdj
 */
public class LocaleGreetingTestExecutor {
    public static void main(String[] args) throws Exception {
        Logger logger = LocaleGreetingTest.logger;
        logger.info("--------------------------------Start-----------------------------------");
        JUnitCore runner = new JUnitCore();
        runner.addListener(new ExecutionListener());
        Result result = runner.run(LocaleGreetingTest.class);
        logger.info("-------------------------------Summary----------------------------------");
        logger.info("Run tests: " + result.getRunCount());
        logger.info("Failed tests: " + result.getFailureCount());
        logger.info("Ignored tests: " + result.getIgnoreCount());
        logger.info("Success: " + result.wasSuccessful());
        logger.info("---------------------------------END------------------------------------");
    }
    
}
