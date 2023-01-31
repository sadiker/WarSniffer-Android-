package com.example.warsnifffer.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.warsnifffer.models.Country;

import java.util.List;

@Dao
public interface CountryDao {

    @Insert
    void addCountry(Country country);

    @Insert
    void addCountryList(List<Country> country);

    @Update
    void updateCountry(Country country);

    @Delete
    void deleteCountry(Country country);

    @Query("select * from ülkeler")
    List<Country> getAllCountries();

    @Query("SELECT * FROM ülkeler where name=:name")
    Country getCountry(String name);
}
