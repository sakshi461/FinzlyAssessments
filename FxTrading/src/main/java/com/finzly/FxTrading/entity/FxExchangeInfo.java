package com.finzly.FxTrading.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FxExchangeInfo {
   @Id
	@GeneratedValue(  strategy =GenerationType.AUTO )
    private  String CustomerTradeId;
	private double amount;
    private String CurrencyPairName;
    private String CustomerName;
    
    public FxExchangeInfo()
    {
    	super();
    }
    //Constructor to initialize the FxExchangeInfo object with trade details

	public FxExchangeInfo(String customerTradeId, double amount, String currencyPairName, String customerName) {
		super();
		CustomerTradeId = customerTradeId;
		this.amount = amount;
		CurrencyPairName = currencyPairName;
		CustomerName = customerName;
	}
	public String getCustomerId() {
		return CustomerTradeId;
	}
	public void setCustomerId(String customertradeId) {
		CustomerTradeId = customertradeId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCurrencyPairName() {
		return CurrencyPairName;
	}
	public void setCurrencyPairName(String currencyPairName) {
		CurrencyPairName = currencyPairName;
	}
	@Override
	public String toString() {
		return "FxExchangeInfo [CustomerId=" + CustomerTradeId + ", amount=" + amount + ", CurrencyPairName="
				+ CurrencyPairName + ", CustomerName=" + CustomerName + "]";
	}
	
}
