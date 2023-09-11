package com.finzly.FXTrading.Model;

public class FxTrade {
	/*
	 * attributes
        */
	protected static double Rate = 66.00;
	private static int count = 0;
	private int tradeNo;
	protected String CustomerName;
	protected String CurrencyPair;
	protected double Amount;
	private double ConvertedAmount;

	// Default constructor
	public FxTrade()
	{
        }
    // Parameterized constructor
	public FxTrade(String CustomerName, String CurrencyPair, double Amount, double ConvertedAmount) 
	{

		this.tradeNo = ++count;
		this.CustomerName = CustomerName;
		this.CurrencyPair = CurrencyPair;
		this.Amount = Amount;
		this.ConvertedAmount = ConvertedAmount;
        }

	// getters and setters
	public String getName() 
	{
		return CustomerName;
	}

	public void setName(String name)
	{
		this.CustomerName = name;
	}

	public String getCurrencyPair()
	{
		return CurrencyPair;
	}

	public void setCurrencyPair(String currencyPair)
	{
		this.CurrencyPair = currencyPair;
	}

	public double getAmount() 
	{
		return Amount;
	}

	public void setAmount(double amount) {
		this.Amount = amount;
	}

	public static double getRate()
	{
		return Rate;
	}

	public double getConvertedAmount()
	{
		return ConvertedAmount;
	}

	public void setConvertedAmount(double convertedAmount) 
	{
		this.ConvertedAmount = convertedAmount;
	}

	// toString method overriding
	@Override
	public String toString()
	{
	return tradeNo + "\t" + CurrencyPair.toUpperCase() + "\t"
	+ CustomerName + "\t" + ConvertedAmount + "\t"
	+ getRate();
	}

}
