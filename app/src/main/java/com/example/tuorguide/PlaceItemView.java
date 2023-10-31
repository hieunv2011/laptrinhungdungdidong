package com.example.tuorguide;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PlaceItemView extends RecyclerView.ViewHolder {
    public TextView txtPlacename;
    public TextView txtDescription;
    private PlacesActivity placesActivity;

    public void setPlacesActivity(PlacesActivity placesActivity) {
        this.placesActivity = placesActivity;
    }

    public PlaceItemView(View view){

        super(view);
        txtPlacename =(TextView) view.findViewById(R.id.txtPlacename);
        txtDescription=(TextView) view.findViewById(R.id.txtDescription);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaceItemView.this.placesActivity.navigateToDetailPlace(getLayoutPosition());


            }
        });
    }
}
