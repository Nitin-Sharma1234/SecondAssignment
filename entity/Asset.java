package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Asset {

	@Id
	private String name;
	
	private Date purchaseDate;
	
	private String conditionNote;
	
	private String category;
	
	@Enumerated(EnumType.STRING)
	private Status assignmentStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public String getConditionNote() {
		return conditionNote;
	}

	public void setConditionNote(String conditionNote) {
		this.conditionNote = conditionNote;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Status getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(Status assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Asset [name=" + name + ", purchaseDate=" + purchaseDate + ", conditionNote=" + conditionNote
				+ ", category=" + category + ", assignmentStatus=" + assignmentStatus + "]";
	}


	
}
