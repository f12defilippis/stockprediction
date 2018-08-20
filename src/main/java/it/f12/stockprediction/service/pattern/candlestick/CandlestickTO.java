package it.f12.stockprediction.service.pattern.candlestick;

import it.f12.stockprediction.entity.orm.Quote;

public class CandlestickTO {

	private Double up;
	private Double down;
	
	private String type;
	
	private Double upperShadow;
	private Double lowerShadow;

	private boolean longUpperShadow;
	private boolean longLowerShadow;
	
	private boolean shortUpperShadow;
	private boolean shortLowerShadow;
	
	
	private boolean longBody;
	private boolean shortBody;
	private boolean shorterBody;
	private boolean shortestBody;
	
	
	
	private boolean noShadow;
	
	public CandlestickTO(Quote quote, Double atr)
	{

		
		Double max = quote.getMaxValue();
		Double min = quote.getMinValue();
		Double open = quote.getOpenValue();
		Double close = quote.getValue();

		up = 0.0;
		down = 0.0;
		
		if(open >= close)
		{
			type = "BEARISH";
			up = open;
			down = close;
		}else
		{
			type = "BULLISH";
			up = close;
			down = open;
		}

		upperShadow = max - up;
		lowerShadow = down - min;
		
		
		
		longBody = Math.abs(open-close) > atr;
		shortBody = Math.abs(open-close) < atr/2.0;
		shorterBody = Math.abs(open-close) < atr/3.0;
		shortestBody = Math.abs(open-close) < atr/4.0;
		
		longUpperShadow = upperShadow > atr;
		longLowerShadow = lowerShadow > atr;

		shortUpperShadow = upperShadow < atr/2.0;
		shortLowerShadow = lowerShadow < atr/2.0;
		
		
		noShadow = upperShadow == 0.0 && lowerShadow == 0.0;
	}

	public Double getUp() {
		return up;
	}

	public void setUp(Double up) {
		this.up = up;
	}

	public Double getDown() {
		return down;
	}

	public void setDown(Double down) {
		this.down = down;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getUpperShadow() {
		return upperShadow;
	}

	public void setUpperShadow(Double upperShadow) {
		this.upperShadow = upperShadow;
	}

	public Double getLowerShadow() {
		return lowerShadow;
	}

	public void setLowerShadow(Double lowerShadow) {
		this.lowerShadow = lowerShadow;
	}

	public boolean isLongBody() {
		return longBody;
	}

	public void setLongBody(boolean longBody) {
		this.longBody = longBody;
	}

	public boolean isShortBody() {
		return shortBody;
	}

	public void setShortBody(boolean shortBody) {
		this.shortBody = shortBody;
	}

	public boolean isShorterBody() {
		return shorterBody;
	}

	public void setShorterBody(boolean shorterBody) {
		this.shorterBody = shorterBody;
	}

	public boolean isShortestBody() {
		return shortestBody;
	}

	public void setShortestBody(boolean shortestBody) {
		this.shortestBody = shortestBody;
	}

	public boolean isNoShadow() {
		return noShadow;
	}

	public void setNoShadow(boolean noShadow) {
		this.noShadow = noShadow;
	}

	public boolean isLongUpperShadow() {
		return longUpperShadow;
	}

	public void setLongUpperShadow(boolean longUpperShadow) {
		this.longUpperShadow = longUpperShadow;
	}

	public boolean isLongLowerShadow() {
		return longLowerShadow;
	}

	public void setLongLowerShadow(boolean longLowerShadow) {
		this.longLowerShadow = longLowerShadow;
	}

	public boolean isShortUpperShadow() {
		return shortUpperShadow;
	}

	public void setShortUpperShadow(boolean shortUpperShadow) {
		this.shortUpperShadow = shortUpperShadow;
	}

	public boolean isShortLowerShadow() {
		return shortLowerShadow;
	}

	public void setShortLowerShadow(boolean shortLowerShadow) {
		this.shortLowerShadow = shortLowerShadow;
	}
	
	
	
	
	
}
