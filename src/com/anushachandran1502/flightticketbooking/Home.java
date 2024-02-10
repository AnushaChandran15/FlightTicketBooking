package com.anushachandran1502.flightticketbooking;

import com.anushachandran1502.flightticketbooking.addflight.AddFlightView;
import com.anushachandran1502.flightticketbooking.base.BaseView;
import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.dto.Passenger;
import com.anushachandran1502.flightticketbooking.dto.Ticket;

public class Home {
	public static void main(String[] args) {
//		System.out.println(new Flight());
//		System.out.println(new Passenger());
//		System.out.println(new Ticket());
		new AddFlightView().addFlightDetails();
		new BaseView().start();
			}
}
