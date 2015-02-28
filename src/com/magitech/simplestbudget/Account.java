package com.magitech.simplestbudget;

import java.util.Date;

public class Account {
	public Account(){
		incomePlanned = new Income();
		incomeActual = new Income();
		expensesPlanned = new Expenses();
		expensesActual = new Expenses();
		accountID = new Date().getTime();
		setMonthYear(null);
	}
	/**
	 * @return the incomePlanned
	 */
	public Income getIncomePlanned() {
		return incomePlanned;
	}
	/**
	 * @param incomePlanned the incomePlanned to set
	 */
	public void setIncomePlanned(Income incomePlanned) {
		this.incomePlanned = incomePlanned;
	}
	/**
	 * @return the incomeActual
	 */
	public Income getIncomeActual() {
		return incomeActual;
	}
	/**
	 * @param incomeActual the incomeActual to set
	 */
	public void setIncomeActual(Income incomeActual) {
		this.incomeActual = incomeActual;
	}
	/**
	 * @return the expensesPlanned
	 */
	public Expenses getExpensesPlanned() {
		return expensesPlanned;
	}
	/**
	 * @param expensesPlanned the expensesPlanned to set
	 */
	public void setExpensesPlanned(Expenses expensesPlanned) {
		this.expensesPlanned = expensesPlanned;
	}
	/**
	 * @return the expensesActual
	 */
	public Expenses getExpensesActual() {
		return expensesActual;
	}
	/**
	 * @param expensesActual the expensesActual to set
	 */
	public void setExpensesActual(Expenses expensesActual) {
		this.expensesActual = expensesActual;
	}
	/**
	 * @return the accountID
	 */
	public long getAccountID() {
		return accountID;
	}
	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	/**
	 * @return the monthYear
	 */
	public String getMonthYear() {
		return monthYear;
	}
	/**
	 * @param monthYear the monthYear to set
	 */
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	private Income incomePlanned;
	private Income incomeActual;
	private Expenses expensesPlanned;
	private Expenses expensesActual;
	private long accountID;
	private String monthYear;
}
