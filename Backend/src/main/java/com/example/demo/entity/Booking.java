package com.example.demo.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name ="BookMaster")
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid")
	private int bookId;

	
	@NotNull(message = "roomno cannot be null")
	//@Min(value = 1, message = "Room number must be at least 1") 
	//@Max(value = 100, message = "Room number must be at most 100")
	@Column(name = "roomno")
	private Integer roomNo;

	
	@Column(name="noofDays")
	private int noOfDays;
	@Column(name = "roomType")
	private String roomType;
	@Column(name = "totalAmount")
	private double totalAmount;
	public Booking() {
		super();
	}
	public Booking(int bookId,
			@NotNull(message = "roomno cannot be null") @Min(value = 1, message = "Room number must be at least 1") //@Max(value = 100, message = "Room number must be at most 100")
			Integer roomNo,
			int noOfDays, String roomType, double totalAmount) {
		super();
		this.bookId = bookId;
		this.roomNo = roomNo;
		this.noOfDays = noOfDays;
		this.roomType = roomType;
		this.totalAmount = totalAmount;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", roomNo=" + roomNo + ", noOfDays=" + noOfDays + ", roomType=" + roomType
				+ ", totalAmount=" + totalAmount + ", getBookId()=" + getBookId() + ", getRoomNo()=" + getRoomNo()
				+ ", getNoOfDays()=" + getNoOfDays() + ", getRoomType()=" + getRoomType() + ", getTotalAmount()="
				+ getTotalAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}