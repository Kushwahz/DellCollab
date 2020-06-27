package com.dell.zealthinkers.dellcollab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class OwnerActivity extends AppCompatActivity {

    private TimePicker ownerLeaveTime;
    public Spinner ownerSpace, vehicleType;
    public Button available;
    public String seats, vType;
    public int hour = 0;
    public int min = 0;
    public String userPhone;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Rides").push();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_);

        userPhone = getIntent().getStringExtra("User_Phone");
        ownerLeaveTime = findViewById(R.id.leave_time);
        vehicleType = findViewById(R.id.vehicle_type);
        ownerSpace = findViewById(R.id.no_of_seats);
        available = findViewById(R.id.available);

        ownerSpace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seats = parent.getItemAtPosition(position).toString();
                ownerSpace.setSelection(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        List<String> categories = new ArrayList<String>();
        categories.add("Seats you have");
        categories.add("1");
        categories.add("2");
        categories.add("3");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ownerSpace.setAdapter(dataAdapter);

        vehicleType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vType = parent.getItemAtPosition(position).toString();
                vehicleType.setSelection(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        List<String> categories1 = new ArrayList<String>();
        categories1.add("Select Your Vehicle");
        categories1.add("Car");
        categories1.add("Bike");
        final ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, categories1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleType.setAdapter(dataAdapter1);

        hour = ownerLeaveTime.getCurrentHour();
        min = ownerLeaveTime.getCurrentMinute();

        available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.child("OwnerPhoneNumber").setValue(userPhone);
                myRef.child("OwnerVehicleType").setValue(vType);
                myRef.child("OwnerLeaveHour").setValue(String.valueOf(hour));
                myRef.child("OwnerLeaveMin").setValue(String.valueOf(min));
                myRef.child("OwnerSeats").setValue(seats);

                Intent intent = new Intent(getBaseContext(), RequestActivity.class);
                intent.putExtra("User_Phone", userPhone);
                startActivity(intent);
            }
        });
    }
}
