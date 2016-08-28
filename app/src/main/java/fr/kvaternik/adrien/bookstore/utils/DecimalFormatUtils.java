package fr.kvaternik.adrien.bookstore.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * The utility class for {@link java.text.DecimalFormat}.
 */
public class DecimalFormatUtils {

    private DecimalFormatUtils() {}

    /**
     * Provides a {@link DecimalFormat} to format euros quantity, with 2 decimals.
     * @return The {@link DecimalFormat} for euros.
     */
    public static DecimalFormat decimalFormatEuros() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRENCH);
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator(' ');
        return new DecimalFormat("#.00 €", symbols);
    }
}
