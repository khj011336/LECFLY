package com.LECFLY.LF.log;

import org.apache.ibatis.transaction.TransactionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Service
public class CreatorAOP {
	public void test() {
		System.out.println("test AOP");
	}
 public interface Transaction {
	 TransactionStatus getTransaction(TransactionDefinition defi) throws TransactionException;
	 void commit(TransactionStatus status) throws TransactionException;
	 void rollback(TransactionStatus status) throws TransactionException;
 }
}
