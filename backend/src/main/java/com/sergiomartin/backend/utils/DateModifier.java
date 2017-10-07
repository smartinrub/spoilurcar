package com.sergiomartin.backend.utils;

public class DateModifier {
	public static String swapDayMonth(String date) {
		String month = date.substring(0, 2);
		String day = date.substring(3, 5);
		String newDate = new String(month + "/" + day + "/" + date.substring(6));
	
		return newDate;
	}
}
