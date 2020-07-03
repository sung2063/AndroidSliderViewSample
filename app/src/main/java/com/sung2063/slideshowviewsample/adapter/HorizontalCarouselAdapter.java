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
    private Context context;
    private ViewGroup vgContainer;
    private ImageView ivIcon;
    private TextView tvTitle, tvDescription;

    // Constructors =====================================================
    public HorizontalCarouselAdapter(Context context, HorizontalCarouselModel introSlideData) {
        // Required empty public constructor
        this.context = context;
        initViews();
        populateData(introSlideData);
    }

    // Methods =========================================================
    private void initViews() {

        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup rootLayout = (ViewGroup) inflater.inflate(R.layout.horizontal_carousel_sample_layout, null);

        vgContainer = (ViewGroup) rootLayout.findViewById(R.id.cl_container);
        ivIcon = (ImageView) rootLayout.findViewById(R.id.iv_icon);
        tvTitle = (TextView) rootLayout.findViewById(R.id.tv_title);
        tvDescription = (TextView) rootLayout.findViewById(R.id.tv_description);

    }

    private void populateData(HorizontalCarouselModel introSlideData) {
        vgContainer.setBackgroundColor(context.getResources().getColor(introSlideData.getBackgroundColor()));
        ivIcon.setImageDrawable(context.getDrawable(introSlideData.getIconId()));
        ivIcon.setColorFilter(ContextCompat.getColor(context, introSlideData.getIconColor()), android.graphics.PorterDuff.Mode.SRC_IN);
        tvTitle.setText(introSlideData.getTitle());
        tvDescription.setText(introSlideData.getDescription());
    }

    public ViewGroup getRootView() {
        return vgContainer;
    }

}