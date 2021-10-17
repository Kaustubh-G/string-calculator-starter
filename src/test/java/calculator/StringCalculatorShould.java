package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class StringCalculatorShould {

	private StringCalculator stringCalculator;
	
	@BeforeEach
    public void init()
	{
		stringCalculator = new StringCalculator();
	}
	
	@Test
    public void empty_string_should_return_0() 
	{
        assertEquals(0, stringCalculator.add(""));
    }
    

    @Test
    public void string_with_single_number_should_return_number_as_int() 
    {
        assertEquals(1, stringCalculator.add("1"));
    }
    
    
    @Test
    public void string_with_two_numbers_comma_delimited_should_return_sum()
    {
        assertEquals(10+20, stringCalculator.add("10,20"));
    }
    
    @Test
    public void String_with_unknown_amout_of_numbers()
    {
    	assertEquals(3+6+15+18+46+33, stringCalculator.add("3,6,15,18,46,33"));
    }
    
    @Test
    public void string_with_new_lines_between_numbers()
    {
        assertEquals(3, stringCalculator.add("1\n2"));
    }
    
    @Test
    public void string_with_different_delimiters()
    {
    	assertEquals(3+6+15, stringCalculator.add("//;\n3;6;15") );
    }
    
    @Test
    public void string_with_single_negative_number_should_throw_an_exception()
    {
    	assertThrows(RuntimeException.class, ()->
    		
    		stringCalculator.add("3,-6,9,4")
    	);
    }
    
    @Test
    public void string_with_multiple_negative_number_should_throw_an_exception()
    {
    		RuntimeException rex= null;
    		try{
    			stringCalculator.add("3,6,-9,-4,15");
    		}catch(RuntimeException e)
    		{
    			rex=e;
    		}
    	
    	assertNotNull(rex);
    	assertEquals("negatives not allowed: [-9, -4]", rex.getMessage());
    	
    }
}
