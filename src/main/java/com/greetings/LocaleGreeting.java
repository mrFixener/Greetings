/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greetings;

import static com.greetings.PropertieKeys.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author sdj
 */
public class LocaleGreeting {
    private ResourceBundle resourceBundle;
    public LocaleGreeting(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public String sayGreeting(Date curDate) {
        if (curDate == null
                || resourceBundle == null) {
            throw new IllegalArgumentException("Aggument in method sayGreeting can't be null.");
        }
        TimeConstants tc = new TimeConstants(curDate);
        if (curDate.after(tc.BEFORE_SIX) && curDate.before(tc.NINE)) {//06:00 - 09:00
            return resourceBundle.getString(MORNING);
        } else if (curDate.after(tc.BEFORE_NINE) && curDate.before(tc.NINETEEN)) {//09:00 - 19:00
            return resourceBundle.getString(DAY);
        } else if (curDate.after(tc.BEFORE_NINETEEN) && curDate.before(tc.TWENTY_THREE)) {//19:00 - 23:00
            return resourceBundle.getString(EVANING);
        } else{ //23:00 - 06:00
            return resourceBundle.getString(NIGHT);
        }
    }

    private class TimeConstants {
        private DateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        private Date BEFORE_SIX, BEFORE_NINE, NINE, BEFORE_NINETEEN, NINETEEN, TWENTY_THREE;

        TimeConstants(final Date curDate) {
            init(curDate);
        }

        private void init(final Date curDate) {
            try {
                String strDate = new SimpleDateFormat("yyyy-MM-dd ").format(curDate);
                BEFORE_SIX = parser.parse(strDate + "05:59:59:999");
                BEFORE_NINE = parser.parse(strDate + "08:59:59:999");
                NINE = parser.parse(strDate + "09:00:00:000");
                BEFORE_NINETEEN = parser.parse(strDate + "18:59:59:999");
                NINETEEN = parser.parse(strDate + "19:00:00:000");
                TWENTY_THREE = parser.parse(strDate + "23:00:00:000");
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }
}
