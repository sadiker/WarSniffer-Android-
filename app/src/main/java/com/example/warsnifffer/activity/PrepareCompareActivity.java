package com.example.warsnifffer.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.warsnifffer.R;
import com.example.warsnifffer.models.PowerRate;

public class PrepareCompareActivity extends AppCompatActivity {

    EditText editTextTank1,editTextPlane1,editTextNavy1,editTextArtillery1,editTextMan1;
    EditText editTextTank2,editTextPlane2,editTextNavy2,editTextArtillery2,editTextMan2;


    int artilleryCountry1, manpowerCountry1, planeCountry1, tankCountry1, navyCountry1,
            artilleryCountry2, manpowerCountry2, planeCountry2, tankCountry2, navyCountry2;

    Button button ;

    @Override    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_compare);

        button=findViewById(R.id.okCompareButton);

        fixElements();

        button.setOnClickListener(v -> {
            Intent intent = new Intent(PrepareCompareActivity.this, CompareActivity.class);

            checkNull(editTextTank1,editTextPlane1,editTextNavy1,editTextArtillery1,editTextMan1,editTextTank2,editTextPlane2,editTextNavy2,editTextArtillery2,editTextMan2);



            artilleryCountry1 = Integer.parseInt(editTextArtillery1.getText().toString());
            manpowerCountry1= Integer.parseInt(editTextMan1.getText().toString());
            planeCountry1= Integer.parseInt(editTextPlane1.getText().toString());
            tankCountry1= Integer.parseInt(editTextTank1.getText().toString());
            navyCountry1= Integer.parseInt(editTextNavy1.getText().toString());

            artilleryCountry2 = Integer.parseInt(editTextArtillery2.getText().toString());
            manpowerCountry2= Integer.parseInt(editTextMan2.getText().toString());
            planeCountry2= Integer.parseInt(editTextPlane2.getText().toString());
            tankCountry2= Integer.parseInt(editTextTank2.getText().toString());
            navyCountry2= Integer.parseInt(editTextNavy2.getText().toString());

            checkWorth();

            fixIntent(intent);
            startActivity(intent);
            finish();

        });
    }

    private void checkNull(EditText editTextTank1, EditText editTextPlane1, EditText editTextNavy1, EditText editTextArtillery1, EditText editTextMan1, EditText editTextTank2, EditText editTextPlane2, EditText editTextNavy2, EditText editTextArtillery2, EditText editTextMan2) {
        if(editTextTank1.getText().toString().equals("")){
            editTextTank1.setText(PowerRate.TANK_POWER+"");
        }

        if(editTextPlane1.getText().toString().equals(""))
            editTextPlane1.setText(PowerRate.WARPLANE_POWER+"");

        if(editTextNavy1.getText().toString().equals(""))
            editTextNavy1.setText(PowerRate.NAVY_POWER+"");

        if(editTextArtillery1.getText().toString().equals(""))
            editTextArtillery1.setText(PowerRate.ARTİLLERY_POWER+"");

        if(editTextMan1.getText().toString().equals(""))
            editTextMan1.setText(PowerRate.MAN_POWER+"");

        if(editTextTank2.getText().toString().equals(""))
            editTextTank2.setText(PowerRate.TANK_POWER+"");

        if(editTextPlane2.getText().toString().equals(""))
            editTextPlane2.setText(PowerRate.WARPLANE_POWER+"");

        if(editTextNavy2.getText().toString().equals(""))
            editTextNavy2.setText(PowerRate.NAVY_POWER+"");

        if(editTextArtillery2.getText().toString().equals(""))
            editTextArtillery2.setText(PowerRate.ARTİLLERY_POWER+"");

        if(editTextMan2.getText().toString().equals(""))
            editTextMan2.setText(PowerRate.MAN_POWER+"");


    }

    private void fixIntent(Intent intent) {
        intent.putExtra("country1Name",getIntent().getStringExtra("country1Name"));
        intent.putExtra("country2Name",getIntent().getStringExtra("country2Name"));

        intent.putExtra("artilleryCountry1",artilleryCountry1);
        intent.putExtra("manpowerCountry1",manpowerCountry1);
        intent.putExtra("planeCountry1",planeCountry1);
        intent.putExtra("tankCountry1",tankCountry1);
        intent.putExtra("navyCountry1",navyCountry1);

        intent.putExtra("artilleryCountry2",artilleryCountry2);
        intent.putExtra("manpowerCountry2",manpowerCountry2);
        intent.putExtra("planeCountry2",planeCountry2);
        intent.putExtra("tankCountry2",tankCountry2);
        intent.putExtra("navyCountry2",navyCountry2);



    }


    private void fixElements() {


        editTextArtillery1=findViewById(R.id.artilleryc1);
        editTextTank1=findViewById(R.id.tankc1);
        editTextPlane1=findViewById(R.id.planec1);
        editTextNavy1=findViewById(R.id.navyc1);
        editTextMan1=findViewById(R.id.manc1);


        editTextArtillery2=findViewById(R.id.artilleryc2);
        editTextTank2=findViewById(R.id.tankc2);
        editTextPlane2=findViewById(R.id.planec2);
        editTextNavy2=findViewById(R.id.navyc2);
        editTextMan2=findViewById(R.id.manc2);


    }

    private void checkWorth() {

        if( artilleryCountry1>10 || artilleryCountry1<0 ||
                manpowerCountry1>10 || manpowerCountry1<0 ||
                planeCountry1>10 || planeCountry1<0 ||
                tankCountry1>10 || tankCountry1<0 ||
                navyCountry1>10 || navyCountry1<0 ||
                artilleryCountry2>10 || artilleryCountry2<0 ||
                manpowerCountry2>10 || manpowerCountry2<0 ||
                planeCountry2>10 || planeCountry2<0 ||
                tankCountry2>10 || tankCountry2<0 ||
                navyCountry2>10 || navyCountry2<0

        ) {
            fixWorth();
        }
    }

    private void fixWorth() {

        artilleryCountry1= PowerRate.ARTİLLERY_POWER;
        manpowerCountry1=PowerRate.MAN_POWER;
        planeCountry1=PowerRate.WARPLANE_POWER;
        tankCountry1=PowerRate.TANK_POWER;
        navyCountry1=PowerRate.NAVY_POWER;

        artilleryCountry2= PowerRate.ARTİLLERY_POWER;
        manpowerCountry2=PowerRate.MAN_POWER;
        planeCountry2=PowerRate.WARPLANE_POWER;
        tankCountry2=PowerRate.TANK_POWER;
        navyCountry2 =PowerRate.NAVY_POWER;
    }
}