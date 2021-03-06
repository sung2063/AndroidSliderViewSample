package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.sung2063.slideshowviewsample.adapter.MenuOptionRecyclerViewAdapter;
import com.sung2063.slideshowviewsample.data.DataCollection;
import com.sung2063.slideshowviewsample.model.MainOptionModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MenuOptionRecyclerViewAdapter.MenuOptionListener {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private Button btSponsorship;
    private RecyclerView rvOptions;
    private MenuOptionRecyclerViewAdapter menuOptionAdapter;

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSponsorship = findViewById(R.id.bt_sponsorship);
        rvOptions = findViewById(R.id.rv_options);

        // Setup Main Menu
        List<MainOptionModel> mainOptionList = DataCollection.getMainOptionData(getApplicationContext());
        rvOptions.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        menuOptionAdapter = new MenuOptionRecyclerViewAdapter(this, mainOptionList);
        menuOptionAdapter.setListener(this);
        rvOptions.setAdapter(menuOptionAdapter);

        btSponsorship.setPaintFlags(btSponsorship.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        // Respond
        btSponsorship.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/sponsors/sung2063"));
            startActivity(intent);
        });
    }

    @Override
    public void onMenuClicked(int position) {

        Intent intent = null;
        switch (position) {
            case NavigateIntent.HORIZONTAL_CAROUSEL:
                intent = new Intent(this, HorizontalCarouselSampleActivity.class);
                break;
            case NavigateIntent.VERTICAL_CAROUSEL:
                intent = new Intent(this, VerticalCarouselSampleActivity.class);
                break;
            case NavigateIntent.SLIDESHOW:
                intent = new Intent(this, SlideshowSampleActivity.class);
                break;
            case NavigateIntent.EXTRA_FEATURE:
                intent = new Intent(this, ExtraFeatureSampleActivity.class);
                break;
            case NavigateIntent.GIT_HUB_WEB_PAGE:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/sung2063"));
        }

        if (intent != null) {
            startActivity(intent);
        }
    }

    // =============================================================================================
    // Class
    // =============================================================================================
    public class NavigateIntent {
        public static final int HORIZONTAL_CAROUSEL = 0;
        public static final int VERTICAL_CAROUSEL = 1;
        public static final int SLIDESHOW = 2;
        public static final int EXTRA_FEATURE = 3;
        public static final int GIT_HUB_WEB_PAGE = 4;
    }
}