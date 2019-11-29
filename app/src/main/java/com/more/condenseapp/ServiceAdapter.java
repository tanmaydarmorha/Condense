package com.more.condenseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceAdapter extends ArrayAdapter<Service> {
    public ServiceAdapter(Context context, ArrayList<Service> services) {
        super(context, 0, services);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Service} object located at this position in the list
        Service currentService = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView photoImageView = listItemView.findViewById(R.id.photo_image_view);
        photoImageView.setImageResource(currentService.getmServiceImageID());
        photoImageView.setVisibility(View.VISIBLE);

        // Find the TextView in the list_item.xml layout with the ID title_text_view.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the Title from the currentService object and set this text on
        // the title TextView.
        titleTextView.setText(currentService.getmTitle());

        // Find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the Title from the currentService object and set this text on
        // the title TextView.
        descriptionTextView.setText(currentService.getmDescription());


        return listItemView;
    }
}