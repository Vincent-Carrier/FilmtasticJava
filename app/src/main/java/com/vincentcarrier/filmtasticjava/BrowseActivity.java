package com.vincentcarrier.filmtasticjava;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BrowseActivity extends AppCompatActivity {

    private BrowseViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        vm = ViewModelProviders.of(this).get(BrowseViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        vm.getMovies();
    }
}
