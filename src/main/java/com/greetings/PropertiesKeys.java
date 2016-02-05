/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.greetings;

/**
 *
 * @author sdj
 */
public enum PropertiesKeys {
        MORNING("morning"),
        DAY("day"),
        EVANING("evening"),
        NIGHT("night"),
        LOCALE_FILE("Greetings");
        private final String name;

        private PropertiesKeys(String s) {
            name = s;
        }

        public boolean equalsName(String otherName) {
            return (otherName == null) ? false : name.equals(otherName);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

