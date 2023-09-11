package entities;

import exception.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		if(amount > balance) {
			throw new DomainException("Not enough balance");
		}
		else {
			withdraw(amount);
		}
	}
	public void withdraw(Double amount) {
		
		if(amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}else {
			double totalValue = getBalance() - amount;
			System.out.printf("New Balance: %.2f", totalValue);
		}
		
	}
}
