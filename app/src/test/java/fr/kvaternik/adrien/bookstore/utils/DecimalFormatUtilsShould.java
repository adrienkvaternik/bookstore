package fr.kvaternik.adrien.bookstore.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for {@link DecimalFormatUtils}.
 */
public class DecimalFormatUtilsShould {

    @Test
    public void return_a_decimal_format_that_formats_in_euros() throws Exception {
        assertEquals("35,00 €", DecimalFormatUtils.decimalFormatEuros().format(35.0));
    }
    @Test
    public void return_a_decimal_format_that_formats_in_euros_reduction() throws Exception {
        assertEquals("-10,00 €", DecimalFormatUtils.decimalFormatEurosReduction().format(10.0));
    }

    @Test
    public void return_a_decimal_format_that_formats_in_percent_reduction() throws Exception {
        assertEquals("-20,00 %", DecimalFormatUtils.decimalFormatPercentReduction().format(0.2));
    }
}