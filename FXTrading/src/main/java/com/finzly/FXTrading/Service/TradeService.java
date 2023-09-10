package com.finzly.FXTrading.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FXTrading.Model.FxTrade;

@Service
public class TradeService
{
	//list for string trades
	private static List<FxTrade> trades = new LinkedList<>();

	private static double ConvertedAmount;
	
	//Validation method
	public Map<String,String> isNull(FxTrade trade)
	{
		Map<String,String> responseresult = new HashMap<>();
		
		if(trade.getName()==null)
			responseresult.put("Customer_Name", "Customer name cannot be empty!");
		
		if(trade.getCurrencyPair()==null)
			responseresult.put("Currency_Pair", "Currency Pair cannot be empty!");
		
		if(!trade.getCurrencyPair().equalsIgnoreCase("USDINR"))
			responseresult.put("Currency_Pair", "Currency Pair should be 'USDINR' only!");
		
		if(trade.getAmount()<=0)
			responseresult.put("Amount", "Amount should be a Positve Number!");
		
		return responseresult;
			
	}
    
	
	//method for booking Trades
	public ResponseEntity<Map<String, String>> bookTrade(FxTrade trade)
	{
		Map<String,String> Traderesult = new HashMap<>();
		Traderesult = isNull(trade);
		
		if(!(Traderesult.isEmpty()))
		{
			Traderesult.put("Message","Trade not booked");   
            return ResponseEntity.badRequest().body(Traderesult);
		}
		
		//checking if result is empty or not
		if(Traderesult.isEmpty())
		{
			double amount = trade.getAmount();
			ConvertedAmount = amount * FxTrade.getRate();
			trade.setConvertedAmount(ConvertedAmount);
		
			FxTrade bookTrade = new FxTrade(trade.getName(), trade.getCurrencyPair().toUpperCase(), trade.getAmount(), trade.getConvertedAmount());
			trades.add(bookTrade);
			
			Traderesult.put("Message", "Trade for " + trade.getCurrencyPair() + " has been booked with rate of " + FxTrade.getRate() + ". The amount of Rs " + trade.getConvertedAmount() + " will be transferred in 2 working days to " + trade.getName());
            return ResponseEntity.ok().body(Traderesult);
		}
	
		
		Traderesult.put("Message","Trade not booked");
        return ResponseEntity.badRequest().body(Traderesult); 
	}
	
	//method for getting trades
	public ResponseEntity<Object> getTrades()
	{
		 if(trades.isEmpty())
		 {
             return ResponseEntity.badRequest().body("No Trade Information available");
	     }

	         return ResponseEntity.ok().body(trades);
    }



	
		
	
}
