package com.dell.zealthinkers.dellcollab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RequestActivity extends AppCompatActivity {

    private List<DropRequest> List = new ArrayList<>();
    private RecyclerView recyclerView;
    private SecondAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        recyclerView = (RecyclerView) findViewById(R.id.rv_drop);

        mAdapter = new SecondAdapter(List);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        DropRequest drop = new DropRequest("Shivaraj", "7696324435", "Ejipura, Sony Signal");
        List.add(drop);
        DropRequest drop1 = new DropRequest("Chethan", "8699200357", "Canara Bank, Madiwala");
        List.add(drop1);
        DropRequest drop2 = new DropRequest("Naga DA", "9696324435", "JP Nagar, Jayadeva Hospital");
        List.add(drop2);
        DropRequest drop3 = new DropRequest("Shweta", "6696324435", "Ejipura, Sony Signal");
        List.add(drop3);
        DropRequest drop4 = new DropRequest("Jaideep", "7696324435", "RR Nagar");
        List.add(drop4);
        

        mAdapter.notifyDataSetChanged();
    }
}
