package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class GetLengthTest {
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
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


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

    //This test covers if getLength returns the correct value if lower and upper are positive values, both are legal inputs. 
    @Test
    public void getLength_PositiveRange() {
    	//Validation.
        assertEquals("The length should be 5", 5, PositiveRange.getLength(), .000000001d);
    }

    //This test covers if getLength returns the correct value if lower and upper are negative values, both are legal inputs. 
    @Test
    public void getLength_NegativeRange() {
    	//Validation.
    	assertEquals("The length should be 5", 5, NegativeRange.getLength(), .000000001d);
    }
    
    //This test covers if getLength returns the correct value if lower is negative and upper is positive, both are legal inputs.     
    @Test
    public void getLength_OppositeRange() {
    	//Validation.
    	assertEquals("The length should be 20", 20, OppositeRange.getLength(), .000000001d);
    }
    
  //This test covers if getLength returns the correct value if lower is 0 and upper is positive, both are legal inputs. 
    @Test
    public void getLength_ZeroPositiveRange() {
    	//Validation.
    	assertEquals("The length should be 7", 7, ZeroPositiveRange.getLength(), .000000001d);
    }
    
    //This test covers if getLength returns the correct value if lower is negative and upper is 0, both are legal inputs.
    @Test
    public void getLength_ZeroNegativeRange() {
    	//Validation.
    	assertEquals("The length should be 7", 7, ZeroNegativeRange.getLength(), .000000001d);
    }
   
    //This test covers if getLength returns the correct value if lower is negative and upper is positive, both are legal inputs. 
    @Test
    public void getLength_BothZero() {
    	//Validation.
    	assertEquals("The length should be 0", 0, BothZeroRange.getLength(), .000000001d);
    }
    
    //This test covers if getLength returns the correct value if lower and upper are equal positive values, both are legal inputs. 
    @Test
    public void getLength_EqualPositve() {
    	//Validation.
    	assertEquals("The length should be 0", 0, EqualPositiveRange.getLength(), .000000001d);
    }
    
    //This test covers if getLength returns the correct value if lower and upper are equal negative values, both are legal inputs. 
    @Test
    public void getLength_EqualNegative() {
    	//Validation.
    	assertEquals("The length should be 0", 0, EqualNegativeRange.getLength(), .000000001d);
    }
    
    //This test covers if getLength returns the correct value if lower is a large negative value and upper is a large positive value, both are legal inputs.
    @Test
    public void getLength_LargeRange() {
    	//Validation.
    	assertEquals("The length should be 859744", 859744, LargeRange.getLength(), .000000001d);
    }
    
    //This test covers if getLength returns the correct value if lower is a small positive value and upper is a small positive value, both are legal inputs.
    @Test
    public void getLength_SmallRange() {
    	//Validation.
    	assertEquals("The length should be 2", 2, SmallRange.getLength(), .000000001d);
    }
   
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}