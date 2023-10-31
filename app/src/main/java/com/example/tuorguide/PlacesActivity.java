package com.example.tuorguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class PlacesActivity extends AppCompatActivity {
    private RecyclerView placesRecyclerView;
    private RecyclerView.Adapter placesAdapter;
    private TextView txtInfo;

    private ArrayList<Place> homeData =new ArrayList<Place>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtInfo= (TextView) findViewById(R.id.txtInfo);
        Bundle extras =getIntent().getExtras();
        if(extras != null){
            String email =extras.getString("email");
            txtInfo.setText("Your email is "+email  );
        }
        placesRecyclerView = findViewById(R.id.homeRecyclerView);

        homeData.add(new Place("Nguyễn Việt Hiếu","20192849"));
        homeData.add(new Place("Phạm Đức Nam","20193034"));
        homeData.add(new Place("Erik Ten Hag","20193162"));
        homeData.add(new Place("Marcus Rasford","20193162"));
        homeData.add(new Place("Antony Compa","20193162"));
        homeData.add(new Place("Erling Haaland","20193162"));
        homeData.add(new Place("Phil Foden ","20193162"));
        homeData.add(new Place("Andre Onana","20193162"));
        homeData.add(new Place("Harry Marguire","20193162"));
        homeData.add(new Place("Cristiano Ronaldo ","20193162"));
        homeData.add(new Place("Lionel Messi","20193162"));
        homeData.add(new Place("Jesse Lingard","20193162"));
        homeData.add(new Place("Jude Bellingham","20193162"));
        homeData.add(new Place("Lại Bá Đức","20192771"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));



        placesAdapter = new PlacesAdapter(homeData);
        ((PlacesAdapter) placesAdapter).setPlacesActivity(this);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);
        placesRecyclerView.setAdapter(placesAdapter);
        placesRecyclerView.setLayoutManager(layoutManager);
    }
    public void navigateToDetailPlace(Integer position){
        Intent intent = new Intent (PlacesActivity.this, DetailPlaceActivity.class);
        Place selectedPlace =homeData.get(position);
        intent.putExtra("selectedPlace", selectedPlace);
        startActivity(intent);
    }

}