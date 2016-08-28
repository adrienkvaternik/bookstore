package fr.kvaternik.adrien.bookstore.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for {@link StringUtils}.
 */
public class StringUtilsShould {

    @Test
    public void return_an_empty_string_when_it_joins_an_empty_list() throws Exception {
        assertEquals("", StringUtils.join(new ArrayList<String>(), ","));
    }

    @Test
    public void join_a_list_with_the_specified_delimiter() throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        assertEquals("a,b,c", StringUtils.join(strings, ","));
    }
}