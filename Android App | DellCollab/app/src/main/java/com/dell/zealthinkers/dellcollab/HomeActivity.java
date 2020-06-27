package com.dell.zealthinkers.dellcollab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    public ImageView imOwner, imRider;
    public String userPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userPhone = getIntent().getStringExtra("User_Phone");
        imOwner = findViewById(R.id.ic_owner);
        imRider = findViewById(R.id.ic_rider);

        imOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), OwnerActivity.class);
                intent.putExtra("User_Phone", userPhone);
                startActivity(intent);
            }
        });

        imRider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), RiderActivity.class);
                intent.putExtra("User_Phone", userPhone);
                startActivity(intent);
            }
        });
    }
}
