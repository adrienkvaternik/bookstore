package fr.kvaternik.adrien.bookstore.model.service.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.kvaternik.adrien.bookstore.model.entity.Offer;

/**
 * The deserializer for the offer list.
 */
public class OfferListDeserializer implements JsonDeserializer<List<Offer>> {
    @Override
    public List<Offer> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonOffers = jsonObject.get("offers").getAsJsonArray();

        List<Offer> offers = new ArrayList<>();
        for (JsonElement jsonOffer : jsonOffers) {
            Offer offer = context.deserialize(jsonOffer, Offer.class);
            offers.add(offer);
        }

        return offers;
    }
}
