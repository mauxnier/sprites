package fr.ensibs.util.graphic.json;

import fr.ensibs.util.graphic.ISnapshotLayer;
import fr.ensibs.util.graphic.SnapshotLayer;
import fr.ensibs.util.io.IJsonConverter;
import fr.ensibs.util.io.SnapshotLayerConverter;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the {@link JsonConverter<SnapshotLayer>} class
 *
 * @author Pascale Launay
 */
public class SnapshotLayerConverterTest
{
    /**
     * A JSON object that represents a valid layer
     */
    private static final String LAYER_OBJ = "{ \"image\": \"image\", \"x\": 0, \"y\": 0, \"width\": 100, \"height\": 100 }";

    /**
     * Another JSON object that represents a valid layer
     */
    private static final String OTHER_LAYER_OBJ = "{ \"image\": \"other_image\", \"x\": 50, \"y\": 50 }";

    /**
     * A JSON object that represents an invalid layer
     */
    private static final String INVALID_IMAGE_LAYER_OBJ = "{ \"image\": \"invalid_image\", \"x\": 0, \"y\": 0, \"width\": 100, \"height\": 100 }";

    /**
     * A JSON object that represents a layer having an invalid image
     */
    private static final String INVALID_LAYER_OBJ = "{ \"image\": \"image\", \"x\": 0, \"width\": 100, \"height\": 100 }";

    /**
     * A  map of images
     */
    private static Map<String, ImageMock> IMAGES;

    /**
     * A snapshot layer
     */
    private static SnapshotLayer<ImageMock> LAYER;

    /**
     * Another snapshot layer
     */
    private static SnapshotLayer<ImageMock> OTHER_LAYER;

    /**
     * The instance to be tested
     */
    private IJsonConverter<SnapshotLayer<ImageMock>> instance;

    //------------------------------------------------------------------------
    // Initializations
    //------------------------------------------------------------------------

    /**
     * Initialize the objects used in the following tests (called once before
     * running all tests)
     */
    @BeforeAll
    public static void setup()
    {
        IMAGES = new HashMap<>();
        ImageMock image = new ImageMock();
        image.setName("image");
        IMAGES.put("image", image);
        image = new ImageMock();
        image.setName("other_image");
        IMAGES.put("other_image", image);

        LAYER = new SnapshotLayer<ImageMock>(0, 0, IMAGES.get("image"));
        OTHER_LAYER = new SnapshotLayer<ImageMock>(50, 50, IMAGES.get("other_image"));
    }

    /**
     * Initialize the instance to be tested (called before running each test)
     */
    @BeforeEach
    public void initialize()
    {
        this.instance = new SnapshotLayerConverter<ImageMock>(IMAGES);
    }

    //------------------------------------------------------------------------
    // Tests of the fromJson method
    //------------------------------------------------------------------------

    @Test
    public void testFromJson()
    {
        testFromJson(new JSONObject(LAYER_OBJ), LAYER);
    }

    @Test
    public void testFromOtherJson()
    {
        testFromJson(new JSONObject(OTHER_LAYER_OBJ), OTHER_LAYER);
    }

    private void testFromJson(JSONObject obj, ISnapshotLayer<ImageMock> expected)
    {
        try {
            // invoke the method to be tested
            ISnapshotLayer<ImageMock> actual = instance.fromJson(obj);

            // check the method results
            assertNotNull(actual);
            assertEquals(expected, actual);

        } catch (ParseException e) {
            fail("Exception " + e.getClass() + " should not occur: " + e.getMessage());
        }
    }

    @Test
    public void testFromInvalidJson()
    {
        testFromInvalidJson(new JSONObject(INVALID_LAYER_OBJ));
    }

    @Test
    public void testFromInvalidImageJson()
    {
        testFromInvalidJson(new JSONObject(INVALID_IMAGE_LAYER_OBJ));
    }

    private void testFromInvalidJson(JSONObject obj)
    {
        try {
            // invoke the method to be tested
            instance.fromJson(obj);

            // check the method results
            fail("ParseException should be thrown for this invalid layer JSON object");

        } catch (ParseException e) {
            assertNotNull(e);
        }
    }

    //------------------------------------------------------------------------
    // Tests of the toJson method
    //------------------------------------------------------------------------

    @Test
    public void testToJson()
    {
        // invoke the method to be tested
        JSONObject actual = instance.toJson(LAYER);

        // check the method results
        System.out.println(LAYER_OBJ);
        System.out.println(actual.toString());

        JSONAssert.assertEquals(LAYER_OBJ, actual, JSONCompareMode.STRICT);
    }
}
