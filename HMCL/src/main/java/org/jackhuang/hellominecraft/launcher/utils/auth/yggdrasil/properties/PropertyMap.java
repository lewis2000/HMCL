package org.jackhuang.hellominecraft.launcher.utils.auth.yggdrasil.properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class PropertyMap extends HashMap<String, Property> {

    public static class Serializer implements JsonSerializer<PropertyMap>, JsonDeserializer<PropertyMap> {

        @Override
        public PropertyMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            PropertyMap result = new PropertyMap();
            if ((json instanceof JsonObject)) {
                JsonObject object = (JsonObject) json;

                for (Map.Entry<String, JsonElement> entry : object.entrySet())
                    if ((entry.getValue() instanceof JsonArray))
                        for (JsonElement element : (JsonArray) entry.getValue())
                            result.put(entry.getKey(),
                            new Property((String) entry.getKey(), element.getAsString()));
            } else if ((json instanceof JsonArray))
                for (JsonElement element : (JsonArray) json)
                    if ((element instanceof JsonObject)) {
                        JsonObject object = (JsonObject) element;
                        String name = object.getAsJsonPrimitive("name").getAsString();
                        String value = object.getAsJsonPrimitive("value").getAsString();

                        if (object.has("signature"))
                            result.put(name, new Property(name, value, object.getAsJsonPrimitive("signature").getAsString()));
                        else
                            result.put(name, new Property(name, value));
                    }

            return result;
        }

        @Override
        public JsonElement serialize(PropertyMap src, Type typeOfSrc, JsonSerializationContext context) {
            JsonArray result = new JsonArray();

            for (Property property : src.values()) {
                JsonObject object = new JsonObject();

                object.addProperty("name", property.name);
                object.addProperty("value", property.value);

                if (property.signature != null)
                    object.addProperty("signature", property.signature);

                result.add(object);
            }

            return result;
        }
    }
}
