package fr.kvaternik.adrien.bookstore.utils;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * The utility class for {@link String}.
 */
public class StringUtils {

    private StringUtils() {}

    /**
     * Joins the string list with the specified delimiter.
     * @param strings the string list
     * @param delimiter the delimiter
     * @return The joined string.
     */
    @NonNull
    public static String join(@NonNull List<String> strings, @NonNull String delimiter) {
        if (strings.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int size = strings.size();
        for (int i = 0; i < size - 1; i++) {
            String string = strings.get(i);
            builder.append(string);
            builder.append(delimiter);
        }
        builder.append(strings.get(size - 1));

        return builder.toString();
    }
}
