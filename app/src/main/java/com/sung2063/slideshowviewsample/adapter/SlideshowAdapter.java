package com.sung2063.slideshowviewsample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sung2063.slideshowviewsample.R;

public class SlideshowAdapter {

    // =============================================================================================
    // Variables
    // =============================================================================================
    private Context context;
    private ViewGroup vgContainer;
    private ImageView ivImage;

    // =============================================================================================
    // Constructor
    // =============================================================================================
    public SlideshowAdapter(Context context, Integer drawableImageId) {
        this.context = context;
        initViews();
        populateData(drawableImageId);
    }

    // =============================================================================================
    // Methods
    // =============================================================================================
    private void initViews() {

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup rootLayout = (ViewGroup) inflater.inflate(R.layout.image_template_layout, null);

        vgContainer = (ViewGroup) rootLayout.findViewById(R.id.cl_container);
        ivImage = (ImageView) rootLayout.findViewById(R.id.iv_image);

    }

    private void populateData(Integer drawableImageId) {
        ivImage.setImageDrawable(context.getDrawable(drawableImageId));
    }

    public ViewGroup getRootView() {
        return vgContainer;
    }

}
