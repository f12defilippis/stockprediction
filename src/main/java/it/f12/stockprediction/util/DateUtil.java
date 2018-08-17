package it.f12.stockprediction.util;

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
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
		return dt1.format(date);
	}

}
