package com.example.tp1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tp1.data.Country;
import com.google.android.material.textfield.TextInputEditText;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context c = view.findViewById(R.id.drapeauViewDetail).getContext();

        TextView nomPays = view.findViewById(R.id.nom_paysViewDetail);
        ImageView drapeauPays = view.findViewById(R.id.drapeauViewDetail);
        EditText capitalePays = view.findViewById(R.id.capitalEditText);
        EditText monnaiePays = view.findViewById(R.id.monnaiesEditText);
        EditText languePays = view.findViewById(R.id.languesEditText);
        EditText populationPays = view.findViewById(R.id.populationEditText);
        EditText superficiePays = view.findViewById(R.id.superficieEditText);

        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());

        Integer population = Country.countries[args.getCountryId()].getPopulation();
        Integer superficie = Country.countries[args.getCountryId()].getArea();

        nomPays.setText(Country.countries[args.getCountryId()].getName());
        capitalePays.setText(Country.countries[args.getCountryId()].getCapital(), TextView.BufferType.EDITABLE);
        monnaiePays.setText(Country.countries[args.getCountryId()].getCurrency(), TextView.BufferType.EDITABLE);
        languePays.setText(Country.countries[args.getCountryId()].getLanguage(), TextView.BufferType.EDITABLE);
        populationPays.setText(population.toString(), TextView.BufferType.EDITABLE);
        superficiePays.setText(superficie.toString(), TextView.BufferType.EDITABLE);

        drapeauPays.setImageDrawable(c.getResources().getDrawable(c.getResources().getIdentifier(Country.countries[args.getCountryId()].getImgUri(),null,c.getPackageName())));
        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}