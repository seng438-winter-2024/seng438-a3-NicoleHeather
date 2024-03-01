package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ToStringTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	
    }
    
    //This test covers if toString returns the correct string if lower and upper are positive values, both are legal inputs. 
    @Test
    public void toString_PositiveRange() {
    	//Creating first example range, this object will be reused for convenience. 
    	exampleRange = new Range(6.7898, 17.6453);
    	//Validation.
    	assertEquals("The string should be: Range[6.7898,17.6453]", "Range[6.7898,17.6453]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower and upper are negative values, both are legal inputs. 
    @Test
    public void toString_NegativeRange() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(-17.6453, -6.7898);
    	//Validation.
    	assertEquals("The string should be: Range[-17.6453,-6.7898]", "Range[-17.6453,-6.7898]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower is negative and upper is positive, both are legal inputs. 
    @Test
    public void toString_OppositeRange() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(-9.097, 10.3242);
    	//Validation.
    	assertEquals("The string should be: Range[-9.097,10.3242]", "Range[-9.097,10.3242]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower is 0 and upper is positive, both are legal inputs. 
    @Test
    public void toString_ZeroPositiveRange() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(0, 23.353);
    	//Validation.
    	assertEquals("The string should be: Range[0,23.353]", "Range[0,23.353]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower is negative and upper is 0, both are legal inputs. 
    @Test
    public void toString_ZeroNegativeRange() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(-68.48947, 0);
    	//Validation.
    	assertEquals("The string should be: Range[-68.48947,0]", "Range[-68.48947,0]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower is negative and upper is positive, both are legal inputs. 
    @Test
    public void toString_BothZero() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(0, 0);
    	//Validation.
    	assertEquals("The string should be: Range[0.0,0.0]", "Range[0.0,0.0]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower and upper are equal negative values, both are legal inputs. 
    @Test
    public void toString_EqualNegative() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(-34.4334, -34.4334);
    	//Validation.
    	assertEquals("The string should be: Range[-34.4334,-34.4334]", "Range[-34.4334,-34.4334]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower and upper are equal positive values, both are legal inputs. 
    @Test
    public void toString_EqualPositive() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(34.4334, 34.4334);
    	//Validation.
    	assertEquals("The string should be: Range[34.4334,34.4334]", "Range[34.4334,34.4334]", exampleRange.toString());
    }
    
    //This test covers if toString returns the correct string if lower is a large negative value and upper is a large positive value, both are legal inputs. 
    @Test
    public void toString_LargeRange() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(-9999.9999, 9999.9999);
    	//Validation.
    	assertEquals("The string should be: Range[-9999.9999,9999.9999]", "Range[-9999.9999,9999.9999]", exampleRange.toString());
    }

    //This test covers if toString returns the correct string if lower is a small positive value and upper is a small positive value, both are legal inputs. 
    @Test
    public void toString_SmallRange() {
    	//Setting new values for lower and upper.
    	exampleRange = new Range(0.900055, 0.900057);
    	//Validation.
    	assertEquals("The string should be: Range[0.900055,0.900057]", "Range[0.900055,0.900057]", exampleRange.toString());
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
