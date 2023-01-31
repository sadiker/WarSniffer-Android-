package com.example.warsnifffer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.warsnifffer.R;
import com.example.warsnifffer.database.CountryDatabase;
import com.example.warsnifffer.models.Country;
import com.example.warsnifffer.models.PowerRate;

public class CompareActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13;
    ImageView imageView1,imageView2;
    CountryDatabase countryDatabase;

    Country country1,country2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);



        countryDatabase=CountryDatabase.createCountryDatabase(CompareActivity.this);

        country1=countryDatabase.countryDao().getCountry(getIntent().getStringExtra("country1Name"));


        country2=countryDatabase.countryDao().getCountry(getIntent().getStringExtra("country2Name"));

        Long power1= getIntent().getIntExtra("manpowerCountry1",1)*country1.getManpower()+
                getIntent().getIntExtra("tankCountry1",1)*country1.getTank()+
                getIntent().getIntExtra("artilleryCountry1",1)*country1.getArtillery()+
                getIntent().getIntExtra("planeCountry1",1)*country1.getWarplane()+
                getIntent().getIntExtra("navyCountry1",1)*country1.getNavy();

        Long power2= getIntent().getIntExtra("manpowerCountry2",1)*country2.getManpower()+
                getIntent().getIntExtra("tankCountry2",1)*country2.getTank()+
                getIntent().getIntExtra("artilleryCountry2",1)*country2.getArtillery()+
                getIntent().getIntExtra("planeCountry2",1)*country2.getWarplane()+
                getIntent().getIntExtra("navyCountry2",1)*country2.getNavy();

        country1.setPower(power1);
        country2.setPower(power2);

        fixElements();

    }

    private void fixElements() {

        imageView1=findViewById(R.id.imageView7);
        imageView1.setImageResource(country1.getFlag());

        imageView2=findViewById(R.id.imageView8);
        imageView2.setImageResource(country2.getFlag());

        tv1=findViewById(R.id.powerCountry1);
        tv1.setText(country1.getPower().toString());

        tv2=findViewById(R.id.manpowerC1);
        tv2.setText(country1.getManpower().toString());

        tv3=findViewById(R.id.tank1);
        tv3.setText(country1.getTank()+"");

        tv4=findViewById(R.id.artillery1);
        tv4.setText(country1.getArtillery()+"");

        tv5=findViewById(R.id.navy1);
        tv5.setText(country1.getNavy()+"");

        tv6=findViewById(R.id.plane1);
        tv6.setText(country1.getWarplane()+"");

        tv7=findViewById(R.id.powerCountry2);
        tv7.setText(country2.getPower().toString());

        tv8=findViewById(R.id.manpowerC2);
        tv8.setText(country2.getManpower().toString());

        tv9=findViewById(R.id.tank2);
        tv9.setText(country2.getTank()+"");

        tv10=findViewById(R.id.artillery2);
        tv10.setText(country2.getArtillery()+"");

        tv11=findViewById(R.id.navy2);
        tv11.setText(country2.getNavy()+"");

        tv12=findViewById(R.id.plane2);
        tv12.setText(country2.getWarplane()+"");


        tv13=findViewById(R.id.lastSituation);
        if(country1.getPower()>country2.getPower()){
            tv13.setText("GALİP :  " + country1.getName());
        } else if (country1.getPower() < country2.getPower()){
            tv13.setText("GALİP :  " + country2.getName());
        } else if (country1.getPower().toString().equals(country2.getPower().toString())){
            tv13.setText("-DENGE-" );
        } else {
            tv13.setText("HATA :  " );
        }



    }
}