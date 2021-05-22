package com.sung2063.slideshowviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.sung2063.sliders.carousel.CarouselView;
import com.sung2063.sliders.exception.SlideNullPointerException;
import com.sung2063.sliders.exception.SlideOutOfBoundException;
import com.sung2063.sliders.listener.SliderListener;
import com.sung2063.sliders.model.DescriptiveSlideModel;
import com.sung2063.slideshowviewsample.adapter.HorizontalCarouselAdapter;

import java.util.ArrayList;
import java.util.List;

public class ExtraFeatureSampleActivity extends AppCompatActivity {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private final String TAG = ExtraFeatureSampleActivity.class.getName();

    // =============================================================================================
    // Activity Life Cycle
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_feature_sample);

        CarouselView carouselView = findViewById(R.id.carousel_view);

        // Get Sample Data & Create the Slides
        List<DescriptiveSlideModel> descriptiveSlideList = new ArrayList<>();
        HorizontalCarouselAdapter horizontalSlide = new HorizontalCarouselAdapter(getApplicationContext(), R.drawable.cat_image1);
        descriptiveSlideList.add(new DescriptiveSlideModel(horizontalSlide.getRootView(), "Lovely cat \uD83E\uDD70"));

        HorizontalCarouselAdapter horizontalSlide2 = new HorizontalCarouselAdapter(getApplicationContext(), R.drawable.cat_image2);
        descriptiveSlideList.add(new DescriptiveSlideModel(horizontalSlide2.getRootView(), "Climbing the tree"));

        HorizontalCarouselAdapter horizontalSlide3 = new HorizontalCarouselAdapter(getApplicationContext(), R.drawable.cat_image3);
        descriptiveSlideList.add(new DescriptiveSlideModel(horizontalSlide3.getRootView(), null));

        HorizontalCarouselAdapter horizontalSlide4 = new HorizontalCarouselAdapter(getApplicationContext(), R.drawable.cat_image4);
        descriptiveSlideList.add(new DescriptiveSlideModel(horizontalSlide4.getRootView(), "Cutie Cat \uD83E\uDD70"));

        HorizontalCarouselAdapter horizontalSlide5 = new HorizontalCarouselAdapter(getApplicationContext(), R.drawable.cat_image5);
        descriptiveSlideList.add(new DescriptiveSlideModel(horizontalSlide5.getRootView(), "\uD83C\uDF42 \uD83C\uDF42 \uD83C\uDF42 \uD83C\uDF42"));

        // Add callback listener
        SliderListener sliderListener = position -> {
            // TODO: Do something when slide is clicked
            Toast.makeText(getApplicationContext(), "Clicked slider Position: " + position, Toast.LENGTH_SHORT).show();
        };

        // Start the slideshow
        try {
            carouselView.setDescriptiveSlideList(descriptiveSlideList);
            carouselView.setSliderListener(sliderListener);
            carouselView.launch();
        } catch (SlideOutOfBoundException e) {
            Log.e(TAG, e.toString());
        } catch (SlideNullPointerException e) {
            Log.e(TAG, e.toString());
        }
    }
}