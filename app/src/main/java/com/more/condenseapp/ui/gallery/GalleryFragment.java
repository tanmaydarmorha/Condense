package com.more.condenseapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.more.condenseapp.R;
import com.more.condenseapp.Service;
import com.more.condenseapp.ServiceAdapter;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);

        // Create a list of services
        final ArrayList<Service> services = new ArrayList<Service>();
        services.add(new Service(R.drawable.web_development, R.string.web_development, R.string.description_web_development));
        services.add(new Service(R.drawable.seo, R.string.seo, R.string.description_seo));
        services.add(new Service(R.drawable.smm, R.string.smm, R.string.description_smm));
        services.add(new Service(R.drawable.ads, R.string.ads, R.string.description_ads));
        services.add(new Service(R.drawable.analytics, R.string.analytics, R.string.description_analytics));

        // Create an {@link ServiceAdapter}, whose data source is a list of {@link Service}s. The
        // adapter knows how to create list items for each item in the list.
        ServiceAdapter adapter = new ServiceAdapter(getActivity(), services);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // service_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list_services);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Service} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}