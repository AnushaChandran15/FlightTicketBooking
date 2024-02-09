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
	
	
	public List<Ticket> getTickes() {
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
	public void writeFile() {
		 try (FileOutputStream fos = new FileOutputStream("src/com/anushachandran1502/flightticketbooking/info/flights.txt");
	             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	            oos.writeObject(flights);
	            readFile();
	        } catch (IOException e) {
	            throw new RuntimeException("Error writing flights to file", e);
	        }
	}
	 public List<Flight> readFile() {
         try {
             FileInputStream fis = new FileInputStream("src/com/anushachandran1502/flightticketbooking/info/flights.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);
             flights = (List<Flight>) ois.readObject();
        // System.out.println(flights);
} catch (FileNotFoundException e) {
     } catch (IOException | ClassNotFoundException e) {
         throw new RuntimeException("Error reading flights from file", e);
     }
		return flights;
 }
	public List<Flight> findFlightsByStations(String from, String to) {
        List<Flight> flights = readFile();
       // System.out.println(flights);
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


	

}
