package com.example.tp1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.data.Country;
import com.google.android.material.textfield.TextInputEditText;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Context c = viewHolder.drapeau_pays.getContext();
        viewHolder.nom_pays.setText(Country.countries[i].getName());
        viewHolder.capitale_pays.setText(Country.countries[i].getCapital());
        viewHolder.drapeau_pays.setImageDrawable(c.getResources().getDrawable(
                c.getResources().getIdentifier(
                        Country.countries[i].getImgUri(),null,c.getPackageName()
                )
        ));
    }

    @Override
    public int getItemCount() {
        return Country.countries.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView drapeau_pays;
        TextView nom_pays;
        TextView capitale_pays;

        ViewHolder(View itemView) {
            super(itemView);
            drapeau_pays = itemView.findViewById(R.id.drapeau_pays);
            nom_pays = itemView.findViewById(R.id.nom_pays);
            capitale_pays = itemView.findViewById(R.id.capitale_pays);

            int position = getAdapterPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    int position = getAdapterPosition();

                    ListFragmentDirections.ActionFirstFragmentToSecondFragment action = ListFragmentDirections.actionFirstFragmentToSecondFragment(position);
                    Navigation.findNavController(v).navigate(action);
                }
            });

        }
    }

}