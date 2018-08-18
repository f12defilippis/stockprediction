package it.f12.stockprediction.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date dateInThePast(Date date, int howManyDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, (howManyDays * -1)); // minus number would decrement the days
		return cal.getTime();
	}

	public static Date dateInTheFuture(Date date, int howManyDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, (howManyDays)); // minus number would decrement the days
		return cal.getTime();
	}

	public static String format(Date date) {
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		return dt1.format(date);
	}
	
	public static Date format(String data) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (data == null || data.matches("0*\\.0*\\.0*"))
			return null;
		try {
			date = (Date) formatter.parse(data);
		} catch (ParseException e) {
			//System.out.println(e.getMessage());
		}
		return date;
	}

}
