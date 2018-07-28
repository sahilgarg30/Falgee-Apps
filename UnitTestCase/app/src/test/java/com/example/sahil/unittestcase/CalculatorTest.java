package com.example.sahil.unittestcase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sahil on 29-06-2017.
 */

public class CalculatorTest {
    private Calculator mCalc;

    @Before
    public void setUp(){
        mCalc = new Calculator();
    }
    @Test
    public void addTest(){
        assertEquals(9,mCalc.add(4,5));
    }
    @Test
    public void subtractTest(){
        assertEquals(2,mCalc.subtract(5,3));
    }
    @Test
    public void multiplyTest(){
        assertEquals(18,mCalc.multiply(6,3));
    }
    @Test
    public void divideTest(){
        assertEquals(4,mCalc.divide(20,5));
    }
}
