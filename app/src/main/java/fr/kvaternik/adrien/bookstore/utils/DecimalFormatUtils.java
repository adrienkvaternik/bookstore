package fr.kvaternik.adrien.bookstore.utils;

import android.support.annotation.NonNull;

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
    @NonNull
    public static DecimalFormat decimalFormatEuros() {
        DecimalFormatSymbols symbols = getDefaultDecimalFormatSymbols();
        return new DecimalFormat("#.00 €", symbols);
    }

    /**
     * Provides a {@link DecimalFormat} to format euros reduction quantity, with 2 decimals.
     * @return The {@link DecimalFormat} for euros reduction.
     */
    @NonNull
    public static DecimalFormat decimalFormatEurosReduction() {
        DecimalFormatSymbols symbols = getDefaultDecimalFormatSymbols();
        return new DecimalFormat("-#.00 €", symbols);
    }

    /**
     * Provides a {@link DecimalFormat} to format percent reduction quantity, with 2 decimals.
     * @return The {@link DecimalFormat} for percent reduction.
     */
    @NonNull
    public static DecimalFormat decimalFormatPercentReduction() {
        DecimalFormatSymbols symbols = getDefaultDecimalFormatSymbols();
        return new DecimalFormat("-#.00 %", symbols);
    }

    /**
     * Provides the default {@link DecimalFormatSymbols}.
     * @return The default {@link DecimalFormatSymbols}.
     */
    @NonNull
    private static DecimalFormatSymbols getDefaultDecimalFormatSymbols() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.FRENCH);
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator(' ');
        return symbols;
    }
}
