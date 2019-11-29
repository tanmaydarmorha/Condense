package com.more.condenseapp.ui.share;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.more.condenseapp.R;

public class ShareFragment extends Fragment {

    public ShareFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_share,
                container, false);

        ImageView facebookImageView = (ImageView) rootView.findViewById(R.id.facebook_logo_image_view);
        facebookImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Opening Facebook", Toast.LENGTH_SHORT);
                toast.show();
                Log.v("Contact Us Activity", "calling facebook");
            }
        });

        ImageView twitterImageView = (ImageView) rootView.findViewById(R.id.twitter_logo_image_view);
        twitterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Opening Twitter", Toast.LENGTH_SHORT);
                toast.show();
                Log.v("Contact Us Activity", "calling twitter");
            }
        });

        ImageView linkedinImageView = (ImageView) rootView.findViewById(R.id.linkedin_logo_image_view);
        linkedinImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Opening LinkedIn", Toast.LENGTH_SHORT);
                toast.show();
                Log.v("Contact Us Activity", "calling linkedin");
            }
        });

        ImageView instagramImageView = (ImageView) rootView.findViewById(R.id.instagram_logo_image_view);
        instagramImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Opening Instagram", Toast.LENGTH_SHORT);
                toast.show();
                Log.v("Contact Us Activity", "calling instagram");
            }
        });


        return rootView;
    }
}