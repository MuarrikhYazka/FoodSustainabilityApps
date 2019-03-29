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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private OnItemClickListener clickItem;

    private static final String TAG ="Feedback";

    private List<DataKota> listItems = new ArrayList<>();
    private Context context;
    private RelativeLayout parent_layout;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public ListAdapter(List<DataKota> listItems, Context context) {
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

        final DataKota listItem = listItems.get(position);

        holder.textViewHead.setText("Kota: " + listItem.getKota());
        //holder.textViewDesc.setText(listItem.getIsi_feedback());
        holder.textViewPriority.setText("Priotitas: "+listItem.getPrority_kota());
//--------------------------------------------------------------------------------------------------


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: "  );
                //Toast.makeText(context, "ID Segmen " + listItem.getId_segmen(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, ListActivity.class);
                intent.putExtra("Kota/kab: ", listItem.getKota());
                intent.putExtra("NPCR: ",listItem.getNcpr_kota());
                intent.putExtra("POV: ", listItem.getPov_kota());
                intent.putExtra("Road: ", listItem.getKota());
                intent.putExtra("ELEC: ",listItem.getNcpr_kota());
                intent.putExtra("Water :", listItem.getPov_kota());
                intent.putExtra("Life : ", listItem.getKota());
                intent.putExtra("Flit :",listItem.getNcpr_kota());
                intent.putExtra("Health : ", listItem.getKota());
                intent.putExtra("Priority",listItem.getNcpr_kota());
                context.startActivity(intent);

            }
        });

    }




    @Override
    public int getItemCount() {

        return listItems.size();
    }

    public void setListItems(List<DataKota> listItems){
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
