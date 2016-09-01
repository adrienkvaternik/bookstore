package fr.kvaternik.adrien.bookstore.utils;

import android.support.annotation.NonNull;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * The utility class for {@link java.text.DecimalFormat}.
 */
public class DecimalFormatUtils {

    private static final String PATTERN_EUROS = "#.00 €";
    private static final String PATTERN_EUROS_REDUCTION = "-#.00 €";
    private static final String PATTERN_PERCENT_REDUCTION = "-#.00 %";

    private DecimalFormatUtils() {}

    /**
     * Provides a {@link DecimalFormat} to format euros quantity, with 2 decimals.
     * @return The {@link DecimalFormat} for euros.
     */
    @NonNull
    public static DecimalFormat decimalFormatEuros() {
        return getDecimalFormatWithPattern(PATTERN_EUROS);
    }

    /**
     * Provides a {@link DecimalFormat} to format euros reduction quantity, with 2 decimals.
     * @return The {@link DecimalFormat} for euros reduction.
     */
    @NonNull
    public static DecimalFormat decimalFormatEurosReduction() {
        return getDecimalFormatWithPattern(PATTERN_EUROS_REDUCTION);
    }

    /**
     * Provides a {@link DecimalFormat} to format percent reduction quantity, with 2 decimals.
     * @return The {@link DecimalFormat} for percent reduction.
     */
    @NonNull
    public static DecimalFormat decimalFormatPercentReduction() {
        return getDecimalFormatWithPattern(PATTERN_PERCENT_REDUCTION);
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

    /**
     * Provides the {@link DecimalFormat} with the specified pattern.
     * @param pattern the pattern
     * @return The {@link DecimalFormat}.
     */
    private static DecimalFormat getDecimalFormatWithPattern(@NonNull String pattern) {
        DecimalFormatSymbols symbols = getDefaultDecimalFormatSymbols();
        return new DecimalFormat(pattern, symbols);
    }
}
