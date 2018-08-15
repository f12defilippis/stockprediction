package it.f12.stockprediction.util;

import java.util.List;

public class MathUtil {

	public static Double average(List<Double> values)
	{
		Double sum = 0.0;
		for(Double value : values)
		{
			sum+=value;
		}
		return sum/values.size();
		
	}
	
}
