package com.example.tuorguide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class homeAdapter extends RecyclerView.Adapter<HomeItemView> {
    private ArrayList<Place> homeData;
    private home placesActivity;
    homeAdapter(ArrayList<Place> homeData){
        this.homeData =homeData;
    }

    public void setPlacesActivity(home placesActivity) {
        this.placesActivity = placesActivity;
    }

    @NonNull
    @Override
    public HomeItemView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_item_view,viewGroup,false);
        HomeItemView homeItemView =new HomeItemView(view);
        homeItemView.sethome(this.placesActivity);
        return homeItemView;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemView homeItemView, int i) {
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
