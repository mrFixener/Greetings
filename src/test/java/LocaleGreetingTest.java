/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.greetings.LocaleGreeting;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;
/**
 *
 * @author sdj
 */
public class LocaleGreetingTest {
    private ResourceBundle bundleByDefault;
    private ResourceBundle bundleRU;
    private ResourceBundle bundleUA;
    private ResourceBundle bundleUK;
    private static final String greetingsResource = "Greetings";
    public static Logger logger = Logger.getLogger(LocaleGreetingTest.class);

    public LocaleGreetingTest() {
    }

    @Before
    public void setUp() {
        bundleByDefault = ResourceBundle.getBundle(greetingsResource, Locale.getDefault());
        Locale locale = new Locale("ru", "RU");
        bundleRU = ResourceBundle.getBundle(greetingsResource, locale);

        locale = new Locale("ua", "UA");
        bundleUA = ResourceBundle.getBundle(greetingsResource, locale);

        locale = new Locale("uk", "UK");
        bundleUK = ResourceBundle.getBundle(greetingsResource, locale);
    }

    @After
    public void tearDown() {
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        new LocaleGreeting(null).sayGreeting(new Date());
    }  
}
