package com.magitech.simplestbudget;

public class Income {
	public Income(){
		wagesAsalaries = 0;
		otherIncome = 0;
		totalIncome = 0;
	}
	/**
	 * @return the wagesAsalaries
	 */
	public float getWagesAsalaries() {
		return wagesAsalaries;
	}
	/**
	 * @param wagesAsalaries the wagesAsalaries to set
	 */
	public void setWagesAsalaries(float wagesAsalaries) {
		this.wagesAsalaries = wagesAsalaries;
	}
	/**
	 * @return the otherIncome
	 */
	public float getOtherIncome() {
		return otherIncome;
	}
	/**
	 * @param otherIncome the otherIncome to set
	 */
	public void setOtherIncome(float otherIncome) {
		this.otherIncome = otherIncome;
	}
	/**
	 * @return the totalIncome
	 */
	public float getTotalIncome() {
		return totalIncome;
	}
	/**
	 * @param totalIncome the totalIncome to set
	 */
	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}
	private float wagesAsalaries;
	private float otherIncome;
	private float totalIncome;
}
