package com.finzly.FxTrading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.FxTrading.dao.CurrencyDao;
import com.finzly.FxTrading.entity.CurrencyInfo;
import com.finzly.FxTrading.exception.CustomException;

@Service
public class CurrencyService {
@Autowired 
CurrencyDao currencydao;

   //This method adds a new currency exchange pair with the specified conversion rate.
   public void addCurrencyExchangePair(String conversionrate) {
	
	String[] splitCurrencyPair = conversionrate.split("=");
	Double convertedRate;
	
	if(splitCurrencyPair.length==2)
	{
			String currencyPair=splitCurrencyPair[0];
			String rate=splitCurrencyPair[1];
			
		   Object checkpair=currencydao.checkCurrencyPairs(currencyPair);
		   if(checkpair==null)
		   {
		     CurrencyInfo currencyinfo=new CurrencyInfo();
		     try {
		    		   convertedRate=Double.parseDouble(conversionrate);
		     }
		    catch(NumberFormatException e) {
		    	  throw e;
		    }
		    	   
		   if(convertedRate<0)
		   {
			   CustomException.NegativeAmountException();
		   }
		   currencyinfo.setConversionRate(convertedRate);
		   currencyinfo.setCurrencyPairName(currencyPair);
		   String status=currencydao.addCurrencyExchangePair(currencyinfo);
	   }
	   else
	   {
		   CustomException.currencyPairAlreadyExists();
	   }
 }
 else
	{
	CustomException.ImproperCurrencyPairFormatException();
	}
}

	
	//This method retrieves all currency pairs.
    public Object getAllCurrencyPairs() {
		
	List<CurrencyInfo> currencyinfo=currencydao.getAllCurrencyPairs();
	if(currencyinfo.isEmpty())
	{
		return "The Currency list iS Empty";
	}
	else
	{
		return currencyinfo;
	}
	}

	//This method updates an existing currency exchange pair with the specified conversion rate.
    public void UpdateExistingCurrencyPair(String conversionrate) {
		String[] splitCurrencyPair=conversionrate.split("=");
		Double convertedRate;
		if(splitCurrencyPair.length==2)
		{
			String currencyPair=splitCurrencyPair[0];
			String rate=splitCurrencyPair[1];
			
			Object check=currencydao.checkCurrencyPairs(currencyPair);
			if(check!=null)
			{
			 CurrencyInfo currencyExchangerObj=new CurrencyInfo();
			 try {
				 convertedRate=Double.parseDouble(rate);
			}
			catch(NumberFormatException e) {
			 throw e;
			}
			if(convertedRate<0)
			{
				CustomException.NegativeAmountException();
			}
			currencyExchangerObj.setConversionRate(convertedRate);
			currencyExchangerObj.setCurrencyPairName(currencyPair);
			currencydao.UpdateCurrencyExchangePair(currencyExchangerObj);
			
			}
			else {
				CustomException.CurrencyPairNotAvailableException();
			}
		}
		else {
			CustomException.ImproperCurrencyPairFormatException();
		}
		
	}

	
	}
