package com.example.tuorguide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlaceItemView> {
    private ArrayList<Place> homeData;
    private PlacesActivity placesActivity;
    PlacesAdapter(ArrayList<Place> homeData){
        this.homeData =homeData;
    }

    public void setPlacesActivity(PlacesActivity placesActivity) {
        this.placesActivity = placesActivity;
    }

    @NonNull
    @Override
    public PlaceItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_item_view,viewGroup,false);
        PlaceItemView placeItemView =new PlaceItemView(view);
        placeItemView.setPlacesActivity(this.placesActivity);
        return placeItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceItemView homeItemView, int i) {
        Place selectedPlace = homeData.get(i);
        String placeName = selectedPlace.getPlaceName();
        String description= selectedPlace.getDescription();
        homeItemView.txtPlacename.setText(placeName);
        homeItemView.txtDescription.setText(description);

    }

    @Override
    public int getItemCount() {
        return homeData.size();
    }
}
