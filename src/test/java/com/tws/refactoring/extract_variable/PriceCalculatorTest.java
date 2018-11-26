package com.tws.refactoring.extract_variable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;


public class PriceCalculatorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    public void should_get_price_not_discount_without_max_shipping_cost(){
        double price = new PriceCalculator().getPrice(2,2);
        assertEquals(price, 4.4);
    }
    @Test
    public void should_get_price_not_discount_with_max_shipping_cost(){
        double price = new PriceCalculator().getPrice(2,1000);
        assertEquals(price, 2100.0);
    }
    @Test
    public void should_get_price_have_discount_without_max_shipping_cost(){
        double price = new PriceCalculator().getPrice(800,1);
        assertEquals(price, 865.0);
    }

    @Test
    public void should_get_price_have_discount_with_max_shipping_cost(){
        double price = new PriceCalculator().getPrice(800,10);
        assertEquals(price, 7950.0);
    }

}