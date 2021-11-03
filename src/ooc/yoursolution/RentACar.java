/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author kcfke
 */
public class RentACar implements RentACarInterface {

    private List<Car> cars; // to hold the list of the cars 
    private String name;
    
    public RentACar(List<Car> cars, String name){
        this.cars = cars;
        this.name = name;
    }
    
    @Override
    public List getCars() {
       return cars;   
    }

    @Override
    public void setCars(List cars) {
       this.cars = cars;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
      
        int bookingDay, availability;
        
        for (Car car : cars){
            if(car.getMake().equals(make)){
                availability = 0;
                bookingDay = day;
                for (int i=0; i<lengthOfRent; i++){
                    if(!car.isAvailable(month, bookingDay++)){
                        availability = 1;
                        break;
                    }
                }
                if (availability == 0){
                    return true;
                }
            }
        }
      return false;       
        
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
    
        int bookingDay;
        int availability = 0;
        
        for(Car car : cars){
            if(car.getMake().equals(make)){
                bookingDay = day;
                for (int i=0; i<lengthOfRent; i++){
                    if(!car.isAvailable(month, bookingDay++)){
                     availability = 1;
                     break;
                    }
                }
            } if (availability == 0){
                return car.getId();
            }
        }
        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
    
        if (!checkAvailability(month, day, make, lengthOfRent)){
            return false;
        }
        int carId = getCarAvailable(month, day, make, lengthOfRent);
        
        for(Car car : cars){
            if(car.getId() == carId && car.getMake() == make){
                int bookingDay = day;
                for (int i=0; i<lengthOfRent; i++){
                    car.book(month, bookingDay);
                }
            }
        }
        return true;
    }

    @Override
    public int getNumberOfCars() {
    
        return cars.size();
    }
    
}
