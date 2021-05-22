package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sung2063.sliders.exception.SlideNullPointerException;
import com.sung2063.sliders.exception.SlideOutOfBoundException;
import com.sung2063.sliders.listener.SliderListener;
import com.sung2063.sliders.slideshow.SlideshowView;
import com.sung2063.slideshowviewsample.adapter.SlideshowAdapter;
import com.sung2063.slideshowviewsample.data.DataCollection;

import java.util.ArrayList;
import java.util.List;

public class SlideshowSampleActivity extends AppCompatActivity {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private final String TAG = SlideshowSampleActivity.class.getName();

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow_sample);

        SlideshowView slideShowView = findViewById(R.id.slideshow_view);

        // Get Sample Data & Create the Slides
        List<Integer> slideshowDataList = DataCollection.getSlideshowData();
        List<ViewGroup> slideshowLayouts = new ArrayList<>();
        for (int k = 0; k < slideshowDataList.size(); k++) {
            SlideshowAdapter introSlide = new SlideshowAdapter(getApplicationContext(), slideshowDataList.get(k));
            slideshowLayouts.add(introSlide.getRootView());
        }

        // Add callback listener
        SliderListener sliderListener = position -> {
            // TODO: Do something when slide is clicked
            Toast.makeText(getApplicationContext(), "Clicked slider Position: " + position, Toast.LENGTH_SHORT).show();
        };

        // Start the slideshow
        try {
            slideShowView.setSlideList(slideshowLayouts);
            slideShowView.setSliderListener(sliderListener);
            slideShowView.launch();
        } catch (SlideOutOfBoundException e) {
            Log.e(TAG, e.toString());
        } catch (SlideNullPointerException e) {
            Log.e(TAG, e.toString());
        }

    }
}