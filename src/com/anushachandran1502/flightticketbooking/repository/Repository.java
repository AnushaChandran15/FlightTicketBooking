package com.anushachandran1502.flightticketbooking.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.dto.Ticket;

public class Repository {
	static Repository repository;
	private List<Flight> flights=new ArrayList<>();
	private List<Ticket> tickets=new ArrayList<>();
	private Repository()
	{
		
	}
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public static Repository getInstance()
	{
		if(repository==null)
		{
			repository=new Repository();
		}
		return repository;
	}
	public void writeFlightFile() {
		 try (FileOutputStream fos = new FileOutputStream("src/com/anushachandran1502/flightticketbooking/info/flights.txt");
	             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	            oos.writeObject(flights);
	            readFlightFile();
	        } catch (IOException e) {
	            throw new RuntimeException("Error writing flights to file", e);
	        }
	}
	 public List<Flight> readFlightFile() {
         try {
             FileInputStream fis = new FileInputStream("src/com/anushachandran1502/flightticketbooking/info/flights.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);
             flights = (List<Flight>) ois.readObject();
} catch (FileNotFoundException e) {
     } catch (IOException | ClassNotFoundException e) {
         throw new RuntimeException("Error reading flights from file", e);
     }
		return flights;
 }
	public List<Flight> findFlightsByStations(String from, String to) {
        List<Flight> flights = readFlightFile();
        List<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if(flight.getFlightRoutes().contains(from) && flight.getFlightRoutes().contains(to))
            {
                System.out.println(matchingFlights);

                matchingFlights.add(flight);
            }
        }
        return matchingFlights;
	}
	public void writeTicketFile() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("src/com/anushachandran1502/flightticketbooking/info/tickets.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(tickets);
			readTicketFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private List<Ticket> readTicketFile() {
		try {
			FileInputStream fis=new FileInputStream("src/com/anushachandran1502/flightticketbooking/info/tickets.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			tickets=(List<Ticket>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	public void addNewFlightRoutes(int flightNumber, List<String> newRoutes) {
		for(Flight flight:flights)
		{
			if(flight.getFlightNumber()==flightNumber)
			{
				List<String> flightRoutes = flight.getFlightRoutes();
	            if (!(flightRoutes instanceof ArrayList)) {
	                flightRoutes = new ArrayList<>(flightRoutes);
	                flight.setFlightRoutes(flightRoutes);
				for(String route:newRoutes)
				{
					if(!flight.getFlightRoutes().contains(route))
					{
						flight.getFlightRoutes().add(route);
					}
				}
			}
		}
	}
		writeFlightFile();	
		//System.out.println(flights);
	}	

}
