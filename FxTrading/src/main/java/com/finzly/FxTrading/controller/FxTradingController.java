package com.finzly.FxTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FxTrading.entity.FxExchangeInfo;
import com.finzly.FxTrading.service.FxExchangeService;
@RestController
@RequestMapping("trade")
public class FxTradingController {

	@Autowired
	FxExchangeService fxExchangeservice;
	
	/*
	 * @Author Sakshi Patel 
	 *   This endpoint allows clients to perform a trade operation.
     * It takes a JSON request body containing trade information and returns a message.
     *
	 */
	@PostMapping("dotrade")
	public String doTrade(@RequestBody FxExchangeInfo fxexchange)
	{
		try {
			fxExchangeservice.doTrade(fxexchange);
			return "Trade Booked Successfully";
			}
		catch(RuntimeException exception)
		{
			exception.printStackTrace();
			return exception.getMessage();
        }
	}

	
	/*
	 *      This endpoint allows clients to retrieve a list of booked trades.
     *
	 */
	@GetMapping("TradeList")
	public Object getBookedTrades() {
		return fxExchangeservice.getBookedTrades();
	}
}
