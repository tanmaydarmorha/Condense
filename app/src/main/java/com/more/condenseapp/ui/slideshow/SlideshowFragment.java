package com.more.condenseapp.ui.slideshow;

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

import com.more.condenseapp.Project;
import com.more.condenseapp.ProjectAdapter;
import com.more.condenseapp.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    public SlideshowFragment() {
        // Required empty public constructor
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_slideshow, container,false);

        //Create a list of projects
        final ArrayList<Project> projects = new ArrayList<>();
        projects.add(new Project(R.drawable.urban_fruit, R.string.urban_fruit, R.string.description_urban_fruit));
        projects.add(new Project(R.drawable.great_apes, R.string.great_apes, R.string.description_great_apes));

        // Create an {@link ProjectAdapter}, whose data source is a list of {@link Service}s. The
        // adapter knows how to create list items for each item in the list.
        ProjectAdapter adapter = new ProjectAdapter(getActivity(), projects);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // project_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list_projects);

        // Make the {@link ListView} use the {@link ProjectAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Project} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}