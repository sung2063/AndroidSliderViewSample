package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.sung2063.sliders.carousel.CarouselView;
import com.sung2063.sliders.exceptions.SlideNullPointerException;
import com.sung2063.sliders.exceptions.SlideOutOfBoundException;
import com.sung2063.slideshowviewsample.adapter.HorizontalCarouselAdapter;
import com.sung2063.slideshowviewsample.data.DataCollection;
import com.sung2063.slideshowviewsample.model.HorizontalCarouselModel;

import java.util.ArrayList;
import java.util.List;

public class HorizontalCarouselSampleActivity extends AppCompatActivity {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private final String TAG = HorizontalCarouselSampleActivity.class.getName();

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_carousel_sample);

        CarouselView carouselView = findViewById(R.id.carousel_view);

        // Get Sample Data & Create the Slides
        List<HorizontalCarouselModel> introSlideDataList = DataCollection.getHorizontalCarouselData(getApplicationContext());
        List<ViewGroup> horizontalCarouselLayouts = new ArrayList<>();
        for (int k = 0; k < introSlideDataList.size(); k++) {
            HorizontalCarouselAdapter horizontalSlide = new HorizontalCarouselAdapter(getApplicationContext(), introSlideDataList.get(k));
            horizontalCarouselLayouts.add(horizontalSlide.getRootView());
        }

        // Start the slideshow
        try {
            carouselView.setSlideList(horizontalCarouselLayouts);
            carouselView.launch();
        } catch (SlideOutOfBoundException e) {
            Log.e(TAG, e.toString());
        } catch (SlideNullPointerException e) {
            Log.e(TAG, e.toString());
        }
    }
}