package fr.ensibs.javafx.graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple directory composed of a list of names
 *
 * @author Pascale Launay
 *
 * @inv getNames() != null
 */
public class Directory
{
    /**
     * The directory default initial values
     */
    private static final String[] DEFAULT_VALUES = {"Alice", "Bob", "Carol", "David"};

    /**
     * The names in the directory
     */
    private List<String> names;

    /**
     * Constructor. Initialize the default values
     */
    public Directory()
    {
        names = new ArrayList<>();
        for (String name : DEFAULT_VALUES) {
            names.add(name);
        }
    }

    /**
     * Reset the directory to its initial values
     */
    public void reset()
    {
        names.clear();
        for (String name : DEFAULT_VALUES) {
            names.add(name);
        }
    }

    /**
     * Add a new name to the directory
     *
     * @param name the new name
     *
     * @pre name != null
     */
    public void addName(String name)
    {
        names.add(name);
    }

    /**
     * Give the names in the directory
     * @return the directory names
     */
    public List<String> getNames()
    {
        return names;
    }
}
