package com.anushachandran1502.flightticketbooking.dto;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable{
	private int PNRNumber;
	private Flight flight;
	private String from;
	private String to;
	

	private int totalFare;
	private List<Passenger> passenger;

	public List<Passenger> getPassenger() {
		return passenger;
	}
	public Ticket(String from, String to, Flight flight, int totalFare, List<Passenger> passengers) {
		this.flight = flight;
		this.from = from;
		this.to = to;
		this.totalFare = totalFare;
		this.passenger = passengers;

		this.PNRNumber = (int) (Math.random() * 9999 + 1);
	}

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
	public int getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public int getPNRNumber() {
		return PNRNumber;
	}

	public void setPNRNumber(int ticketNumber) {
		this.PNRNumber = ticketNumber;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String toString() {
		StringBuilder str=new StringBuilder();
		str.append( "Ticket Details : \n" + "Flight Details : \n" + "-----------\n" + "|| Flight Number : "
				+ flight.getFlightName() + "||" + " || Flight Name : " + flight.getFlightName() + "||" + "|| Flight ArrivalTime : "
				+ flight.getArrivalTime() + "|| Flight Depature : "+flight.getDepatureTime()+"||\n"+
				"|| From :"+from +"||"+"|| To :"+to +"||"+"|| PNR Number :"+PNRNumber+"||"+"|| Total Fare : "+totalFare +"||\n"+
				"Passenger Details : \n");
		for(Passenger psgr:passenger)
		{
			str.append(psgr);
			str.append("\n");

		}
		return str.toString();

	}

}
