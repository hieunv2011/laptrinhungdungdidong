package com.example.tuorguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailPlaceActivity extends Activity {
    public static PlacesActivity placesActivity;
    private Place selectedPlace;
    private TextView txtPlaceName;
    private TextView txtDescription;
    private ImageButton btnBack;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_place);
        selectedPlace = (Place) getIntent().getExtras().getSerializable("selectedPlace");
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtPlaceName = (TextView) findViewById(R.id.txtPlaceName);
        txtPlaceName.setText(selectedPlace.getPlaceName());
        txtDescription.setText(selectedPlace.getDescription());
        btnBack = findViewById(R.id.btnback);
        btnDelete=findViewById(R.id.btnDelete);
        setupActions();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alert
                Intent intent = new Intent(DetailPlaceActivity.this, PlacesActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setupActions(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DetailPlaceActivity.this)
                        .setTitle("AAA")
                        .setMessage("Bảy cỏ")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                DetailPlaceActivity.this.placesActivity.deletedPlace(selectedPlace.getPlaceId());
                                finish();
                            }
                        }).
                        setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                finish();
                            }
                        }).show();
            }
        });

}
}







