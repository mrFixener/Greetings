/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.greetings.LocaleGreeting;
import static com.greetings.PropertiesKeys.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/**
 *
 * @author sdj
 */
public class LocaleGreetingTest {
    private ResourceBundle bundleRU;
    private ResourceBundle bundleUA;
    private ResourceBundle bundleUK;
    private ResourceBundle bundleXX;
    public static Logger logger = Logger.getLogger(LocaleGreetingTest.class);

    public LocaleGreetingTest() {
    }
    @Before
    public void setUp() {
        Locale locale = new Locale("ru", "RU");
        bundleRU = ResourceBundle.getBundle(LOCALE_FILE.toString(), locale);
        locale = new Locale("ua", "UA");
        bundleUA = ResourceBundle.getBundle(LOCALE_FILE.toString(), locale);

        locale = new Locale("en", "UK");
        bundleUK = ResourceBundle.getBundle(LOCALE_FILE.toString(), locale);
    }

    @After
    public void tearDown() {
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        new LocaleGreeting(null).sayGreeting(new Date());
    } 
    @Test
    public void testRuLocaleSayMorning() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 06:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The morning greeting with Ru locale must equals", bundleRU.getString(MORNING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    @Test
    public void testRuLocaleSayMorning2() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 09:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a morning greeting it's must be day", bundleRU.getString(MORNING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    @Test
    public void testRuLocaleSayMorning3() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 08:59:59:999");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The morning greeting with Ru locale must equals", bundleRU.getString(MORNING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    //Day
    @Test
    public void testRuLocaleSayDay() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 18:59:59:999");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The day greeting with Ru locale must equals", bundleRU.getString(DAY.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayDay2() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 09:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The day greeting with Ru locale must equals", bundleRU.getString(DAY.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayDay3() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 19:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a day greeting it's must be evening", bundleRU.getString(DAY.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
        assertEquals("It must be evening", bundleRU.getString(EVANING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayDay4() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 17:03:15:419");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The day greeting with Ru locale must equals", bundleRU.getString(DAY.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayDay5() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 08:59:59:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a day it's can be morning", bundleRU.getString(DAY.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    //Evening
     @Test
    public void testRuLocaleSayEvening() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 22:59:59:999");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The evening greeting with Ru locale must equals", bundleRU.getString(EVANING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayEvening2() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 19:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The evening greeting with Ru locale must equals", bundleRU.getString(EVANING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayEvening3() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 23:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a evening greeting it's must be night", bundleRU.getString(EVANING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
        assertEquals("It must be night", bundleRU.getString(NIGHT.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayEvening4() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 19:03:15:419");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The evening greeting with Ru locale must equals", bundleRU.getString(EVANING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayEvening5() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 18:59:59:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a evening it's can be day", bundleRU.getString(EVANING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    //Night
    @Test
    public void testRuLocaleSayNight() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 05:59:59:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The night greeting with Ru locale must equals", bundleRU.getString(NIGHT.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    @Test
    public void testRuLocaleSayNight2() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 23:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The night greeting with Ru locale must equals", bundleRU.getString(NIGHT.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayNight3() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 06:00:00:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a night greeting it's must be morning", bundleRU.getString(NIGHT.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
        assertEquals("It must be night", bundleRU.getString(MORNING.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayNight4() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 04:23:15:784");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertEquals("The night greeting with Ru locale must equals", bundleRU.getString(NIGHT.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    
    @Test
    public void testRuLocaleSayNight5() throws ParseException{
        Date testDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").parse("2016-02-03 22:59:59:000");
        new LocaleGreeting(bundleRU).sayGreeting(testDate);
        assertNotEquals("It's not a night it's can be evening", bundleRU.getString(NIGHT.toString()),
                new LocaleGreeting(bundleRU).sayGreeting(testDate));
    }
    //Compare Ru,UA, Uk locale greetings
    @Test
    public void testCompareEnRuUaProper(){
        assertNotEquals("Ua greetings and Ru greetings can't equals", bundleRU.getString(MORNING.toString()),
                bundleUA.getString(MORNING.toString()));
        assertNotEquals("Ua greetings and Ru greetings can't equals", bundleRU.getString(DAY.toString()),
                bundleUA.getString(DAY.toString()));
        assertNotEquals("Ua greetings and Ru greetings can't equals", bundleRU.getString(EVANING.toString()),
                bundleUA.getString(EVANING.toString()));
        assertNotEquals("Ua greetings and Ru greetings can't equals", bundleRU.getString(NIGHT.toString()),
                bundleUA.getString(NIGHT.toString()));

        
        assertNotEquals("Uk greetings and Ru greetings can't equals", bundleRU.getString(MORNING.toString()),
                bundleUK.getString(MORNING.toString()));
        assertNotEquals("Uk greetings and Ru greetings can't equals", bundleRU.getString(DAY.toString()),
                bundleUK.getString(DAY.toString()));
        assertNotEquals("Uk greetings and Ru greetings can't equals", bundleRU.getString(EVANING.toString()),
                bundleUK.getString(EVANING.toString()));
        assertNotEquals("Uk greetings and Ru greetings can't equals", bundleRU.getString(NIGHT.toString()),
                bundleUK.getString(NIGHT.toString()));
    }
    @Test
    public void testSetterResourceBundle(){
        Date curdate = new Date();
        LocaleGreeting lg = new LocaleGreeting(bundleRU);
        String ruGreeting = lg.sayGreeting(curdate);
        lg.setResourceBundle(bundleUK);
        assertNotEquals("Greeting after set parameter must'n be same", ruGreeting,
                lg.sayGreeting(curdate));
    }
}
