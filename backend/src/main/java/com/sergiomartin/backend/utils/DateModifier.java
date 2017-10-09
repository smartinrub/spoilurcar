package com.sergiomartin.backend.utils;


/**
 * This class is to modify date format
 * @author Sergio Martin Rubio
 * @date 09-Oct-2017
 */
public class DateModifier {
	/**
	 * This method swap day and month positions
	 * eg: 01/14/1991 to 14/01/1991
	 * 
	 * @param date to change
	 * @return date with new format
	 */
	public static String swapDayMonth(String date) {
		String month = date.substring(0, 2);
		String day = date.substring(3, 5);
		String newDate = new String(month + "/" + day + "/" + date.substring(6));
	
		return newDate;
	}
}
