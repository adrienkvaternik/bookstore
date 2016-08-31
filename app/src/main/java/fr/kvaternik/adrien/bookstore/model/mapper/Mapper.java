package fr.kvaternik.adrien.bookstore.model.mapper;

/**
 * A mapper between two classes.
 * @param <F> the input type
 * @param <T> the output type
 */
public interface Mapper<F, T> {

    /**
     * Maps the specified object to the output type.
     * @param from the input object
     * @return The output object.
     */
    T map(F from);
}