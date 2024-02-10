package com.anushachandran1502.flightticketbooking.addflight;

//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.repository.Repository;

public class AddFlightViewModel {

    private AddFlightView addFlightView;
    private Repository repository;
    
    public AddFlightViewModel(AddFlightView addFlightView) {
        this.addFlightView = addFlightView;
        this.repository=Repository.getInstance();
    
    }
    public void writeFlightDetailsToFile() {
		repository.writeFlightFile();
		
	}
}
