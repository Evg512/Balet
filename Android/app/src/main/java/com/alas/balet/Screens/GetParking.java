package com.alas.balet.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.ParcelableSparseArray;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alas.balet.MainActivity;
import com.alas.balet.Objects.Parking;
import com.alas.balet.R;
import com.squareup.picasso.Picasso;

public class GetParking extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_parking);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.nav_bar);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Parking parking = (Parking)i.getSerializableExtra("parking");

        ImageView parkingImage = findViewById(R.id.imageView2);
        TextView parkingName = findViewById(R.id.parkingName);
        TextView parkingDescription = findViewById(R.id.parkingDescription);
        TextView parkingPrice = findViewById(R.id.parkingPrice);
        TextView parkingPlaces = findViewById(R.id.parkingPlaces);

        Picasso.get().load(parking.getImage()).into(parkingImage);
        parkingName.setText(parking.getName());
        parkingDescription.setText(parking.getDescription());
        parkingPrice.setText("Precio: "+parking.getPrice());
        parkingPlaces.setText("Lugares: "+parking.getName());


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
