package com.finzly.FxTrading.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CurrencyInfo {
	@Id
	private String CurrencyPairName;
	private double ConversionRate;
	public CurrencyInfo()
	{
		super();
	}
	//Constructor to initialize the CurrencyInfo object with currency pair details
   public CurrencyInfo(String currencyPairName, double conversionRate) {
	     super();
		CurrencyPairName = currencyPairName;
		ConversionRate = conversionRate;
	}
	public String getCurrencyPairName() {
		return CurrencyPairName;
	}
	public void setCurrencyPairName(String currencyPairName) {
		CurrencyPairName = currencyPairName;
	}
	
	public void setConversionRate(double conversionRate) {
		ConversionRate = conversionRate;
	}
	public double getConversionRate() {
		return ConversionRate;
	}
	
	@Override
	public String toString() {
		return "CurrencyInfo [CurrencyPairName=" + CurrencyPairName + ", ConversionRate=" + ConversionRate + "]";
	}
	
	
	
}
