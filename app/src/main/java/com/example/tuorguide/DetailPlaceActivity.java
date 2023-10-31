package com.example.tuorguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DetailPlaceActivity extends Activity {
    private Place selectedPlace;
    private TextView txtPlaceName;
    private TextView txtDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);
        selectedPlace = (Place)getIntent().getExtras().getSerializable("selectedPlace");
        Toast.makeText(this,selectedPlace.toString(), Toast.LENGTH_LONG).show();
        txtDescription=(TextView) findViewById(R.id.txtDescription);
        txtPlaceName=(TextView) findViewById(R.id.txtPlaceName);
        txtPlaceName.setText(selectedPlace.getPlaceName());
        txtDescription.setText(selectedPlace.getDescription());
    }
}