package com.magitech.simplestbudget;

import java.util.Vector;

public class User {
	public User(){
		setAccount(new Account());
		vAccounts = new Vector<Account>();
	}
	/**
	 * @return the account
	 */
	public Account getAccount(int index) {
		return vAccounts.get(index);
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	//Creates new Account
	public void addNewAccount(){
		vAccounts.add(new Account());
	}
	public int AccountNumber(){
		return vAccounts.size();
	}
	public Vector<Account> getAccount(){
		return vAccounts;
	}
	public void removeAccount(int index){
		vAccounts.remove(index);
	}
	private Vector<Account> vAccounts;
	@SuppressWarnings("unused")
	private Account account;
}
