package com.finzly.FxTrading.exception;

public class CurrencyPairAlreadyExists extends RuntimeException {
	public CurrencyPairAlreadyExists()
	{
		super("Currency Pair Already Exists");
	}
	
}
