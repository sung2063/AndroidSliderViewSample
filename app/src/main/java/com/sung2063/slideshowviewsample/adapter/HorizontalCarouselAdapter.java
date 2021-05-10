package com.sung2063.slideshowviewsample.adapter;

import android.content.Context;

import androidx.core.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sung2063.slideshowviewsample.R;
import com.sung2063.slideshowviewsample.model.HorizontalCarouselModel;

public class HorizontalCarouselAdapter {

    // Variables ========================================================
    private ViewGroup vgContainer;

    // Constructors =====================================================
    // Constructor for image carousel
    public HorizontalCarouselAdapter(Context context, Integer drawableImageId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup rootLayout = (ViewGroup) inflater.inflate(R.layout.image_template_layout, null);
        vgContainer = rootLayout.findViewById(R.id.cl_container);
        ImageView ivImage = rootLayout.findViewById(R.id.iv_image);

        ivImage.setImageDrawable(context.getDrawable(drawableImageId));
    }

    // Constructor for quotation icon carousel
    public HorizontalCarouselAdapter(Context context, HorizontalCarouselModel introSlideData) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup rootLayout = (ViewGroup) inflater.inflate(R.layout.quotation_icon_template_layout, null);
        vgContainer = rootLayout.findViewById(R.id.cl_container);
        ImageView ivIcon = rootLayout.findViewById(R.id.iv_icon);
        TextView tvTitle = rootLayout.findViewById(R.id.tv_title);
        TextView tvDescription = rootLayout.findViewById(R.id.tv_description);

        vgContainer.setBackgroundColor(context.getResources().getColor(introSlideData.getBackgroundColor()));
        ivIcon.setImageDrawable(context.getDrawable(introSlideData.getIconId()));
        ivIcon.setColorFilter(ContextCompat.getColor(context, introSlideData.getIconColor()), android.graphics.PorterDuff.Mode.SRC_IN);
        tvTitle.setText(introSlideData.getTitle());
        tvDescription.setText(introSlideData.getDescription());
    }

    // Methods =========================================================

    public ViewGroup getRootView() {
        return vgContainer;
    }

}