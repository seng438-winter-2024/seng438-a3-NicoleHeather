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
     * This test covers to see if the system can return the correct value with a normal constrain value
     */
	@Test
    public void constrainNormalValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(9.98) == 9.98);
    }
	
    /**
     * This test covers to see if the system can return the correct value with constrain value less than lower
     */
	@Test
    public void constrainReturnLowerValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(-10) == -5);
    }
	
    /**
     * This test covers to see if the system can return the correct value with constrain value more than upper
     */
	@Test
    public void constrainReturnUpperValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(800) == 25);
    }
	
    /**
     * This test covers to see if the system can return the correct value with constrain value equal to lower
     */
	@Test
    public void constrainReturnEqualLowerValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(-5) == -5);
    }
	
    /**
     * This test covers to see if the system can return the correct value with constrain value equal to upper
     */
	@Test
    public void constrainReturnEqualUpperValue() {
        Range exampleRange = new Range(-5, 25);
        assertTrue("returned value is incorrect", exampleRange.constrain(25) == 25);
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}