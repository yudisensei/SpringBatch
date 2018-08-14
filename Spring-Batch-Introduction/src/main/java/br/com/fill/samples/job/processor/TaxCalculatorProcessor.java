package br.com.fill.samples.job.processor;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import br.com.fill.samples.entity.Transaction;
import br.com.fill.samples.entity.TransactionType;

public class TaxCalculatorProcessor implements ItemProcessor<Transaction, Transaction> {

	@Override
	public Transaction process(Transaction item) throws Exception {
		if(TransactionType.DEBIT.equals(item.getType())){
			item.setTax(new BigDecimal(0.1));
		} else {
			item.setTax(new BigDecimal(0.3));
		}
		// TODO Auto-generated method stub
		return item;
	}

}
