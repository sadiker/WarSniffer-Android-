package com.example.warsnifffer.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.warsnifffer.dao.CountryDao;
import com.example.warsnifffer.models.Country;

@Database(entities = {Country.class},version = 2)
public  abstract  class CountryDatabase  extends RoomDatabase {

    public abstract CountryDao countryDao();
    private static  CountryDatabase countryDatabase;

    public static CountryDatabase createCountryDatabase(Context context){
        if(CountryDatabase.countryDatabase==null){
            CountryDatabase.countryDatabase= Room.databaseBuilder(context,CountryDatabase.class,"countryDatabase" )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return CountryDatabase.countryDatabase;
    }


}
