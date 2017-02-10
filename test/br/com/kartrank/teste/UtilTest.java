/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kartrank.teste;

import br.com.kartrank.constant.Constant;
import br.com.kartrank.util.Util;
import java.sql.Time;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João
 */
public class UtilTest {

    public UtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void converterStringTimeHTest() {
        try {
            assertEquals(new Time(18082555L), Util.converterStringTime("2:01:22.555", Constant.FORMAT_HH_MM_SS_SSS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void converterStringTimemTest() {
        try {
            assertEquals(new Time(10882555L), Util.converterStringTime("01:22.555", Constant.FORMAT_MM_SS_SSS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sumTimeTest() {
        try {
            assertEquals("2:06.022", Util.sumTime("1:02:852", "1:03:170"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringTimeInMillSecondsTest() {
        assertEquals(new Long("62852"), Util.stringTimeInMillSeconds("1:02:852"));
    }
}
