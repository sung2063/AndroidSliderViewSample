package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.sung2063.sliders.carousel.CarouselView;
import com.sung2063.sliders.exception.SlideNullPointerException;
import com.sung2063.sliders.exception.SlideOutOfBoundException;
import com.sung2063.slideshowviewsample.adapter.VerticalCarouselAdapter;
import com.sung2063.slideshowviewsample.data.DataCollection;

import java.util.ArrayList;
import java.util.List;

public class VerticalCarouselSampleActivity extends AppCompatActivity {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private final String TAG = VerticalCarouselSampleActivity.class.getName();

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_carousel_sample);

        CarouselView carouselView = findViewById(R.id.carousel_view);

        // Get Sample Data & Create the Slides
        List<Integer> verticalCarouselDataList = DataCollection.getVerticalCarouselData();
        List<ViewGroup> verticalCarouselLayouts = new ArrayList<>();
        for (int k = 0; k < verticalCarouselDataList.size(); k++) {
            VerticalCarouselAdapter introSlide = new VerticalCarouselAdapter(getApplicationContext(), verticalCarouselDataList.get(k));
            verticalCarouselLayouts.add(introSlide.getRootView());
        }

        // Start the slideshow
        try {
            carouselView.setSlideList(verticalCarouselLayouts);
            carouselView.launch();
        } catch (SlideOutOfBoundException e) {
            Log.e(TAG, e.toString());
        } catch (SlideNullPointerException e) {
            Log.e(TAG, e.toString());
        }
    }
}