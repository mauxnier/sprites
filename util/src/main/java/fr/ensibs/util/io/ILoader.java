package fr.ensibs.util.io;

import java.io.InputStream;
import java.io.OutputStream;

public interface ILoader<T> {
    public T load(InputStream in) throws Exception;
    public void save(T obj, OutputStream out) throws Exception;
}
