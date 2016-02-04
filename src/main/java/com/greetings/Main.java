/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greetings;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 *
 * @author Dimon
 */
public class Main {
    public static void main(String[] args) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("Greetings", Locale.getDefault());
            System.err.println(new LocaleGreeting(bundle).sayGreeting(new Date()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
