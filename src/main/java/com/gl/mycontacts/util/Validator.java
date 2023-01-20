package com.gl.mycontacts.util;

public class Validator {


    public static boolean containsNumber(String value){
        for(Character c: value.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
    public static boolean containsAlphabate(String value){
        for(Character c: value.toCharArray()){
            if(Character.isAlphabetic(c) || c.equals(" ")){
                return true;
            }
        }
        return false;
    }

}
