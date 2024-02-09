package com.anushachandran1502.flightticketbooking.dto;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable{
	private int PNRNumber;
	private Flight flight;
	private String from;
	private String to;
	private List<Passenger> passenger;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}
	
	public int getTicketNumber() {
		return PNRNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.PNRNumber = ticketNumber;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public String toString()
	{
		return "Ticket Number :"+PNRNumber +"\n"+ "Fight Details : "+ flight +"\n"+ "Passenger Detais :" +
	passenger;
		
	}
}
