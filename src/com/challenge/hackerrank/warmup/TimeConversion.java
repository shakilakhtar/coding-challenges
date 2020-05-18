package com.challenge.hackerrank.warmup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @author Shakil Akhtar
 */
public class TimeConversion {


    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        Calendar cal = Calendar.getInstance();
        //convert time like 12:30 PM. convert to 24 hours time
        SimpleDateFormat format12Hour = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat format24Hour = new SimpleDateFormat("HH:mm:ss");

        Date date = null;
        try {
            //break string into acceptable format
            String newString =  s.substring(0, s.length() - 2)+" "+s.substring(s.length() - 2,s.length());
            date = format12Hour.parse(newString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(format12Hour.format(date) + " = " + format24Hour.format(date));

        return format24Hour.format(date);

    }

    public static void main(String[] args) {

        System.out.println(timeConversion("12:40:22AM"));
    }
}
