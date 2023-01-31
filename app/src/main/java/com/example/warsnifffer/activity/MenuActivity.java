package com.example.warsnifffer.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.warsnifffer.R;
import com.example.warsnifffer.database.CountryDatabase;

public class MenuActivity extends AppCompatActivity  {

    private CountryDatabase countryDatabase;
    private ArrayAdapter<String> adapter1,adapter2;
    private Spinner spinner1,spinner2;
    Button button,button2 ;
    private ImageView imageView;
    private static final String[] paths = {"TÜRKİYE","AZERBAYCAN" ,"YUNANİSTAN", "İRAN","RUSYA","ABD","ÇİN","ALMANYA","İNGİLTERE","ERMENİSTAN"};
    private String country2Name,country1Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fixElements();

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                 country2Name= (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country2Name= (String) parent.getItemAtPosition(1);
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                 country1Name= (String) parent.getItemAtPosition(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country1Name= (String) parent.getItemAtPosition(2);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, AllCountryActivity.class);
                startActivity(intent);
                finish();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                fixbuilder(builder);

                AlertDialog alert = builder.create();
                alert.show();

            }
        });


    }

    private void fixbuilder(AlertDialog.Builder builder) {
        builder.setTitle(country1Name + " ve " + country2Name + " ülkelerini seçtin");
        TextView  tv = new TextView(MenuActivity.this);
        tv.setText("Az sonra yapacağınız seçimlerde 0-10 arası değerler verebilirsiniz,değer yazmadan onaylarsanız veya aralık dışında değer verirseniz uygulamanın  varsayılan değerleriyle göreceksiniz.. ");
        builder.setView(tv);

        builder.setPositiveButton(
                "Tamam",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(MenuActivity.this, PrepareCompareActivity.class);

                        intent.putExtra("country1Name",country1Name);
                        intent.putExtra("country2Name",country2Name);

                        startActivity(intent);
                        Toast.makeText(MenuActivity.this,country1Name + " ve " + country2Name+ "  ülkelerini seçtin",Toast.LENGTH_SHORT).show();
                        finish();

                        dialog.cancel();
                    }
                });

        builder.setNegativeButton(
                "Yeniden Seçim Yap",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
    }

    private void fixElements() {

        countryDatabase=CountryDatabase.createCountryDatabase(MenuActivity.this);

        imageView=findViewById(R.id.imageMenu);
        imageView.setImageResource(R.drawable.savas);

        button =  findViewById(R.id.buttonShow);
        button2 =  findViewById(R.id.buttonCompare);

        spinner1 = (Spinner)findViewById(R.id.select1);
        spinner2 = (Spinner)findViewById(R.id.select2);

        adapter1 = new ArrayAdapter<String>(MenuActivity.this,
                android.R.layout.simple_selectable_list_item,paths);
        adapter2 = new ArrayAdapter<String>(MenuActivity.this,
                android.R.layout.simple_spinner_dropdown_item,paths);

        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
    }


}