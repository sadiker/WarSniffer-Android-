package com.example.warsnifffer.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warsnifffer.R;
import com.example.warsnifffer.activity.AllCountryActivity;
import com.example.warsnifffer.activity.MenuActivity;
import com.example.warsnifffer.activity.PrepareCompareActivity;
import com.example.warsnifffer.models.Country;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

   private List<Country> countryList;
   private Context context;

    public CountryAdapter(List<Country> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.countryshow,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(countryList.get(position).getFlag());
        holder.tv1.setText(countryList.get(position).getName()+"");
        holder.tv2.setText(countryList.get(position).getManpower()+"");
        holder.tv3.setText(countryList.get(position).getTank()+"");
        holder.tv4.setText(countryList.get(position).getArtillery()+"");
        holder.tv5.setText(countryList.get(position).getNavy()+"");
        holder.tv6.setText(countryList.get(position).getWarplane()+"");
        holder.tv7.setText(countryList.get(position).getPower()+"");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(holder.button.getContext());
                builder.setTitle("ÜLKE AYRINTILI DURUM");
                TextView tv = new TextView(builder.getContext());
                tv.setText(countryList.get(holder.getAdapterPosition()).getDetail()+"");

                builder.setView(tv);
                builder.setPositiveButton("KAPAT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
        ImageView  imageView;

        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.countryFlag);
            tv1=itemView.findViewById(R.id.countryName);
            tv2=itemView.findViewById(R.id.manNumber);
            tv3=itemView.findViewById(R.id.tankNumber);
            tv4=itemView.findViewById(R.id.artilleryNumber);
            tv5=itemView.findViewById(R.id.navyNumber);
            tv6=itemView.findViewById(R.id.warplaneNumber);
            tv7=itemView.findViewById(R.id.powerNumber);
            button=itemView.findViewById(R.id.detailButton);




        }
    }


}
