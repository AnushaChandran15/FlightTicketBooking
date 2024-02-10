package com.anushachandran1502.flightticketbooking.dto;

import java.io.Serializable;
import java.util.List;

public class Flight implements Serializable{
	private int flightNumber;
	private String flightName;
	private String depatureTime;
	private String arrivalTime;
	private List<String> flightRoutes;
	private byte totalSeats;
	private int fare;
	
	public Flight(int fightNumber, String flightName, String depatureTime, String arrivalTime, List<String> list, byte totalSeats, int fare) {
		this.flightNumber=fightNumber;
		this.flightName=flightName;
		this.depatureTime=depatureTime;
		this.arrivalTime=arrivalTime;
		this.flightRoutes=list;
		this.totalSeats=totalSeats;
		this.fare=fare;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public List<String> getFlightRoutes() {
		return flightRoutes;
	}
	public void setFlightRoutes(List<String> flightRoutes) {
		this.flightRoutes = flightRoutes;
	}
	public byte getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(byte i) {
		this.totalSeats = i;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String toString()
	{
		return "Flight Number "+ flightNumber +"\n"+"Flight Name "+ flightName+"\n"+
				"Flight Depature Number "+ depatureTime +"\n"+
				"Flight Arrival Time "+ arrivalTime +"\n"+ "Flight Routes "+ flightRoutes +
				"\n"+"Total Seats "+ totalSeats +"\n"+ "Fare "+ fare;
	}
	
}
