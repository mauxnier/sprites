package fr.ensibs.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import org.json.JSONObject;

public class JsonLoader implements ILoader<JSONObject> {

    @Override
    public JSONObject load(InputStream in) throws IOException, ParseException {
        StringBuilder textBuilder = new StringBuilder();
        int c = 0;
        while ((c = in.read()) != -1) {
            textBuilder.append((char) c);
        }

        String text = textBuilder.toString();
        return new JSONObject(text);
    }

    @Override
    public void save(JSONObject obj, OutputStream out) throws IOException {
        String jsonString = obj.toString();
        out.write(jsonString.getBytes());
    }
    
}
