package com.mobilize.core.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateUtil {

	public static Date parseStringToDate(String target, String format) {
		DateFormat df = new SimpleDateFormat(format);
		Date result = null;
		try {
			result =  df.parse(target);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
