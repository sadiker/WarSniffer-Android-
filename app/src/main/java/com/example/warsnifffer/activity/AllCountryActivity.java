package com.example.warsnifffer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.warsnifffer.R;
import com.example.warsnifffer.adapter.CountryAdapter;
import com.example.warsnifffer.dao.CountryDao;
import com.example.warsnifffer.database.CountryDatabase;

public class AllCountryActivity extends AppCompatActivity {


    CountryDao countryDao;
    ImageView imageView,imageView2 ;
    RecyclerView recyclerView;

    CountryAdapter countryAdapter;

    CountryDatabase countryDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_country);

        imageView  = findViewById(R.id.logoWarSniffer);
        imageView.setImageResource(R.drawable.savas);
        imageView2  = findViewById(R.id.logoWarSniffer2);
        imageView2.setImageResource(R.drawable.baseline_dark_mode_24);

        recyclerView=findViewById(R.id.recyclerViewShow);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL));

        countryDatabase= CountryDatabase.createCountryDatabase(AllCountryActivity.this);


        countryAdapter= new CountryAdapter(countryDatabase.countryDao().getAllCountries(),AllCountryActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllCountryActivity.this));
        recyclerView.setAdapter(countryAdapter);

    }
}