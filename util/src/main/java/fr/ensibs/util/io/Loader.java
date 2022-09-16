package fr.ensibs.util.io;


import java.io.InputStream;
import java.io.OutputStream;

public interface Loader<T> {
    public T load(InputStream in) throws Exception;

    public void save(T obj, OutputStream out) throws Exception;

}
