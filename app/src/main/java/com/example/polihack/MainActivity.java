package com.example.polihack;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_activities,
                R.id.navigation_daily,
                R.id.navigation_profile,
                R.id.navigation_shop,
                R.id.navigation_settings
                )
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }
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
}
