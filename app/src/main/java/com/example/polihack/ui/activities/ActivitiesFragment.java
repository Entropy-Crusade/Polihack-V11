package com.example.polihack.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.polihack.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitiesFragment extends Fragment {

    private ActivitiesViewModel activitiesViewModel;

    public String hobby1() {

        List<String> hobby1 = new ArrayList<>();

        hobby1.add("H1_Activitate 1");
        hobby1.add("H1_Activitate 2");
        hobby1.add("H1_Activitate 3");
        hobby1.add("H1_Activitate 4");
        hobby1.add("H1_Activitate 5");
        hobby1.add("H1_Activitate 6");
        hobby1.add("H1_Activitate 7");
        hobby1.add("H1_Activitate 8");
        hobby1.add("H1_Activitate 9");
        hobby1.add("H1_Activitate 10");


        Collections.shuffle(hobby1);
        return hobby1.get(0);
    }

    public String hobby2() {

        List<String> hobby2 = new ArrayList<>();

        hobby2.add("H2_Activitate 1");
        hobby2.add("H2_Activitate 2");
        hobby2.add("H2_Activitate 3");
        hobby2.add("H2_Activitate 4");
        hobby2.add("H2_Activitate 5");
        hobby2.add("H2_Activitate 6");
        hobby2.add("H2_Activitate 7");
        hobby2.add("H2_Activitate 8");
        hobby2.add("H2_Activitate 9");
        hobby2.add("H2_Activitate 10");


        Collections.shuffle(hobby2);
        return hobby2.get(0);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activitiesViewModel = new ViewModelProvider(this).get(ActivitiesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_activities, container, false);
        final TextView textView = root.findViewById(R.id.text_activities);

        TextView tv = root.findViewById(R.id.activ1);
        tv.setText(String.valueOf(hobby1()));

        TextView tv2 = root.findViewById(R.id.activ2);
        tv2.setText(String.valueOf(hobby2()));

        activitiesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}