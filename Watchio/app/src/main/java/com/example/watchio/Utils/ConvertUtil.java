package com.example.watchio.Utils;

public class ConvertUtil {

    public static String converter(int numberToConvert) {
        String sConvertedNumber = "";
        if (numberToConvert > 1000000000) {
            int convertedNumber = numberToConvert / 1000000000;
            sConvertedNumber = convertedNumber + " billion USD";
        } else if (numberToConvert > 1000000) {
            int convertedNumber = numberToConvert / 1000000;
            sConvertedNumber = convertedNumber + " million USD";
        }
        return sConvertedNumber;
    }


}