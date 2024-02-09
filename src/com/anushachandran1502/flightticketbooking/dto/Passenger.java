package com.anushachandran1502.flightticketbooking.dto;

import java.io.Serializable;

public class Passenger implements Serializable{
	private String name;
	private byte age;
	private String gender;
	private int id;
	private String status;
	private Flight flight;
	
	public Passenger(String name, byte age, String gender, int id) {
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.id=id;
        this.status = "CNF";

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String toString()
	{
		return "Name : "+ name +"\n"+"Age : "+ age +"\n"+"Genter :"+gender+"\n"+
				"Id : "+ id +"\n"+"Fight details :" +flight;
	}
	
}
