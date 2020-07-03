package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.sung2063.slideshowviewsample.adapter.MenuOptionRecyclerViewAdapter;
import com.sung2063.slideshowviewsample.data.DataCollection;
import com.sung2063.slideshowviewsample.model.MainOptionModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MenuOptionRecyclerViewAdapter.MenuOptionListener {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private RecyclerView rvOptions;
    private MenuOptionRecyclerViewAdapter menuOptionRecyclerViewAdapter;

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvOptions = findViewById(R.id.rv_options);

        // Setup Main Menu
        List<MainOptionModel> mainOptionList = DataCollection.getMainOptionData(getApplicationContext());
        rvOptions.setLayoutManager(new GridLayoutManager(this, 2));
        menuOptionRecyclerViewAdapter = new MenuOptionRecyclerViewAdapter(this, mainOptionList);
        menuOptionRecyclerViewAdapter.setListener(this);
        rvOptions.setAdapter(menuOptionRecyclerViewAdapter);

    }

    @Override
    public void onMenuClicked(int position) {

        Intent intent = null;
        switch (position) {
            case 0:
                // Go to Carousel horizontal
                intent = new Intent(this, HorizontalCarouselSampleActivity.class);
                break;
            case 1:
                // Go to Carousel vertical
                intent = new Intent(this, VerticalCarouselSampleActivity.class);
                break;
            case 2:
                // Go to Slideshow
                intent = new Intent(this, SlideshowSampleActivity.class);
                break;
        }

        if (intent != null)
            startActivity(intent);
    }
}