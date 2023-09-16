package com.finzly.FxTrading.exception;

public class CustomException {
	public static void currencyPairAlreadyExists() {
		throw new CurrencyPairAlreadyExists();
	}

	public static void ImproperCurrencyPairFormatException() {
		throw new ImproperCurrencyPairFormatException();
	}

	public static void CurrencyPairNotAvailableException() {
		throw new CurrencyPairNotAvailableException();
	}

	public static void NegativeAmountException() {
		throw new NegativeAmountException();
	}	

}
