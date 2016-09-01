package com.varunk.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberToCurrency {

	public static void main(String[] args) {
    		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(10)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(100)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(1000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(10000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(100000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(1000000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(10000000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(100000000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(1000000000)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(20000721236.70)));
		System.out.println("*** " + NumberToWords.convertToCurrency(new BigDecimal(-20000721236.70)));

	}

	public static String convertToCurrency(BigDecimal numberDouble){
		
	    //Remove Decimal
	    DecimalFormat dfD = new DecimalFormat("#.00"); 
	    long number = numberDouble.longValue();
	    String deceStr = dfD.format(Math.abs(numberDouble.remainder( BigDecimal.ONE ).doubleValue()));
		
	    if (number == 0) { 
	    	return "0"+deceStr; 
	    }

	    //Remove negative
	    String negative = "";
		  if(number < 0)
			  negative = "-";
	  
	    // pad with "0"
		  String snumber;
	    String mask = "00000000000";
	    DecimalFormat df = new DecimalFormat(mask);
	    snumber = df.format(Math.abs(number));

	    // XXnnnnnnnnn
	    int croreHun = Integer.parseInt(snumber.substring(0,2));
	    
	    // nnXXnnnnnnn
	    int crore = Integer.parseInt(snumber.substring(2,4));
	    
	    // nnnnXXnnnnn
	    int lakhs  = Integer.parseInt(snumber.substring(4,6));
	    
	    // nnnnnnXXnnn
	    int hundredThousands = Integer.parseInt(snumber.substring(6,8));
	    
	    // nnnnnnnnXXX
	    int thousands = Integer.parseInt(snumber.substring(8,11));
	    
	    String result = "";
	    
	    //Hundred Crore
	    if(croreHun > 0)
	    	result = croreHun + ",";
	    
	    //Crore
            if("".equals(result) && crore > 0)
	    	result = crore+",";
	    else if(!"".equals(result))
	    	result = result + snumber.substring(2,4) + ",";
	    
	    //Lakh
	    if("".equals(result) && lakhs > 0)
	    	result = lakhs+",";
	    else if(!"".equals(result))
	    	result = result + snumber.substring(4,6) + ",";
	    
	    //Thousand
	    if("".equals(result) && hundredThousands > 0)
	    	result = hundredThousands+",";
	    else if(!"".equals(result))
	    	result = result + snumber.substring(6,8) + ",";
	    
	    //Hundred
	    if("".equals(result) && thousands > 0)
	    	result = Integer.toString(thousands);
	    else if(!"".equals(result))
	    	result = result + snumber.substring(8,11);
	    
	    //Add negative and decimal
	    result = negative+result+deceStr;
	    
	    // remove extra spaces!
	    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
		
	}
	
}
