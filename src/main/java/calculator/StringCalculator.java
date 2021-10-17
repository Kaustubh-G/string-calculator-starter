package calculator;

import java.util.List;
import java.util.ArrayList;

class StringCalculator {

	
	//refactoring for new lines between numbers
    private String delimiter = ",|\n";
    
    
    public int add(String input)
    {
    	String[] nums = input.split(delimiter);
    	String inputWithoutDelimiter = input;
    	
        if(isEmpty(input))
        {
        	return 0;
        }
        
        if(input.startsWith("//"))
    	{
    		int delimiterIndex= input.indexOf("//")+2;
    		delimiter = input.substring(delimiterIndex, delimiterIndex+1);
    		inputWithoutDelimiter=input.substring(input.indexOf("\n"));
    		return differentDelimiter(inputWithoutDelimiter, delimiter);
    	}   
        
        throwExceptionForNegativeNumbers(nums);
        
        if(input.length() ==1)
        {
        	return stringtoint(input);
        }
        
        if(input.length() >2)
        {
        	return sumOfUnknownAmoutOfNumbers(input,nums);
        }
    	else
        {
    		return sumOfTwoNumbers(nums[0], nums[1]);
        }
 
    }
    
	//refactoring for empty input
    private boolean isEmpty(String input)
    {
    	return input.isEmpty();
    }
    
    //refactoring for single input
    private int stringtoint(String input)
    {
    	return Integer.parseInt(input);
    }
    
    //refactoring for two inputs delimited with comma
    private int sumOfTwoNumbers(String num1, String num2)
    {
    	return Integer.parseInt(num1) + Integer.parseInt(num2);
    }
    
    //refactoring for unknown amount of numbers
    private int sumOfUnknownAmoutOfNumbers(String input, String[] nums) {
    	int returnValue=0;
    	
    	for (String number : nums) {
            if (!number.trim().isEmpty()) { 
                returnValue += Integer.parseInt(number);
            }
        }
    	return returnValue;
	}
    
    //refactoring for different delimiters
    private int differentDelimiter(String input, String delimiter) 
    {
		int returnVal=0;
		String[] numArray= input.split(delimiter);
		ArrayList negativeNums = new ArrayList();
		
		for (String number : numArray)
		{
			if(!number.trim().isEmpty())
			{
				returnVal += Integer.parseInt(number.trim());;
			}
		}

		return returnVal;
	}
    
    //refactoring for negative number's exception
  	private void throwExceptionForNegativeNumbers(String[] nums) {
  		
  		List l = new ArrayList();
          for(int i=0;i<nums.length;i++)
          {
          	if(Integer.parseInt(nums[i])<0)
          	{
          		l.add(nums[i]);
          	}
          }
          if(l.size()>0)
          {
          	throw new RuntimeException("negatives not allowed: " + l.toString());
          }
  	}

}
