package com.more.condenseapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ProjectAdapter extends ArrayAdapter<Project> {
    public ProjectAdapter(Context context, ArrayList<Project> projects) {
        super(context, 0, projects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Project} object located at this position in the list
        Project currentProject = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView photoImageView = listItemView.findViewById(R.id.photo_image_view);
        photoImageView.setImageResource(currentProject.getmProjectImageId());
        photoImageView.setVisibility(View.VISIBLE);

        // Find the TextView in the list_item.xml layout with the ID title_text_view.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the Title from the currentService object and set this text on
        // the title TextView.
        titleTextView.setText(currentProject.getmTitle());

        // Find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the Title from the currentService object and set this text on
        // the title TextView.
        descriptionTextView.setText(currentProject.getmDescription());

        return listItemView;
    }
}
