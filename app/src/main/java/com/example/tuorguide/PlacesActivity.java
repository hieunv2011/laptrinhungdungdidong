package com.example.tuorguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class home extends AppCompatActivity {
    private RecyclerView homeRecyclerView;
    private RecyclerView.Adapter homeAdapter;
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
        homeRecyclerView = findViewById(R.id.homeRecyclerView);

        homeData.add(new Place("Nguyễn Việt Hiếu","20192849"));
        homeData.add(new Place("Phạm Đức Nam","20193034"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));
        homeData.add(new Place("Trần Công Trường","20193162"));



        homeAdapter = new homeAdapter(homeData);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);
        homeRecyclerView.setAdapter(homeAdapter);
        homeRecyclerView.setLayoutManager(layoutManager);
    }
    public void navigateToDetailPlace(Integer position){
        Intent intent = new Intent (home.this, DetailPlaceActivity.class);
        Place selectedPlace =homeData.get(position);
        intent.putExtra("selectedPlace", selectedPlace);
        startActivity(intent);
    }

}