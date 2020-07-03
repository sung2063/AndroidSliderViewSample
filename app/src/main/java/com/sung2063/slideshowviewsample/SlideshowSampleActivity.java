package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.sung2063.sliders.exceptions.SlideNullPointerException;
import com.sung2063.sliders.exceptions.SlideOutOfBoundException;
import com.sung2063.sliders.slideshow.SlideshowView;
import com.sung2063.slideshowviewsample.adapter.SlideshowAdapter;
import com.sung2063.slideshowviewsample.data.DataCollection;

import java.util.ArrayList;
import java.util.List;

public class SlideshowSampleActivity extends AppCompatActivity {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private SlideshowView slideShowView;

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow_sample);

        slideShowView = findViewById(R.id.slideshow_view);

        // Get Sample Data & Create the Slides
        List<Integer> slideshowDataList = DataCollection.getSlideshowData();
        List<ViewGroup> slideshowLayouts = new ArrayList<>();
        for (int k = 0; k < slideshowDataList.size(); k++) {
            SlideshowAdapter introSlide = new SlideshowAdapter(getApplicationContext(), slideshowDataList.get(k));
            slideshowLayouts.add(introSlide.getRootView());
        }

        // Start the slideshow
        try {
            slideShowView.setSlideList(slideshowLayouts);
            slideShowView.launch();
        } catch (SlideOutOfBoundException e) {
            Log.e("mTag", e.toString());
        } catch (SlideNullPointerException e) {
            Log.e("mTag", e.toString());
        }

    }
}