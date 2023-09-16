package com.finzly.FxTrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.FxTrading.entity.FxExchangeInfo;
import com.finzly.FxTrading.exception.CustomException;
import com.finzly.FxTrading.dao.CurrencyDao;
import com.finzly.FxTrading.dao.FxExchangeDao;
import com.finzly.FxTrading.entity.FxExchangeInfo;
import com.finzly.FxTrading.utility.TradeAmountConversion;

@Service
public class FxExchangeService {
	@Autowired
	CurrencyDao currencydao;
	@Autowired
	FxExchangeDao  fxexchangedao;
	@Autowired
	TradeAmountConversion tradeamountconversion;
	
	/* This method executes a trade operation, converting the amount and saving the trade information in the database.
    * It checks if the currency pair is available and if the amount is not negative.
    * Throws RuntimeException in case of issues.
    */
	public void doTrade(FxExchangeInfo fxexchange) throws RuntimeException
	{
		Object  checkCurrencyObj= currencydao.checkCurrencyPairs(fxexchange.getCurrencyPairName());
		if(checkCurrencyObj==null)
			{
				CustomException.CurrencyPairNotAvailableException();
			}
		
        else if(fxexchange.getAmount()<0)
		{
			CustomException.NegativeAmountException();
	    }
		double convertedamount=tradeamountconversion.convertFromTo(fxexchange.getCurrencyPairName(),fxexchange.getAmount());
		fxexchange.setAmount(convertedamount);
		fxexchangedao.doTrade(fxexchange);	
	 }
	
	
	/*
	 *   This method retrieves a list of booked trades.
     * If the list is empty, it returns a message indicating that the trade list is empty.
     */
	public Object getBookedTrades()
	{
		List <FxExchangeInfo> tradelist=fxexchangedao.getBookedTrades();
		if(tradelist.isEmpty())
		{
			return "your trade list is Empty";
		}
		else 
		{
			return tradelist;
	}
			
}
}
