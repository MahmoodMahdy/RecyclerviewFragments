package com.mahdy.codes.chalengefragmentrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationCar extends Application {
    public static ArrayList<Car> cars ;

    @Override
    public void onCreate() {
        super.onCreate();
        cars = new ArrayList<Car>() ;
        cars.add(new Car("Volksvegen" , "polo" , "Check Nores" , "0102255462")) ;
        cars.add(new Car("Mercedes" , "E200" , "Peter Nores" , "65543212544")) ;
        cars.add(new Car("Nissan" , "Almera" , "Mark Nores" , "0102255462")) ;
        cars.add(new Car("Volksvegen" , "polo" , "Check Nores" , "0102255462")) ;
        cars.add(new Car("Mercedes" , "E265" , "sad Nores" , "0102255462")) ;
        cars.add(new Car("Nissan" , "Metro" , "Hany Nores" , "0102255462")) ;
        cars.add(new Car("Volksvegen" , "poloTy" , "Said Nores" , "0102255462")) ;

    }
}
