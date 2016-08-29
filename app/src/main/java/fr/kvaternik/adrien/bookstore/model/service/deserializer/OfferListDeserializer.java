package fr.kvaternik.adrien.bookstore.model.service.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * The deserializer for the offer list.
 */
public class OfferListDeserializer implements JsonDeserializer<List<Offer>> {
    @Override
    public List<Offer> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        Offer[] offers = context.deserialize(json.getAsJsonObject().get("offers"), Offer[].class);
        return Arrays.asList(offers);
    }
}
