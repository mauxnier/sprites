package fr.ensibs.model.actions;

import fr.ensibs.model.Sprite;
import fr.ensibs.util.graphic.IImage;
import fr.ensibs.util.io.IJsonConverter;
import javafx.scene.image.Image;
import org.json.JSONObject;

public class SpriteActionConverter<T extends IImage<Image>> implements IJsonConverter<Sprite<T>> {

    public Sprite<T> fromJson(JSONObject obj){
        /* Visibility or Motion */
        if(obj.has("visibility")):

        return null;
    }

    @Override
    public JSONObject toJson(Sprite<T> obj) {

        return null;
    }

}
