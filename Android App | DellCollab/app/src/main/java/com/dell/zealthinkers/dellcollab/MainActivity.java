package com.dell.zealthinkers.dellcollab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EditText UserName, UserEmail, UserPhone, UserHome;
    public Spinner spinner;
    public String userName, userEmail, userPhone, userHome, userOffice;
    public Button getHotSpot, register;
    LinearLayout layout;
    TextView title;


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.user_office);
        UserName = findViewById(R.id.user_name);
        UserEmail = findViewById(R.id.user_mail);
        UserPhone = findViewById(R.id.user_phone);
        UserHome = findViewById(R.id.user_home);
        getHotSpot = findViewById(R.id.bt_getHotSpot);

        register = findViewById(R.id.bt_register);
        title = findViewById(R.id.main_titlea);

        layout = findViewById(R.id.main_layout);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.VISIBLE);
                title.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                getHotSpot.setVisibility(View.VISIBLE);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userOffice = parent.getItemAtPosition(position).toString();
                spinner.setSelection(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        List<String> categories = new ArrayList<String>();
        categories.add("DELL 4");
        categories.add("DELL 5");
        categories.add("DELL 6");
        categories.add("DELL 7");
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(dataAdapter.getPosition(userOffice));

        getHotSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = UserName.getText().toString();
                userEmail = UserEmail.getText().toString();
                userPhone = UserPhone.getText().toString();
                userHome = UserHome.getText().toString();

                myRef.child(userPhone).child("UserName").setValue(userName);
                myRef.child(userPhone).child("UserEmail").setValue(userEmail);
                myRef.child(userPhone).child("UserPhone").setValue(userPhone);
                myRef.child(userPhone).child("UserHome").setValue(userHome);
                myRef.child(userPhone).child("UserOffice").setValue(userOffice);
                if(userHome.equals("Madiwala")){
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Ejipura Signal");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Sony Signal");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Canara Bank, Kmgla");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Forum Mall");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Madiwala");
                } else if(userHome.equals("RR Nagar")){
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Ejipura Signal");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Sony Signal");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Canara Bank, Kmgla");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Forum Mall");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Madiwala");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Maruthi Nagar");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("BTM - Udapi Signal");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Jayadeva Hospital Bridge");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("JP Nagar Central Mall");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Banashankari Bus Stop");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Kadarenahalli Bridge");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Uttaraballi");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("Poorna Pragna Layout");
                    myRef.child(userPhone).child("UserHotSpots").push().setValue("RR Nagar");
                }

                Intent intent = new Intent(getBaseContext(), HotSpotList.class);
                intent.putExtra("User_Phone", userPhone);
                startActivity(intent);
            }
        });

        myRef.child("UserName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TEST TAG", "Failed to read value.", error.toException());
            }
        });
    }
}
