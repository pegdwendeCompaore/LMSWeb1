package com.gcit.lms.entity;

import java.time.LocalDate;
import java.util.List;

public class Loans {
	
	
private int branchId;
private int bookId;
private int cardNo;
private LocalDate duedate;
private LocalDate dateOut;
private LocalDate dateIn;
List<Book>books;
List<Branch>branchs;

public int getBranchId() {
	return branchId;
}
public void setBranchId(int branchId) {
	this.branchId = branchId;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public int getCardNo() {
	return cardNo;
}
public void setCardNo(int cardNo) {
	this.cardNo = cardNo;
}
public LocalDate getDuedate() {
	return duedate;
}
public void setDuedate(LocalDate duedate) {
	this.duedate = duedate;
}
public LocalDate getDateOut() {
	return dateOut;
}
public void setDateOut(LocalDate dateOut) {
	this.dateOut = dateOut;
}
public LocalDate getDateIn() {
	return dateIn;
}
public void setDateIn(LocalDate dateIn) {
	this.dateIn = dateIn;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + bookId;
	result = prime * result + branchId;
	result = prime * result + cardNo;
	result = prime * result + ((dateIn == null) ? 0 : dateIn.hashCode());
	result = prime * result + ((dateOut == null) ? 0 : dateOut.hashCode());
	result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Loans other = (Loans) obj;
	if (bookId != other.bookId)
		return false;
	if (branchId != other.branchId)
		return false;
	if (cardNo != other.cardNo)
		return false;
	if (dateIn == null) {
		if (other.dateIn != null)
			return false;
	} else if (!dateIn.equals(other.dateIn))
		return false;
	if (dateOut == null) {
		if (other.dateOut != null)
			return false;
	} else if (!dateOut.equals(other.dateOut))
		return false;
	if (duedate == null) {
		if (other.duedate != null)
			return false;
	} else if (!duedate.equals(other.duedate))
		return false;
	return true;
}
@Override
public String toString() {
	return "Loans [branchId=" + branchId + ", bookId=" + bookId + ", cardNo="
			+ cardNo + ", duedate=" + duedate + ", dateOut=" + dateOut
			+ ", dateIn=" + dateIn + "]";
}











	
	
}
