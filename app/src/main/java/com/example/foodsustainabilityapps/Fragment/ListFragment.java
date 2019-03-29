package com.example.foodsustainabilityapps.Fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.foodsustainabilityapps.Adapter.ListAdapter;
import com.example.foodsustainabilityapps.R;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.ViewModel;

import java.util.List;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<DataKota> listItems;
    private ViewModel viewModel;
    public RelativeLayout main;

    public ListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initViews(final View view) {
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_layout);
        recyclerView = view.findViewById(R.id.recycler_view_feed_back);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);

        viewModel.getAllDataKota();
        LinearLayout nullfeedback = view.findViewById(R.id.feedback_null);
        adapter = new ListAdapter(listItems, getActivity());
        recyclerView.setAdapter(adapter);
        if(adapter.getItemCount()== 0){

            nullfeedback.setVisibility(View.VISIBLE);

        }else if (adapter.getItemCount() > 0){
            main = getActivity().findViewById(R.id.main_feedback);
            main.setBackgroundResource(R.color.white);
            nullfeedback.setVisibility(View.GONE);
        }
    }

}
