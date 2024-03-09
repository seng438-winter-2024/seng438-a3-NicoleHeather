package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class ContainsTest {

    private Range exampleRange;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        // Creating first example range, this object will be reused for convenience.
        exampleRange = new Range(5, 20);
    }
    
    @Test
    public void contains_DoesContain() {
        assertTrue("contains() cannot correctly identify valid range", exampleRange.contains(7.8));
    }
    
    @Test
    public void contains_ValueGreaterThan() {
        assertFalse("contains() cannot correctly identify a value to large for the range", exampleRange.contains(909));
    }
    
    @Test
    public void contains_ValueLessThan() {
        assertFalse("contains() cannot correctly identify a value to small for the range", exampleRange.contains(-11));
    }

    @Test
    public void contains_EqualsLower() {
        assertTrue("contains() cannot correctly identify a value equal to lower", exampleRange.contains(5));
    }
    
    @Test
    public void contains_EqualsUpper() {
        assertTrue("contains() cannot correctly identify a value equal to upper", exampleRange.contains(20));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
