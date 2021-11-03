/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author dacsa
 */
public final class Car implements CarInterface {
    
    private final int id;
    private Make make;
    private double rate;
    private Map<Month, Boolean[]> map;

    
    /**
     * This will create a car with the given values.
     * @param id
     * @param make 
     * @param rate
     * @createAvailability() - will create the map of 
     * availability to each car created
     */
    public Car(int id, Make make, double rate) {
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
    }
    
    /**
     * Method to give the month the limits of the days to book a car.
     * @return map of availability
     */
    @Override 
    public Map createAvailability() {
      
        map = new HashMap<>();
        
        map.put(Month.JANUARY, new Boolean[31]);
        map.put(Month.FEBRUARY, new Boolean[28]);
        map.put(Month.MARCH, new Boolean[31]);
        map.put(Month.APRIL, new Boolean[30]);
        map.put(Month.MAY, new Boolean[31]);
        map.put(Month.JUNE, new Boolean[30]);
        map.put(Month.JULY, new Boolean[31]);
        map.put(Month.AUGUST, new Boolean[31]);
        map.put(Month.SEPTEMBER, new Boolean[30]);
        map.put(Month.OCTOBER, new Boolean[31]);
        map.put(Month.NOVEMBER, new Boolean[30]);
        map.put(Month.DECEMBER, new Boolean[31]);
     
        return map;
    
    }

    @Override
    public Make getMake() {
        
    return make;
    
    }

    @Override
    public void setMake(Make make) {
        
        this.make = make;
    }

    @Override
    public double getRate() {
    
        return rate;
    
    }

    @Override
    public void setRate(double rate) {
    
        this.rate = rate;
    
    }

    @Override
    public Map getAvailability() {
    
        return map;

    }

    @Override
    public void setAvailability(Map map) {
    
        this.map = map;
    
    }

    @Override
    public int getId() {
        
        return id;

    }
    /**
     * This will check if the car is available on the chosen day and month.
     * @param month
     * @param day
     * @return - availability (true or false)
     */
    @Override 
    public boolean isAvailable(Month month, int day) {
    
        Boolean[] availability = map.get(month);
        if(availability[day - 1]== null){
            availability[day - 1] = true;
        }
        
        return availability[day - 1];
    
    }

    /**
     * This will book the car and set the days of booking 
     * as unavailable for future bookings
     * @param month
     * @param day
     * @return if the booking is successful or not
     */
    @Override 
    public boolean book(Month month, int day) {
   
         if (map.get(month)[day-1]) {
            map.get(month)[day-1] = false;
            return true;
        }

        return false;
    
    }

    @Override
    public String toString() {
        return "\n"+"Car = {" + "id = " + id + ", make = " + make + ", rate = " + rate + "}";
    }
    
    
    
}
