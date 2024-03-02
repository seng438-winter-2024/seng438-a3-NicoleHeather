package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;


import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	//calculateColumnTotal() tests
	
	//Test for calculating the sum of two columns
	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 10.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	//Test for calculating the sum of invalid values (strings)
		 @Test
		 public void calculateColumnTotalForInvalidValues() {
		     // setup
		     Mockery mockingContext = new Mockery();
		     final Values2D values = mockingContext.mock(Values2D.class);
		     mockingContext.checking(new Expectations() {
		         {
		             one(values).getRowCount();
		             will(returnValue(2));
		             one(values).getValue(0, 0);
		             will(returnValue("a"));
		             one(values).getValue(1, 0);
		             will(returnValue("b"));
		         }
		     });
		     
		     try {
		         DataUtilities.calculateColumnTotal(values, 0);
		         fail("Expected InvalidParameterException");
		     } catch (InvalidParameterException e) {
		         // verify that InvalidParameterException is caught
		     
		 } catch (IllegalStateException e) {
	    	 fail("Expected InvalidParameterException (not IllegalStateException)");
	     }
		     
		 }
	
	 //Test for calculating the sum of three columns
	 @Test
	    public void calculateColumnTotalForThreeValues() {
	        // setup
	        Mockery mockingContext = new Mockery(); //creating mock object
	        final Values2D values = mockingContext.mock(Values2D.class);
	        
	        //creating values in mock object to verify
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(3));
	                one(values).getValue(0, 0);
	                will(returnValue(3.5));
	                one(values).getValue(1, 0);
	                will(returnValue(2.0));
	                one(values).getValue(2, 0);
	                will(returnValue(4.5));
	            }
	        });
	       //use actual method to compare to mock object
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        // verify
	        assertEquals(result, 10.0, 0.0001); 
	    }
	 
	 //Test for calculating column with array containing 0
	 @Test
	    public void calculateColumnTotalWithZeroInput() {
	        // setup
	        Mockery mockingContext = new Mockery(); //creating mock object
	        final Values2D values = mockingContext.mock(Values2D.class);
	        //creating values in mock object to verify
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(0));
	            }
	        });
	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        // verify
	        assertEquals(0.0, result, 0.0001);
	    }
	//Test for column sum with 7 (several) columns
	 @Test
	    public void calculateColumnTotalWithMultipleColumns() {
	        // setup
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() { //mock object with multiple columns
	            {
	                one(values).getRowCount();
	                will(returnValue(3)); 
	                one(values).getColumnCount();
	                will(returnValue(2)); 
	                allowing(values).getValue(0, 0);
	                will(returnValue(3.5)); 
	                allowing(values).getValue(1, 0);
	                will(returnValue(2.0)); 
	                allowing(values).getValue(2, 0);
	                will(returnValue(4.5)); 
	                allowing(values).getValue(0, 1);
	                will(returnValue(1.5)); 
	                allowing(values).getValue(1, 1);
	                will(returnValue(2.5)); 
	                allowing(values).getValue(2, 1);
	                will(returnValue(3.5)); 
	            }
	        });
	        
	        double result = DataUtilities.calculateColumnTotal(values, 1);

	        // verify
	        assertEquals(7.5, result, 0.0001); 
	    }
	 
	 //Test for calculating sum with missing value in middle of column
	 @Test
	    public void calculateColumnTotalWithMissingValue() {
	        // setup
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() { //mock object with one null value
	            {
	                one(values).getRowCount();
	                will(returnValue(3)); 
	                one(values).getColumnCount();
	                will(returnValue(1)); 
	                allowing(values).getValue(0, 0);
	                will(returnValue(3.5)); 
	                allowing(values).getValue(1, 0);
	                will(returnValue(null)); 
	                allowing(values).getValue(2, 0);
	                will(returnValue(4.5)); 
	            }
	        });
	        
	        double result = DataUtilities.calculateColumnTotal(values, 0);

	        // verify
	        assertEquals(8.0, result, 0.0001); 
	    }
	 
	 //Test for calculating sum with one column 
	 @Test
	 public void calculateColumnTotalWithOneColumn() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() { //mock object with one column
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             one(values).getColumnCount();
	             will(returnValue(1)); 
	             allowing(values).getValue(0, 0);
	             will(returnValue(3.5)); 
	             allowing(values).getValue(1, 0);
	             will(returnValue(2.0)); 
	             allowing(values).getValue(2, 0);
	             will(returnValue(4.5)); 
	         }
	     });
	     
	     double result = DataUtilities.calculateColumnTotal(values, 0); 

	     // verify
	     assertEquals(10.0, result, 0.0001); 
	 }
	 
	 //Test for calculating sum with null object
	 @Test
	 public void calculateColumnTotalWithNullDataObject() {
	     try {
	         DataUtilities.calculateColumnTotal(null, 0);
	         fail("Expected NullPointerException");
	     } catch (NullPointerException e) {
	         // verify that NullPointerException is caught
	     }
	 }
	 
	 //createNumberArray() tests
	 
     @Test
     public void CreateNumberArray_validInput() {
        // Valid input, expects non-null array with correct values
        double[] data = { 1.0, 2.5, 3.7 };
        Number[] result = DataUtilities.createNumberArray(data);

        assertNotNull(result); //check array is not null
        assertEquals(data.length, result.length); //check array is correct length
     // Check each index of the array
        for (int i = 0; i < data.length; i++) { // check each index of the array
            if (result[i] != null) {
            	// if not null, check if value matches
                assertEquals("Value at index " + i + " does not match", data[i], result[i].doubleValue(), 0.001);
            } else {
            	// Fail if any element is unexpectedly null
                fail("Element at index " + i + " is unexpectedly null");
            }
        }
     }
     
     @Test
     public void CreateNumberArray_nullData() {
    	 //Null not permitted, Expecting an IllegalArgumentException when null is provided
         try {
             DataUtilities.createNumberArray(null);
             fail("Null input should throw InvalidParameterException");
         } catch (InvalidParameterException e) {
             // Expected exception
         } catch (Exception e) {
        	 fail("Null input should threw "+ e +" instead of InvalidParameterException");
         }
     }
	 
    
	 @Test
	 public void CreateNumberArray_emptyArray() {
		// Empty array, expects an empty array result
		 double[] emptyData = {};
	     Number[] result = DataUtilities.createNumberArray(emptyData);
	     assertEquals("Empty array", 0, result.length);
	 }
	 
	 @Test
	 public void CreateNumberArray_invalidData() {
	    // Non-double array, expects InvalidParamaterException
		 double[] charData = {'a', 'b','c'};
		 DataUtilities.createNumberArray(charData);
		 
		 try {
	         DataUtilities.createNumberArray(charData);
	         fail("Non-double input should throw InvalidParameterException");
	     } catch (InvalidParameterException e) {
	         // Expected exception
	     }
	 }
    @Test
    public void CreateNumberArray_validLargeData() {
    	// Valid large data, expecting a non-null result  with correct values
        double[] validLargeData = {1.1e20, 2.5e30,3.0e25, 4.8e18};
        Number[] result = DataUtilities.createNumberArray(validLargeData);

        assertNotNull(result); //check array is not null
        assertEquals(validLargeData.length, result.length); //check array is correct length
        
        for (int i = 0; i < validLargeData.length; i++) { // check each index of the array
            if (result[i] != null) {
            	// if not null, check if value matches
                assertEquals("Value at index " + i + " does not match", validLargeData[i], result[i].doubleValue(), 0.001);
            } else {
            	// Fail if any element is unexpectedly null
                fail("Element at index " + i + " is unexpectedly null");
            }
        }
    }
    
    @Test
    public void CreateNumberArray_validSmallData() {
    	// Valid small data, expecting a non-null result  with correct values
        double[] validSmallData = {1.1e-20, 2.5e-30,3.0e25, 4.8e-18};
        Number[] result = DataUtilities.createNumberArray(validSmallData);

        assertNotNull(result); //check array is not null
        assertEquals(validSmallData.length, result.length); //check array is correct length
        
        for (int i = 0; i < validSmallData.length; i++) { // check each index of the array
            if (result[i] != null) {
            	// if not null, check if value matches
                assertEquals("Value at index " + i + " does not match", validSmallData[i], result[i].doubleValue(), 0.001);
            } else {
            	// Fail if any element is unexpectedly null
                fail("Element at index " + i + " is unexpectedly null");
            }
        }
    }
    
    // createNumberArray2D() tests
    @Test
    public void CreateNumberArray2D_validData() {
    	// Valid 2D data, expecting a non-null result with correct values
        double[][] validData = {{1.1, 2.1}, {3.2, 4.2}};
        Number[][] result = DataUtilitiesTest.createNumberArray2D(validData);
        //check the array is not null
        assertNotNull(result);
        assertEquals(validData.length, result.length);
        // Check each element in the 2D array
        for (int i = 0; i < validData.length; i++) {
            for (int j = 0; j < validData[i].length; j++) {
            	if (result[i][j] != null) {//if array is not null, check if value matches
            		assertEquals(validData[i][j], result[i][j].doubleValue(), 0.001);
            	} else {
            		// Fail if any element is unexpectedly null
                    fail("Element at index " + "["+i+"]"+"["+j +"]"+ " is unexpectedly null");
                }
                
            }
        }
    }

    @Test
    public void CreateNumberArray2D_nullData() {
    	//Null not permitted, Expecting an IllegalArgumentException when null is provided
        try {
            DataUtilitiesTest.createNumberArray2D(null);
            fail("Expected InvalidParameterException, but no exception was thrown");
        } catch (InvalidParameterException e) {
            // Expected exception
        } catch (Exception e) {
       	 fail("Null input should threw "+ e +" instead of InvalidParameterException");
        }
    }
    
    @Test
    public void CreateNumberArray2D_emptyData() {
    	// Empty array, expects an empty array result
        double[][] emptyData = {};
        Number[][] result = DataUtilities.createNumberArray2D(emptyData);
        assertEquals("Empty array", 0, result.length);
    }

    @Test
    public void CreateNumberArray2D_invalidData() {
    	// Invalid 2D data, expecting an InvalidParameterException
        double[][] invalidData = {{1.0}, {2.0, 3.0}};
        try {
            DataUtilitiesTest.createNumberArray2D(invalidData);
            fail("Expected InvalidParameterException, but no exception was thrown");
        } catch (InvalidParameterException e) {
            // Expected behavior
        }
    }

    @Test
    public void CreateNumberArray2D_validLargeData() {
    	// Valid large 2D data, expecting a non-null result with correct matching values
        double[][] validLargeData = {{1.1e20, 2.5e30},{3.0e25, 4.8e18}};
        Number[][] result = DataUtilities.createNumberArray2D(validLargeData);
        assertNotNull(result); //check array is not null
        assertEquals(validLargeData.length, result.length); //check array is correct length
        
     // Check each element in the 2D array
        for (int i = 0; i < validLargeData.length; i++) { 
            for (int j = 0; j < validLargeData[i].length; j++) {
            	if (result[i][j] != null) {
            		// if not null, check if value matches
            		assertEquals(validLargeData[i][j], result[i][j].doubleValue(), 0.001);
            	} else {
            		// Fail if any element is unexpectedly null
                    fail("Element at index " + "["+i+"]"+"["+j +"]"+ " is unexpectedly null");
                }
                
            }
        }
    }
    
    @Test
    public void CreateNumberArray2D_validSmallData() {
    	// Valid small 2D data, expecting a non-null result with correct matching values
        double[][] validSmallData = {{1.1e-20, 2.5e-30},{3.0e25, 4.8e-18}};
        Number[][] result = DataUtilities.createNumberArray2D(validSmallData);
        assertNotNull(result); //check array is not null
        assertEquals(validSmallData.length, result.length);//check array is correct length
        
     // Check each element in the 2D array
        for (int i = 0; i < validSmallData.length; i++) {
            for (int j = 0; j < validSmallData[i].length; j++) {
            	if (result[i][j] != null) { 
            		// if not null, check if value matches
            		assertEquals(validSmallData[i][j], result[i][j].doubleValue(), 0.001);
            	} else {
            		// Fail if any element is unexpectedly null
                    fail("Element at index " + "["+i+"]"+"["+j +"]"+ " is unexpectedly null");
                }
                
            }
        }
    }

	 //calculateRowTotal() tests
	 
    //Test for calculating sum with a null object
	 @Test
	 public void calculateRowTotalWithNullDataObject() {
	     try {
	         // try block for passing in null object
	         DataUtilities.calculateRowTotal(null, 0);
	         fail("Expected NullPointerException");
	     } catch (NullPointerException e) {
	         // verify that NullPointerException is caught
	     }
	 }
	 
	 //Test for calculating sum of two row values
	 @Test
	    public void calculateRowTotalForTwoValues() {
	        // setup
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() { //mock object with two values
	            {
	                one(values).getColumnCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue(7.5));
	                one(values).getValue(0, 1);
	                will(returnValue(2.5));
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0);

	        //verify
	        assertEquals(10.0, result, 0.0001);
	    }
	 
	 //Test for sum calculation with invalid input (0)
	 @Test
	    public void calculateRowTotalWithZeroInput() {
	        // setup
	        Mockery mockingContext = new Mockery();
	        final Values2D values = mockingContext.mock(Values2D.class);
	        
	        //mock object has empty object
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getColumnCount();
	                will(returnValue(0)); 
	            }
	        });
	        double result = DataUtilities.calculateRowTotal(values, 0);
	        // verify result = 0
	        assertEquals(0.0, result, 0.0001);
	    }
	 
	 //Test for sum calculation with an empty value in row
	 @Test
	 public void calculateRowTotalWithEmptyRow() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() { //mock object with one empty value
	         {
	             one(values).getRowCount();
	             will(returnValue(1)); 
	             one(values).getColumnCount();
	             will(returnValue(3)); 
	             allowing(values).getValue(0, 0);
	             will(returnValue(0.0)); 
	             allowing(values).getValue(0, 1);
	             will(returnValue(null)); 
	             allowing(values).getValue(0, 2);
	             will(returnValue(0.0)); 
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0); 

	     // verify
	     assertEquals(0.0, result, 0.0001); 
	 }
	 
	 //Test for sum calculation with different types, like ints, doubles, floats
	 @Test
	 public void calculateRowTotalWithDifferentDataTypes() {
	     // setup
	     Mockery mockingContext = new Mockery(); 
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() { //mock object with different types of values
	         {
	             one(values).getRowCount();
	             will(returnValue(1)); 
	             one(values).getColumnCount();
	             will(returnValue(3)); 
	             allowing(values).getValue(0, 0);
	             will(returnValue(3)); 
	             allowing(values).getValue(0, 1);
	             will(returnValue(2.5)); 
	             allowing(values).getValue(0, 2);
	             will(returnValue(4.5f));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0); 

	     // verify
	     assertEquals(10.0, result, 0.0001);
	 }

	 //Test for sum calculation with values for several rows	 
	 @Test
	 public void calculateRowTotalWithMultipleRows() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() { //mock object with several values
	         {
	             one(values).getRowCount();
	             will(returnValue(3)); 
	             one(values).getColumnCount();
	             will(returnValue(3)); 
	             allowing(values).getValue(0, 0);
	             will(returnValue(3.5)); 
	             allowing(values).getValue(0, 1);
	             will(returnValue(2.0));
	             allowing(values).getValue(0, 2);
	             will(returnValue(4.5)); 
	             allowing(values).getValue(1, 0);
	             will(returnValue(1.5)); 
	             allowing(values).getValue(1, 1);
	             will(returnValue(2.5)); 
	             allowing(values).getValue(1, 2);
	             will(returnValue(3.5)); 
	             allowing(values).getValue(2, 0);
	             will(returnValue(0.5)); 
	             allowing(values).getValue(2, 1);
	             will(returnValue(1.0)); 
	             allowing(values).getValue(2, 2);
	             will(returnValue(1.5)); 
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 1); 

	     // verify
	     assertEquals(7.5, result, 0.0001); 
	 }
	 
	 //Test for row calculation with one null row value 
	 @Test
	 public void calculateRowTotalWithMissingValues() {
	     // setup
	     Mockery mockingContext = new Mockery(); //creating mock object with null value
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(1)); 
	             one(values).getColumnCount();
	             will(returnValue(3)); 
	             allowing(values).getValue(0, 0);
	             will(returnValue(3.5)); 
	             allowing(values).getValue(0, 1);
	             will(returnValue(null)); 
	             allowing(values).getValue(0, 2);
	             will(returnValue(4.5)); 
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0); 
	     // verify
	     assertEquals(8.0, result, 0.0001);
	 }
	 
	//Test for calculating the sum of invalid values (strings)
	 @Test
	 public void calculateRowTotalForInvalidValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 one(values).getColumnCount();
	                will(returnValue(2));
	                one(values).getValue(0, 0);
	                will(returnValue("a"));
	                one(values).getValue(0, 1);
	                will(returnValue("b"));
	         }
	     });
	     
	     try {
	         DataUtilities.calculateRowTotal(values, 0);
	         fail("Expected InvalidParameterException");
	     } catch (InvalidParameterException e) {
	         // verify that InvalidParameterException is caught
	     
	 } catch (IllegalStateException e) {
    	 fail("Expected InvalidParameterException (not IllegalStateException)");
     }
	     
	 }

	 //getCumulativePercentages() tests
	 
	 //Test for regular testing of percentage calculations with expected values
	 @Test
	 public void getCumulativePercentagesWithPositiveValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final KeyedValues data = mockingContext.mock(KeyedValues.class);
	     
	     //creating mock object with 3 keys and 3 values
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(data).getItemCount();
	             will(returnValue(3));
	             allowing(data).getKey(0);
	             will(returnValue(0));
	             allowing(data).getKey(1);
	             will(returnValue(1));
	             allowing(data).getKey(2);
	             will(returnValue(2));
	             allowing(data).getValue(0);
	             will(returnValue(20));
	             allowing(data).getValue(1);
	             will(returnValue(30));
	             allowing(data).getValue(2);
	             will(returnValue(40));
	         }
	     });
	     
	     KeyedValues result = DataUtilities.getCumulativePercentages(data);
	     
	     //create arrays for comparison
	     int[] KeysNum = new int[] {0, 1, 2};
	     double[] ValuesNum = new double[] {0.2, 0.6, 1.0}; 
	     // verify 
	     assertEquals(data.getItemCount(), result.getItemCount());
	     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
	    	 assertEquals(KeysNum[i], result.getKey(i));
	    	 assertEquals(ValuesNum[i], result.getValue(i));
	     }
	 }
	 
	 //Test same as previous (withPositiveValues) but with negative values
	 @Test
	 public void getCumulativePercentagesWithNegativeValues() {
	     // setup
	     Mockery mockingContext = new Mockery(); 
	     final KeyedValues data = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() { //creating mock object
	         {
	             allowing(data).getItemCount(); //values in KeyedValues are negative
	             will(returnValue(3));
	             allowing(data).getKey(0);
	             will(returnValue(0));
	             allowing(data).getKey(1);
	             will(returnValue(1));
	             allowing(data).getKey(2);
	             will(returnValue(2));
	             allowing(data).getValue(0);
	             will(returnValue(-5));
	             allowing(data).getValue(1);
	             will(returnValue(-10));
	             allowing(data).getValue(2);
	             will(returnValue(-15));
	         }
	     });

	     KeyedValues result = DataUtilities.getCumulativePercentages(data);
	     int[] KeysNum = new int[] {0, 1, 2}; //expected Keys
	     double[] ValuesNum = new double[] {0.2, 0.5, 1.0}; //expected Values
	     // verify
	     assertEquals(data.getItemCount(), result.getItemCount());
	     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
	    	 assertEquals(KeysNum[i], result.getKey(i));
	    	 assertEquals(ValuesNum[i], result.getValue(i));
	     }
	 }

	 //Test with null object as KeyedValues input
	 @Test
	    public void getCumulativePercentagesWithNullDataObject() {
	        try {
	            // try null object
	            DataUtilities.getCumulativePercentages(null);
	            fail("Expected IllegalArgumentException");
	        } catch (IllegalArgumentException e) {
	            // verify IllegalArgumentException 
	        }
	        
	        
	    }
	 
	 //Test with a single value as KeyedValues input 
	 @Test
	 public void getCumulativePercentagesWithSingleValue() {
	     // setup
	     Mockery mockingContext = new Mockery(); //creating mock object
	     final KeyedValues data = mockingContext.mock(KeyedValues.class);
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(data).getItemCount(); //single value
	             will(returnValue(1));
	             allowing(data).getKey(0);
	             will(returnValue(0));
	             allowing(data).getValue(0);
	             will(returnValue(1));
	         }
	     });
	     KeyedValues result = DataUtilities.getCumulativePercentages(data);
	     int[] KeysNum = new int[] {0}; //expected Keys
	     double[] ValuesNum = new double[] {1.0}; //expected Values
	     // verify
	     assertEquals(data.getItemCount(), result.getItemCount()); 
	     for (int i = 0; i < data.getItemCount(); i++) { //for loop to compare expected and actual
	    	 assertEquals(KeysNum[i], result.getKey(i));
	    	 assertEquals(ValuesNum[i], result.getValue(i));
	     }
	 }
	 
	//Test with an invalid value as KeyedValues input 
		 @Test
		 public void getCumulativePercentagesWithInvalidValue() {
		     // setup
		     Mockery mockingContext = new Mockery(); //creating mock object
		     final KeyedValues data = mockingContext.mock(KeyedValues.class);
		     mockingContext.checking(new Expectations() {
		         {
		             allowing(data).getItemCount(); //invalid
		             will(returnValue(1));
		             allowing(data).getKey(0);
		             will(returnValue("a"));
		             allowing(data).getValue(0);
		             will(returnValue("b"));
		         }
		     });
		     // verify
		     try {
		         DataUtilities.getCumulativePercentages(data);
		         fail("Expected InvalidParameterException");
		     } catch (InvalidParameterException e) {
		         // verify that InvalidParameterException is caught
		     } catch (IllegalStateException e) {
		    	 fail("Expected InvalidParameterException (not IllegalStateException)");
		     }
		 }

}
