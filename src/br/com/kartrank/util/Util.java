/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kartrank.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author João
 */
public class Util {

    public static Time converterStringTime(String timeString, String format) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat(format);
        Date data = formato.parse(timeString);

        return new Time(data.getTime());
    }

    public static String sumTime(String tempo1, String tempo2) throws ParseException {

        Long mill1 = Util.stringTimeInMillSeconds(tempo1);
        Long mill2 = Util.stringTimeInMillSeconds(tempo2);

        Long sumMill = mill1 + mill2;

        return String.format("%d:%02d.%03d",
                TimeUnit.MILLISECONDS.toMinutes(sumMill),
                TimeUnit.MILLISECONDS.toSeconds(sumMill)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(sumMill)),
                sumMill % 1000);

    }
    
    public static Long stringTimeInMillSeconds(String tempo){
        String[] tempoList1 = tempo.split(":");
        Long mill = TimeUnit.MINUTES.toMillis(Long.parseLong(tempoList1[0]));
        mill = TimeUnit.SECONDS.toMillis(Long.parseLong(tempoList1[1])) + mill;
        mill = Long.parseLong(tempoList1[2]) + mill;

        return mill;
    }
}
