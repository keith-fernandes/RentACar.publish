/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author kcfke
 */
public class BookingSystem implements BookingSystemInterface {

    
    /**
     * This will read the information about the cars from a file.
     * @param in BufferedReader 
     * @return a rentACar class
     * @throws IOException 
     */
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
    
        String readInfo, nameOfCompany;
        List<Car> cars = new ArrayList<>();
        nameOfCompany = in.readLine();

        while ((readInfo = in.readLine()) != null) {
            String carInfo[] = readInfo.split(":");

            Make make = Make.valueOf(carInfo[0]);
            double rate = Double.parseDouble(carInfo[1]);
            int numCars = Integer.parseInt(carInfo[2]);

            for (int i=0; i<numCars; i++) {
                Car car = new Car(i, make, rate);
                cars.add(car);
            }
        }

        RentACarInterface rentACarInterface = new RentACar(cars, nameOfCompany);
        return rentACarInterface;
    }
    
}
