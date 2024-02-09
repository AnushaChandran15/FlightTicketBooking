package com.anushachandran1502.flightticketbooking.booking;

import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.repository.Repository;

import java.util.*;

public class BookingViewModel {
	private BookingView bView;
	private Repository repo;
	public BookingViewModel(BookingView bookingView) {
		this.bView=bookingView;
		this.repo=Repository.getInstance();
	}

	public List<Flight> availableFlights(String from, String to) {
		List<Flight> fli=new ArrayList<Flight>();
		fli=repo.findFlightsByStations(from,to);
		return fli;
	}

	public Flight findTheFlight(int flightNo) {
		List<Flight> flights=repo.readFile(); 
		for(Flight flight:flights)
		{
			if(flight.getFlightNumber()==flightNo)
			{
				return flight;
			}
		}
		return null;
	}

	

}
