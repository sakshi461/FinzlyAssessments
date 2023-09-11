package com.finzly.FXTrading.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrading.Model.FxTrade;
import com.finzly.FXTrading.Service.TradeService;

@RestController
@RequestMapping("Trade")
public class TradeController {
	@Autowired
	private TradeService tradeservice;

	/**
	 * Endpoint for booking a trade Specify the HTTP method and endpoint path
	 */
	@PostMapping("bookTrade")
	public ResponseEntity<Map<String, String>> bookTrade(@RequestBody FxTrade trade) {
		return tradeservice.bookTrade(trade);
	}

	/**
	 * Endpoint for retrieving trades Specify the HTTP method and endpoint path
	 */
	@GetMapping("getTrades")
	public ResponseEntity<Object> getTrade() {
		return tradeservice.getTrades();
	}

}
