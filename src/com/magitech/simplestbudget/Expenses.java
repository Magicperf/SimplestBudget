package com.magitech.simplestbudget;

public class Expenses {
	public Expenses(){
		savings = 0;
		food = 0;
		mortgage = 0;
		utilities = 0;
		transportation = 0;
		debtPayments = 0;
		insurance = 0;
		medical = 0;
		clothing = 0;
		schoolExpenses = 0;
		other = 0;
	}
	/**
	 * @return the donations
	 */
	public float getDonations() {
		return donations;
	}
	/**
	 * @param donations the donations to set
	 */
	public void setDonations(float donations) {
		this.donations = donations;
	}
	/**
	 * @return the savings
	 */
	public float getSavings() {
		return savings;
	}
	/**
	 * @param savings the savings to set
	 */
	public void setSavings(float savings) {
		this.savings = savings;
	}
	/**
	 * @return the food
	 */
	public float getFood() {
		return food;
	}
	/**
	 * @param food the food to set
	 */
	public void setFood(float food) {
		this.food = food;
	}
	/**
	 * @return the mortgage
	 */
	public float getMortgage() {
		return mortgage;
	}
	/**
	 * @param mortgage the mortgage to set
	 */
	public void setMortgage(float mortgage) {
		this.mortgage = mortgage;
	}
	/**
	 * @return the utilities
	 */
	public float getUtilities() {
		return utilities;
	}
	/**
	 * @param utilities the utilities to set
	 */
	public void setUtilities(float utilities) {
		this.utilities = utilities;
	}
	/**
	 * @return the transportation
	 */
	public float getTransportation() {
		return transportation;
	}
	/**
	 * @param transportation the transportation to set
	 */
	public void setTransportation(float transportation) {
		this.transportation = transportation;
	}
	/**
	 * @return the debtPayments
	 */
	public float getDebtPayments() {
		return debtPayments;
	}
	/**
	 * @param debtPayments the debtPayments to set
	 */
	public void setDebtPayments(float debtPayments) {
		this.debtPayments = debtPayments;
	}
	/**
	 * @return the insurance
	 */
	public float getInsurance() {
		return insurance;
	}
	/**
	 * @param insurance the insurance to set
	 */
	public void setInsurance(float insurance) {
		this.insurance = insurance;
	}
	/**
	 * @return the medical
	 */
	public float getMedical() {
		return medical;
	}
	/**
	 * @param medical the medical to set
	 */
	public void setMedical(float medical) {
		this.medical = medical;
	}
	/**
	 * @return the clothing
	 */
	public float getClothing() {
		return clothing;
	}
	/**
	 * @param clothing the clothing to set
	 */
	public void setClothing(float clothing) {
		this.clothing = clothing;
	}
	/**
	 * @return the schoolExpenses
	 */
	public float getSchoolExpenses() {
		return schoolExpenses;
	}
	/**
	 * @param schoolExpenses the schoolExpenses to set
	 */
	public void setSchoolExpenses(float schoolExpenses) {
		this.schoolExpenses = schoolExpenses;
	}
	/**
	 * @return the other
	 */
	public float getOther() {
		return other;
	}
	/**
	 * @param other the other to set
	 */
	public void setOther(float other) {
		this.other = other;
	}
	private float donations;
	private float savings;
	private float food;
	private float mortgage;
	private float utilities;
	private float transportation;
	private float debtPayments;
	private float insurance;
	private float medical;
	private float clothing;
	private float schoolExpenses;
	private float other;
}
