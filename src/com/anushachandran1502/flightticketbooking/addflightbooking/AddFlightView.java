package com.anushachandran1502.flightticketbooking.addflightbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.repository.Repository;

public class AddFlightView {
	private AddFlightViewModel addFlightViewModel;
    private List<Flight> flights;

	public AddFlightView()
	{
		addFlightViewModel=new AddFlightViewModel(this);
	}

public void addFlightDetails() {
Flight fight1 = new Flight(2345, "Kolkatta Airways", "1.00", "11.00", Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Kolkatta"), (byte)10, 530);
Flight fight2 = new Flight(2346, "Delhi Airways", "23.00", "5.00", Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Kolkatta", "Delhi"), (byte)10, 530);
Flight fight3 = new Flight(2347, "Kovai Express", "23.00", "5.00", Arrays.asList("Chennai", "Bengalure", "Hydrabad", "Kolkatta"), (byte)10, 530);					
flights=new ArrayList<>();
flights.add(fight1);
flights.add(fight2);	
flights.add(fight3);
Repository.getInstance().setFlights(flights);
addFlightViewModel.writeFlightDetailsToFile();
	}
}
