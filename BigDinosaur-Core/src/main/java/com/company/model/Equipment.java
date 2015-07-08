package com.company.model;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author Santosh
 * 
 */
@Entity
public class Equipment extends BaseJmx {

	private String category;
	private String description;
	private String assignment;
	private String barcode;
	private Integer numbers;
	private Date date;

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the assignment
	 */
	public String getAssignment() {
		return assignment;
	}

	/**
	 * @param assignment
	 *            the assignment to set
	 */
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}

	/**
	 * @param barcode
	 *            the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	/**
	 * @return the numbers
	 */
	public Integer getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers
	 *            the numbers to set
	 */
	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
