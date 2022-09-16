package fr.ensibs.javafx.graphic;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple directory composed of a list of files
 *
 * @author Pascale Launay
 *
 * @inv getFiles() != null
 */
public class Directory
{

    /**
     * The files in the directory
     */
    private Map<String, Object> files;

    /**
     * Constructor. Initialize the default values
     */
    public Directory()
    {
        files = new HashMap<>();
    }

    /**
     * Reset the directory to its initial values
     */
    public void reset()
    {
        files.clear();
    }

    /**
     * Add a new file to the directory
     *
     * @param file the new file
     *
     * @pre file != null
     */
    public void addFile(String fileName, Object content)
    {
        files.put(fileName, content);
    }

    /**
     * Add a new file to the directory
     *
     * @param file the new file
     *
     * @pre file != null
     */
    public void addAllFile(Map<String, Object> filesList)
    {
        files.putAll(filesList);
    }

    /**
     * Give the files in the directory
     * @return the directory files
     */
    public Map<String, Object> getFiles()
    {
        return files;
    }

    /**
     * Give the file in the directory from its name
     * @return the directory file
     */
    public Object getFile(String key)
    {
        return files.get(key);
    }
}
