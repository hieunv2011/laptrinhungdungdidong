package com.example.tuorguide;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeItemView extends RecyclerView.ViewHolder {
    public TextView txtPlacename;
    public TextView txtDescription;
    private home placesActivity;

    public void setPlacesActivity(home placesActivity) {
        this.placesActivity = placesActivity;
    }

    public HomeItemView(View view){

        super(view);
        txtPlacename =(TextView) view.findViewById(R.id.txtPlacename);
        txtDescription=(TextView) view.findViewById(R.id.txtDescription);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeItemView.this.placesActivity.navigateToDetailPlace(getLayoutPosition());

            }
        });
    }
}
