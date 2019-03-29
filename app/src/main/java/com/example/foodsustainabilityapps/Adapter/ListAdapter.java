package com.example.foodsustainabilityapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.foodsustainabilityapps.Activity.ListActivity;
import com.example.foodsustainabilityapps.R;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataProvinsi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private OnItemClickListener clickItem;

    private static final String TAG ="Feedback";

    private List<DataProvinsi> listItems = new ArrayList<>();
    private Context context;
    private RelativeLayout parent_layout;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public ListAdapter(List<DataProvinsi> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list, parent, false);
        final ViewHolder holder = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItem.onItemClick(v, holder.getAdapterPosition());
            }
        });

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        final DataProvinsi listItem = listItems.get(position);

        holder.textViewHead.setText("Provinsi: " + listItem.getProvinsi());
        //holder.textViewDesc.setText(listItem.getIsi_feedback());
        holder.textViewPriority.setText("Priotitas: "+listItem.getPrority());
//--------------------------------------------------------------------------------------------------


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: "  );
                //Toast.makeText(context, "ID Segmen " + listItem.getId_segmen(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("Provinsi: ", listItem.getProvinsi());
                intent.putExtra("NPCR: ",listItem.getNcpr());
                intent.putExtra("POV: ", listItem.getPov());
                intent.putExtra("Road: ", listItem.getRoad());
                intent.putExtra("ELEC: ",listItem.getElec());
                intent.putExtra("Water :", listItem.getWater());
                intent.putExtra("Life : ", listItem.getLife());
                intent.putExtra("Flit :",listItem.getFlit());
                intent.putExtra("Health : ", listItem.getHealth());
                intent.putExtra("Priority",listItem.getPrority());
                context.startActivity(intent);

            }
        });

    }




    @Override
    public int getItemCount() {

        return listItems.size();
    }

    public void setListItems(List<DataProvinsi> listItems){
        this.listItems = listItems;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public TextView textViewPriority;
        public ImageView imageStat;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewPriority = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageStat = (ImageView) itemView.findViewById(R.id.img);


        }
    }

}
