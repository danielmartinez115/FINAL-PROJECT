package com.example.finalmovieapp.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.finalmovieapp.R;
import com.example.finalmovieapp.views.fragments.FavoritesFragment;
import com.example.finalmovieapp.views.fragments.SearchFragment;


public class MainActivity extends AppCompatActivity {

    private Fragment searchFragment;
    private Fragment favoritesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        searchFragment = new SearchFragment();
        favoritesFragment = new FavoritesFragment();

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);

        setFragment(favoritesFragment);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.search_item:
                        setFragment(searchFragment);
                        return true;
                    case R.id.favorites_item:
                        setFragment(favoritesFragment);
                        return true;
                    default:
                        return false;

                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.navigationContainer, fragment).commit();
    }
}
