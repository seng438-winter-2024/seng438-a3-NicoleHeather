package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ConstrainTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
    /**
     * This test covers the equals() method using the exampleRange with a
     * valid Range object
     */
    @Test
    public void testValidObjectForMethodEquals() {
        Range exampleRange = new Range(-1, 1);
        assertTrue("The given object should be a valid Range object", exampleRange.equals(exampleRange));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}