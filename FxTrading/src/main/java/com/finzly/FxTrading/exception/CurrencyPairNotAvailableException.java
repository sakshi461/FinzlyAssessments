package com.finzly.FxTrading.exception;

public class CurrencyPairNotAvailableException extends RuntimeException{
	public CurrencyPairNotAvailableException()  {
		super("This Currency PAir is Not available");
	}
}
