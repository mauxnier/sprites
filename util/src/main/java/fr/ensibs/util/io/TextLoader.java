package fr.ensibs.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TextLoader implements ITextLoader {

    /**
     * Read a text from an input stream.
     *
     * @param in input stream
     * @return the text read from the input stream
     * @throws IOException if an error occurs while reading from the input stream
     */
    @Override
    public String load(InputStream in) throws IOException {
        StringBuilder textBuilder = new StringBuilder();
        int c;
        while ((c = in.read()) != -1) {
            if ((char) c != '\0') {
                textBuilder.append((char) c);
            } else {
                System.out.println("null");
            }
        }
       return textBuilder.toString();
    }

    /**
     * Save a text to an output stream
     *
     * @param text the text to be written to the output stream
     * @param out  the output stream
     * @throws IOException if an error occurs while writing to the output stream
     */
    @Override
    public void save(String text, OutputStream out) throws IOException {
        out.write(text.getBytes());
    }
}
