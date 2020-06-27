package com.dell.zealthinkers.dellcollab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.security.AccessController.getContext;

public class AvailableActivity extends AppCompatActivity {

    private List<AvailableRides> List = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available);

        recyclerView = (RecyclerView) findViewById(R.id.rv_available);

        mAdapter = new Adapter(List);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        AvailableRides ride = new AvailableRides("7696324435", "Car", "10 Mins","60% RM","2");
        List.add(ride);

        AvailableRides ride1 = new AvailableRides("7696324435", "Bike", "12 Mins","70% RM","1");
        List.add(ride1);

        AvailableRides ride2 = new AvailableRides("7696324435", "Car", "9 Mins","50% RM","3");
        List.add(ride2);
        AvailableRides ride3 = new AvailableRides("7696324435", "Car", "10 Mins","10% RM","2");
        List.add(ride3);
        AvailableRides ride4 = new AvailableRides("7696324435", "Bike", "11 Mins","80% RM","1");
        List.add(ride4);


        mAdapter.notifyDataSetChanged();
    }
}
