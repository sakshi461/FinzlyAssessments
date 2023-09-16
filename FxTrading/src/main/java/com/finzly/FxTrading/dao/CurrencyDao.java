package com.finzly.FxTrading.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.FxTrading.entity.CurrencyInfo;
import com.finzly.FxTrading.service.CurrencyService;

@Repository
public class CurrencyDao {

	@Autowired
	SessionFactory sessionFactory;
	
Logger logger=LoggerFactory.getLogger(CurrencyService.class);
	//1
	public String addCurrencyExchangePair(CurrencyInfo currencyinfo)
	{
		Session session =sessionFactory.openSession();
		session.save(currencyinfo);
		session.beginTransaction().commit();
		logger.info("Currency Pair is Added"+currencyinfo);
		return "Currency Pair Added";
		
	}
	//2
	public List<CurrencyInfo>getCurrencyPairRate(String currencypair)
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyInfo.class);
		criteria.add(Restrictions.eq("currencyPair", currencypair));
		return criteria.list();

	}
	//3
	public Object checkCurrencyPairs(String currencypair) {
		Session session =sessionFactory.openSession();
	    Criteria criteria = session.createCriteria(CurrencyInfo.class);
	    criteria.add(Restrictions.eq("CurrencyPairName",currencypair));
	    if(criteria.list().size()!=0)
	    {
	    	logger.info("Curreny pair list is "+criteria.list());
	    	return criteria.list();
	    }
	    else
	    {
	    	logger.info("Currency-pair list is empty");
	        return null;
	    }
	
	
	}
	//4
	public List<CurrencyInfo>getAllCurrencyPairs(){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CurrencyInfo.class);
		logger.info("currency-pair  list is" + criteria.list());
		return criteria.list();
	
	}
	//5
	public String UpdateCurrencyExchangePair(CurrencyInfo currencyinfo)
	{
		Session session = sessionFactory.openSession();
		session.update(currencyinfo);
		Criteria criteria = session.createCriteria(CurrencyInfo.class);
		logger.info("currency-pair  is updated " + criteria.list());
		return "currency pair updated";
	
	}

	

}
