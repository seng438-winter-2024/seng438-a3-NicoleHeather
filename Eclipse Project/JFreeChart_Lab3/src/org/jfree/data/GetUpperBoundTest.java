package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class GetUpperBoundTest {
    private Range PositiveRange;
    private Range NegativeRange;
    private Range OppositeRange;
    private Range ZeroPositiveRange;
    private Range ZeroNegativeRange;
    private Range BothZeroRange;
    private Range EqualNegativeRange;
    private Range EqualPositiveRange;
    private Range LargeRange;
    private Range SmallRange;


    @Before
    public void setUp() throws Exception { 
    	//Creating 10 range objects to use for each test method.
    	PositiveRange = new Range(5, 10);
    	NegativeRange = new Range(-10, -5);
    	OppositeRange = new Range(-10, 10);
    	ZeroPositiveRange = new Range(0, 7);
    	ZeroNegativeRange = new Range(-7, 0);
    	BothZeroRange = new Range(0, 0);
    	EqualNegativeRange = new Range(-10, -10);
    	EqualPositiveRange = new Range(10, 10);
    	LargeRange = new Range(2, 859746);
    	SmallRange = new Range(17, 19);
    }

    //This test covers if getUpperBound returns the correct value if lower and upper are positive values, both are legal inputs.
    @Test
    public void getUpperBound_PositiveRange() {
    	//Validation.
        assertEquals("The upper bound should be 10", 10, PositiveRange.getUpperBound(), .000000001d);
    }

    //This test covers if getUpperBound returns the correct value if lower and upper are negative values, both are legal inputs. 
    @Test
    public void getUpperBound_NegativeRange() {
    	//Validation.
    	assertEquals("The upper bound should be -5", -5, NegativeRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower is negative and upper is positive, both are legal inputs. 
    @Test
    public void getUpperBound_OppositeRange() {
    	//Validation.
    	assertEquals("The upper bound should be 10", 10, OppositeRange.getUpperBound(), .000000001d);
    }

    //This test covers if getUpperBound returns the correct value if lower is 0 and upper is positive, both are legal inputs. 
    @Test
    public void getUpperBound_ZeroPositiveRange() {
    	//Validation.
    	assertEquals("The upper bound should be 7", 7, ZeroPositiveRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower is negative and upper is 0, both are legal inputs. 
    @Test
    public void getUpperBound_ZeroNegativeRange() {
    	//Validation.
    	assertEquals("The upper bound should be 0", 0, ZeroNegativeRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower is negative and upper is positive, both are legal inputs. 
    @Test
    public void getUpperBound_BothZero() {
    	//Validation.
    	assertEquals("The upper bound should be 0", 0, BothZeroRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower and upper are equal positive values, both are legal inputs. 
    @Test
    public void getUpperBound_EqualPositve() {
    	//Validation.
    	assertEquals("The upper bound should be 10", 10, EqualPositiveRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower and upper are equal negative values, both are legal inputs. 
    @Test
    public void getUpperBound_EqualNegative() {
    	//Validation.
    	assertEquals("The upper bound should be -10", -10, EqualNegativeRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower is a large negative value and upper is a large positive value, both are legal inputs. 
    @Test
    public void getUppererBound_LargeRange() {
    	//Validation.
    	assertEquals("The upper bound should be 859746", 859746, LargeRange.getUpperBound(), .000000001d);
    }
    
    //This test covers if getUpperBound returns the correct value if lower is a small positive value and upper is a small positive value, both are legal inputs. 
    @Test
    public void getUpperBound_SmallRange() {
    	//Validation.
    	assertEquals("The upper bound should be 19", 19, SmallRange.getUpperBound(), .000000001d);
    }
   
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
}