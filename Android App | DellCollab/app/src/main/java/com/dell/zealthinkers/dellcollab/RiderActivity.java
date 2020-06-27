package com.dell.zealthinkers.dellcollab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RiderActivity extends AppCompatActivity {

    public Spinner riderLeaveTime;
    public String time, userPhone;
    public Button findPeople;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider);

        userPhone = getIntent().getStringExtra("User_Phone");
        riderLeaveTime = findViewById(R.id.rider_leave_time);

        riderLeaveTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                time = parent.getItemAtPosition(position).toString();
                riderLeaveTime.setSelection(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        List<String> categories = new ArrayList<String>();
        categories.add("Leaving in ");
        categories.add("15 Minutes");
        categories.add("30 Minutes");
        categories.add("45 Minutes");
        categories.add("1 hour");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        riderLeaveTime.setAdapter(dataAdapter);

        findPeople = findViewById(R.id.find_ride);
        findPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = 15;
                if(time.contains("15")){
                    selected = 15;
                } else if(time.contains("30")){
                    selected = 30;
                } else if(time.contains("45")){
                    selected = 45;
                } else if(time.contains("hour")){
                    selected = 60;
                }
                Intent intent = new Intent(getBaseContext(), AvailableActivity.class);
                intent.putExtra("User_Phone", userPhone);
                intent.putExtra("Time",selected);
                startActivity(intent);
            }
        });
    }
}
