package com.finzly.FxTrading.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FxTrading.service.CurrencyService;

@RestController
@RequestMapping("currency")
public class CurrencyController {
	
Logger logger = LoggerFactory.getLogger(CurrencyController.class);

@Autowired
CurrencyService currencyservice;

	//Endpoint to add a new currency exchange pair with the specified conversion rate.
	@PostMapping("currency-exchange/{conversionrate}")
    public String addCurrencyExchangePair(@PathVariable String conversionrate)
    {
		try {
			//Call the addCurrencyExhange method of the CurrencyService 
			currencyservice.addCurrencyExchangePair(conversionrate);
			
			//If successful ,return a success message
			return "Currency Pair added Successfully";
			
		}
		catch(RuntimeException e){
			
			//If a Exception of type Runtime Exception is thrown, catch it 
			e.printStackTrace();
			//return the exception message as a response
			return e.getMessage();			
		}
   }
	
	/*
	 *  Endpoint to retrieve all currency pairs.
	 */
	@GetMapping("getAllCurrencyPairs")
	public Object getAllCurrencyPairs() {
		logger.info("Currencypair List is"+currencyservice.getAllCurrencyPairs());
		return currencyservice.getAllCurrencyPairs();
	}
	//Endpoint to update an existing currency pair.
    @PutMapping("updateExistingCurrency/{currency}")
	public void UpdateExistingCurrencyPair(@PathVariable String currency)
	{
		currencyservice.UpdateExistingCurrencyPair(currency);
	}
}
