package fr.ensibs.util.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the class that implements the {@link TextLoader} interface
 *
 * @author Pascale Launay
 *
 */
public class TextLoaderImplTest
{
    /**
     * An empty text
     */
    private static final String EMPTY_TXT = "";

    /**
     * A short text
     */
    private static final String SHORT_TXT = "This is a very short text";

    /**
     * A short text
     */
    private static final String LONG_TXT = "# JUnit\r\n\r\n" +
            "From Wikipedia, the free encyclopedia\r\n\r\n" +
            "JUnit is a unit testing framework for the Java programming language. JUnit has been important in the development of test-driven development, and is one of a family of unit testing frameworks which is collectively known as xUnit that originated with SUnit.\r\n\r\n" +
            "JUnit is linked as a JAR at compile-time. The latest version of the framework, JUnit 5, resides under package org.junit.jupiter. Previous versions JUnit 4 and JUnit 3 were under packages org.junit and junit.framework, respectively.\r\n\r\n" +
            "A research survey performed in 2013 across 10,000 Java projects hosted on GitHub found that JUnit (in a tie with slf4j-api), was the most commonly included external library. Each library was used by 30.7% of projects.\r\n\r\n" +
            "## Example of JUnit test fixture\r\n\r\n" +
            "A JUnit test fixture is a Java object. Test methods must be annotated by the @Test annotation. If the situation requires it,[4] it is also possible to define a method to execute before (or after) each (or all) of the test methods with the @BeforeEach (or @AfterEach) and @BeforeAll (or @AfterAll) annotations.\r\n\r\n" +
            "```\r\n" +
            "import org.junit.jupiter.api.*;\r\n\r\n" +
            "public class FoobarTest {\r\n" +
            "    @BeforeAll\r\n" +
            "    public static void setUpClass() throws Exception {\r\n" +
            "        // Code executed before the first test method\r\n" +
            "    }\r\n" +
            "\r\n" +
            "    @BeforeEach\r\n" +
            "    public void setUp() throws Exception {\r\n" +
            "        // Code executed before each test\r\n" +
            "    }\r\n" +
            "\r\n" +
            "    @Test\r\n" +
            "    public void oneThing() {\r\n" +
            "        // Code that tests one thing\r\n" +
            "    }\r\n" +
            "\r\n" +
            "    @Test\r\n" +
            "    public void anotherThing() {\r\n" +
            "        // Code that tests another thing\r\n" +
            "    }\r\n" +
            "\r\n" +
            "    @Test\r\n" +
            "    public void somethingElse() {\r\n" +
            "        // Code that tests something else\r\n" +
            "    }\r\n" +
            "\r\n" +
            "    @AfterEach\r\n" +
            "    public void tearDown() throws Exception {\r\n" +
            "        // Code executed after each test\r\n" +
            "    }\r\n" +
            "\r\n" +
            "    @AfterAll\r\n" +
            "    public static void tearDownClass() throws Exception {\r\n" +
            "        // Code executed after the last test method\r\n" +
            "    }\r\n" +
            "}\r\n" +
            "```\r\n\r\n" +
            "Previous versions of JUnit\r\n\r\n" +
            "According to Martin Fowler, one the of early adopters of JUnit:\r\n\r\n" +
            "> JUnit was born on a flight from Zurich to the 1997 OOPSLA in Atlanta. Kent was flying with Erich Gamma, and what else were two geeks to do on a long flight but program? The first version of JUnit was built there, pair programmed, and done test first (a pleasing form of meta-circular geekery).\r\n\r\n" +
            "As a side effect of its wide use, previous versions of JUnit remain popular, with JUnit 4 having over 100,000 usages by other software components on the Maven central repository.\r\n\r\n" +
            "In JUnit 4, the annotations for test execution callbacks were @BeforeClass, @Before, @After, and @AfterClass, as opposed to JUnit 5's @BeforeAll, @BeforeEach, @AfterEach, and @AfterAll.\r\n\r\n" +
            "In JUnit 3, test fixtures had to inherit from junit.framework.TestCase. Also, test methods had to be prefixed with 'test'.";

    /**
     * The instance to be tested
     */
    private TextLoader instance;

    //------------------------------------------------------------------------
    // Initializations
    //------------------------------------------------------------------------

    /**
     * Initialize the instance to be tested (called before running each test)
     */
    @BeforeEach
    public void initialize()
    {
        // TODO initialize the instance to be tested
        this.instance = new TextLoader();
    }

    //------------------------------------------------------------------------
    // Tests of the load method
    //------------------------------------------------------------------------

    /**
     * Test the {@link TextLoader#load(InputStream)} method with an empty text
     */
    @Test
    public void testLoadEmpty()
    {
        testLoad("/text/empty.txt", EMPTY_TXT);
    }

    /**
     * Test the {@link TextLoader#load(InputStream)} method with a short text
     */
    @Test
    public void testLoadShort()
    {
        testLoad("/text/short.txt", SHORT_TXT);
    }

    /**
     * Test the {@link TextLoader#load(InputStream)} method with a long text
     */
    @Test
    public void testLoadLong()
    {
        testLoad("/text/long.txt", LONG_TXT);
    }

    /**
     * Test the {@link TextLoader#load(InputStream)} method with the given arguments
     *
     * @param inFile   the name of the input file in the test resources
     * @param expected the expected result
     */
    private void testLoad(String inFile, String expected)
    {

        // initialize the parameter
        try (InputStream in = TextLoaderImplTest.class.getResourceAsStream(inFile)) {

            // invoke the method to be tested
            String actual = instance.load(in);

            // check the method results
            assertNotNull(actual);
            assertEquals(expected, actual);

        } catch (IOException e) {
            fail("Exception " + e.getClass() + " should not occur: " + e.getMessage());
        }
    }


    //------------------------------------------------------------------------
    // Tests of the save method
    //------------------------------------------------------------------------

    /**
     * Test the {@link TextLoader#save(String, OutputStream)} method with an empty text
     */
    @Test
    public void testSaveEmpty()
    {
        testSave(EMPTY_TXT);
    }

    /**
     * Test the {@link TextLoader#save(String, OutputStream)} method with a short text
     */
    @Test
    public void testSaveShort()
    {
        testSave(SHORT_TXT);
    }

    /**
     * Test the {@link TextLoader#save(String, OutputStream)} method with a long text
     */
    @Test
    public void testSaveLong()
    {
        testSave(LONG_TXT);
    }

    /**
     * Test the {@link TextLoader#save(String, OutputStream)} method with the given argument
     *
     * @param text the text to be saved and then reloaded
     */
    private void testSave(String text)
    {

        try {
            byte[] buffer;

            // initialize the parameters
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {

                // invoke the method to be tested
                instance.save(text, out);
                buffer = out.toByteArray();
            }
            // check the method results by loading the saved object
            try (InputStream in = new ByteArrayInputStream(buffer)) {
                String actual = instance.load(in);
                assertEquals(text, actual);
            }

        } catch (IOException e) {
            fail("Exception " + e.getClass() + " should not occur: " + e.getMessage());
        }
    }
}
