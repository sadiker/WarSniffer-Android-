package com.example.warsnifffer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.example.warsnifffer.R;
import com.example.warsnifffer.database.CountryDatabase;
import com.example.warsnifffer.models.Country;

public class MainActivity extends AppCompatActivity {

    CountryDatabase countryDatabase;
    ImageView imageView;
    Button button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.savas);

        button=findViewById(R.id.submitButton);

        fullfillDatabase();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                //Toast.makeText(MainActivity.this,countryDatabase.countryDao().getCountry(c1.getName()).getName(),Toast.LENGTH_LONG).show();

            }
        });

    }

    private void fullfillDatabase() {

        countryDatabase=CountryDatabase.createCountryDatabase(MainActivity.this);

        Country c1= new Country();
        c1.setFlag(R.drawable.turkiye);
        c1.setArtillery(3500);
        c1.setManpower(430000L);
        c1.setName("TÜRKİYE");
        c1.setWarplane(1000);
        c1.setTank(3000);
        c1.setNavy(150);
        c1.setDetail("Son zamanlarda savunma sanayii konusunda oldukça mesafe katetmiştir.İHA/SİHA,balistik füze,hava savunma sistemleri ve diğer konularda milli sistemlerini başarıyla geliştiriyor.Muharebe ve eğitim tecrübesi iyi durumdadır.NATO üyesidir.");
        c1.setPowerDefault();

        Country c2= new Country();
        c2.setFlag(R.drawable.greek);
        c2.setArtillery(1500);
        c2.setManpower(150000L);
        c2.setName("YUNANİSTAN");
        c2.setWarplane(600);
        c2.setTank(1300);
        c2.setNavy(120);
        c2.setDetail("Son zamanlarda HavaKuvvetlerini güçlendirmeye çalışıyor..AB ve Nato üyesi");
        c2.setPowerDefault();

        Country c3= new Country();
        c3.setFlag(R.drawable.flag_of_azerbaijan_svg);
        c3.setArtillery(800);
        c3.setManpower(75000L);
        c3.setName("AZERBAYCAN");
        c3.setWarplane(150);
        c3.setTank(900);
        c3.setNavy(25);
        c3.setDetail("2020 Dağlık Karabağ Savaşı'nda kesin bir galibiyet kazanmıştır.Enerji kaynakları yönünden zengindir.Ordusunu insansız silah sistemleri ile modernleştirmiştir.");
        c3.setPowerDefault();

        Country c4= new Country();
        c4.setFlag(R.drawable.flag_of_the_united_kingdom__3_5__svg);
        c4.setArtillery(230);
        c4.setManpower(200000L);
        c4.setName("İNGİLTERE");
        c4.setWarplane(660);
        c4.setTank(220);
        c4.setNavy(75);
        c4.setDetail("NATO üyesi,Ekonomik ve diplomatik  yönden güçlüdür. ");
        c4.setPowerDefault();

        Country c5= new Country();
        c5.setFlag(R.drawable._25px_flag_of_the_united_states_svg);
        c5.setArtillery(4000);
        c5.setManpower(1400000L);
        c5.setName("ABD");
        c5.setWarplane(13250);
        c5.setTank(5500);
        c5.setNavy(480);
        c5.setDetail("Dünyanın en güçlü ordusuna sahiptir.Savunma harcamalarında zirvededir.Dünyanın birçok bölgesinde üs ve misyonları vardır.");
        c5.setPowerDefault();

        Country c6= new Country();
        c6.setFlag(R.drawable.rusya);
        c6.setArtillery(15000);
        c6.setManpower(850000L);
        c6.setName("RUSYA");
        c6.setWarplane(4200);
        c6.setTank(12500);
        c6.setNavy(600);
        c6.setDetail("Doğal kaynak yönünden zengindir.Büyük bir ordusu vardır.Son zamanlarda Ukrayna ile savaş halindedir.");
        c6.setPowerDefault();

        Country c7= new Country();
        c7.setFlag(R.drawable.almanya);
        c7.setArtillery(150);
        c7.setManpower(185000L);
        c7.setName("ALMANYA");
        c7.setWarplane(600);
        c7.setTank(260);
        c7.setNavy(80);
        c7.setDetail("AB ve NATO üyesi.Gelişmiş bir sanayisi ve ekonomisi vardır.");
        c7.setPowerDefault();

        Country c8= new Country();
        c8.setFlag(R.drawable._in);
        c8.setArtillery(7300);
        c8.setManpower(1400000L);
        c8.setName("ÇİN");
        c8.setWarplane(3300);
        c8.setTank(5000);
        c8.setNavy(730);
        c8.setDetail("Dünyanın en fazla nüfusa sahip ülkesi.ABD'den sonra en büyük savunma harcamalarını yapıyor.Kendi silah sistemlerini üretecek kapasitededir.");
        c8.setPowerDefault();

        Country c9= new Country();
        c9.setFlag(R.drawable.flag_of_iran_svg);
        c9.setArtillery(3650);
        c9.setManpower(575000L);
        c9.setName("İRAN");
        c9.setWarplane(540);
        c9.setTank(4000);
        c9.setNavy(100);
        c9.setDetail("Bazı silah sistemlerini kendisi yapabiliyor.Doğal kaynak yönünden zengindir.");
        c9.setPowerDefault();

        Country c10= new Country();
        c10.setFlag(R.drawable.flag_of_armenia_svg);
        c10.setArtillery(350);
        c10.setManpower(45000L);
        c10.setName("ERMENİSTAN");
        c10.setWarplane(65);
        c10.setTank(500);
        c10.setNavy(0);
        c10.setDetail("2020 Dağlık Karabağ Savaşı'nda mağlup olmuştur.");
        c10.setPowerDefault();

        countryDatabase.countryDao().addCountry(c1);
        countryDatabase.countryDao().addCountry(c2);
        countryDatabase.countryDao().addCountry(c3);
        countryDatabase.countryDao().addCountry(c4);
        countryDatabase.countryDao().addCountry(c5);
        countryDatabase.countryDao().addCountry(c6);
        countryDatabase.countryDao().addCountry(c7);
        countryDatabase.countryDao().addCountry(c8);
        countryDatabase.countryDao().addCountry(c9);
        countryDatabase.countryDao().addCountry(c10);

    }
}