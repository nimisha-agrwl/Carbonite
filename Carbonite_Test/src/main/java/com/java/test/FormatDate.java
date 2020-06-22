package com.java.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	
	//method to format date into any specified format.
	
public String date_converter(String input , String old_format , String new_format) {
		SimpleDateFormat sdf = new SimpleDateFormat(old_format); ////Using Date and SimpleDateFormat class
		Date d = null;
		String newDate = null;
		try {
			d = sdf.parse(input);  //creating Date object from string
		} catch (ParseException e) {	
			System.out.println("Invalid Date format : "+old_format);
			e.printStackTrace();
		}
		try {
			sdf.applyPattern(new_format);    //formatting to new format
			newDate = sdf.format(d);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Date format : "+new_format);
			e.printStackTrace();
		}		
		return newDate;
	}

	
	public static void main(String[] args) {
		FormatDate obj = new FormatDate();
		String inputFormat = "MM-dd-yyyy";
		String inputDate = "06-02-2020"; 
		
		String format1 = "MM/dd/yyyy";
		String result = obj.date_converter(inputDate,inputFormat,format1);
		System.out.println(" Date: "+ inputDate+" is converted into : "+result);

		String format2 = "MM:dd:YYYY";
		result = obj.date_converter(inputDate, inputFormat,format2);
		System.out.println(" Date: "+ inputDate+" is converted into : "+result);
		
		String format3 = "dd/MM/YYYY";
	    result = obj.date_converter(inputDate,inputFormat,format3);
		System.out.println(" Date: "+ inputDate+" is converted into : "+result);
		}

}
