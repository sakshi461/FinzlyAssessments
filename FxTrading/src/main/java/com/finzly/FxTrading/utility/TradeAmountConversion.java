package com.finzly.FxTrading.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.finzly.FxTrading.dao.CurrencyDao;
import com.finzly.FxTrading.entity.CurrencyInfo;
@Component
public class TradeAmountConversion {
@Autowired
CurrencyDao currencydao;
	
    // This utility method converts the given amount from one currency pair to another using the conversion rate.
    public double convertFromTo(String currencyPair,double amount)
	{
		List<CurrencyInfo> currencyPairList=currencydao.getCurrencyPairRate(currencyPair);
		double conversionRate=currencyPairList.get(0).getConversionRate();
		double convertedAmount=amount*conversionRate;
		return convertedAmount;
		
	}

}
