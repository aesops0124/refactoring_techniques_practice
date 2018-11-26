package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
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

    // given person A does not have any owing order
    // when print the Owing order
    // then it should print 0 amount owing order
    @Test
    public void should_print_order_with_no_owing() {
        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("PersonA", Arrays.asList());
        assertEquals(
                "*****************************\r\n" +
                        "****** Customer totals ******\r\n" +
                        "*****************************\r\n" +
                        "name: PersonA\r\n" +
                        "amount: 0.0\r\n"
                , outContent.toString());
    }

    // given person B has a owing order
    // when print the Owing order
    // then it should print 2 amount owing order
    @Test
    public void should_print_order_with_one_owing() {
        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("PersonB", Arrays.asList(new Order (2)));
        assertEquals(
                "*****************************\r\n" +
                        "****** Customer totals ******\r\n" +
                        "*****************************\r\n" +
                        "name: PersonB\r\n" +
                        "amount: 2.0\r\n"
                , outContent.toString());
    }
    // given person C have two owing order
    // when print the Owing order
    // then it should print 6 amount owing order
    @Test
    public void should_print_order_with_multiple_owings() {
        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("PersonC", Arrays.asList(new Order (2),new Order (4)));
        assertEquals(
                "*****************************\r\n" +
                        "****** Customer totals ******\r\n" +
                        "*****************************\r\n" +
                        "name: PersonC\r\n" +
                        "amount: 6.0\r\n"
                , outContent.toString());
    }
}