package com.example.foodsustainabilityapps.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodsustainabilityapps.R;

public class Predictfragment extends Fragment {
    public double ncpr,pov,road,life,water,flit,elec,health;
    public TextInputEditText inputNcpr,inputPov,inputRoad,inputLife,inputWater,inputFlit,inputElec,inputHealth;
    public double n_ncpr, n_pov, n_road, n_life, n_water, n_flit, n_elec, n_health, hasil;
    public int prior;
    public Button predict, reset;
    TextView prioritas1,prioritas2,prioritas3,prioritas4,prioritas5,prioritas6;
    ImageView imgPrior1,imgPrior2,imgPrior3,imgPrior4,imgPrior5,imgPrior6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predict, container, false);
        inputNcpr = view.findViewById(R.id.inputNcpr);
        inputPov = view.findViewById(R.id.inputPov);
        inputRoad = view.findViewById(R.id.inputRoad);
        inputLife = view.findViewById(R.id.inputLife);
        inputWater = view.findViewById(R.id.inputWater);
        inputFlit = view.findViewById(R.id.inputFlit);
        inputElec = view.findViewById(R.id.inputElec);
        inputHealth = view.findViewById(R.id.inputHealth);
        imgPrior1 = view.findViewById(R.id.img_prior1);
        imgPrior2 = view.findViewById(R.id.img_prior2);
        imgPrior3 = view.findViewById(R.id.img_prior3);
        imgPrior4 = view.findViewById(R.id.img_prior4);
        imgPrior5 = view.findViewById(R.id.img_prior5);
        imgPrior6 = view.findViewById(R.id.img_prior6);
        prioritas1 = view.findViewById(R.id.tvPrioritas1);
        prioritas2 = view.findViewById(R.id.tvPrioritas2);
        prioritas3 = view.findViewById(R.id.tvPrioritas3);
        prioritas4 = view.findViewById(R.id.tvPrioritas4);
        prioritas5 = view.findViewById(R.id.tvPrioritas5);
        prioritas6 = view.findViewById(R.id.tvPrioritas6);
        predict = view.findViewById(R.id.predict);
        reset = view.findViewById(R.id.reset);



        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ncpr = Double.parseDouble(inputNcpr.getText().toString());
                pov = Double.parseDouble(inputPov.getText().toString());
                road = Double.parseDouble(inputRoad.getText().toString());
                life = Double.parseDouble(inputLife.getText().toString());
                water = Double.parseDouble(inputWater.getText().toString());
                flit = Double.parseDouble(inputFlit.getText().toString());
                elec = Double.parseDouble(inputElec.getText().toString());
                health = Double.parseDouble(inputHealth.getText().toString());

                n_ncpr = (ncpr-2.603492)*0.3/8.549421;
                n_pov = (pov-15.06781)*0.15/8.733685;
                n_road = (road-10.7345)*0.125/16.99244;
                n_life = (life-68.62869)*0.1/2.653332;
                n_water = (water-35.20606)*0.15/14.43786;
                n_flit = (flit-11.35796)*0.05/14.14739;
                n_elec = (elec-12.72161)*0.075/19.94581;
                n_health = (health-4.671608)*0.05/10.6084;

                hasil = n_ncpr+n_pov+n_road+n_life+n_water+n_flit+n_elec+n_health;

                imgPrior1 = getActivity().findViewById(R.id.img_prior1);
                imgPrior2 = getActivity().findViewById(R.id.img_prior2);
                imgPrior3 = getActivity().findViewById(R.id.img_prior3);
                imgPrior4 = getActivity().findViewById(R.id.img_prior4);
                imgPrior5 = getActivity().findViewById(R.id.img_prior5);
                imgPrior6 = getActivity().findViewById(R.id.img_prior6);
                prioritas1 = getActivity().findViewById(R.id.tvPrioritas1);
                prioritas2 = getActivity().findViewById(R.id.tvPrioritas2);
                prioritas3 = getActivity().findViewById(R.id.tvPrioritas3);
                prioritas4 = getActivity().findViewById(R.id.tvPrioritas4);
                prioritas5 = getActivity().findViewById(R.id.tvPrioritas5);
                prioritas6 = getActivity().findViewById(R.id.tvPrioritas6);

                if (hasil<=41.52){
                    imgPrior1.setVisibility(View.VISIBLE);
                    prioritas1.setVisibility(View.VISIBLE);
                } else if (hasil<=51.42){
                    imgPrior2.setVisibility(View.VISIBLE);
                    prioritas2.setVisibility(View.VISIBLE);
                } else if (hasil<=59.58){
                    imgPrior3.setVisibility(View.VISIBLE);
                    prioritas3.setVisibility(View.VISIBLE);
                } else if (hasil<=67.75){
                    imgPrior4.setVisibility(View.VISIBLE);
                    prioritas4.setVisibility(View.VISIBLE);
                } else if (hasil<=75.68){
                    imgPrior5.setVisibility(View.VISIBLE);
                    prioritas5.setVisibility(View.VISIBLE);
                }else {
                    imgPrior6.setVisibility(View.VISIBLE);
                    prioritas6.setVisibility(View.VISIBLE);
                }






            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNcpr.setText(null);
                inputPov.setText(null);
                inputRoad.setText(null);
                inputLife.setText(null);
                inputWater.setText(null);
                inputFlit.setText(null);
                inputElec.setText(null);
                inputHealth.setText(null);
            }
        });



        return view;
    }


}
