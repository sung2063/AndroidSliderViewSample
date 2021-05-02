package com.sung2063.slideshowviewsample.data;

import android.content.Context;
import android.graphics.Color;

import com.sung2063.slideshowviewsample.R;
import com.sung2063.slideshowviewsample.model.HorizontalCarouselModel;
import com.sung2063.slideshowviewsample.model.MainOptionModel;

import java.util.ArrayList;
import java.util.List;

public class DataCollection {

    public static List<MainOptionModel> getMainOptionData(Context context) {
        List<MainOptionModel> mainOptionList = new ArrayList<>();
        mainOptionList.add(new MainOptionModel(-1, R.drawable.ic_menu_carousel_horizontal, R.color.menuColor1, context.getString(R.string.app_menu1), context.getString(R.string.app_menu1_description), Color.BLACK));
        mainOptionList.add(new MainOptionModel(-1, R.drawable.ic_menu_carousel_vertical, R.color.menuColor2, context.getString(R.string.app_menu2), context.getString(R.string.app_menu2_description), Color.BLACK));
        mainOptionList.add(new MainOptionModel(-1, R.drawable.ic_menu_slideshow, R.color.menuColor3, context.getString(R.string.app_menu3), context.getString(R.string.app_menu3_description), Color.BLACK));
        mainOptionList.add(new MainOptionModel(-1, R.drawable.ic_menu_extra_feature, R.color.menuColor4, context.getString(R.string.app_menu4), context.getString(R.string.app_menu4_description), Color.BLACK));
        mainOptionList.add(new MainOptionModel(Color.BLACK, R.drawable.ic_github, R.color.menuColor5, context.getString(R.string.app_menu5), context.getString(R.string.app_menu5_description), Color.WHITE));
        return mainOptionList;
    }

    /* ========================================================================================== */

    public static List<HorizontalCarouselModel> getHorizontalCarouselData(Context context) {
        List<HorizontalCarouselModel> horizontalCarouselList = new ArrayList<>();
        horizontalCarouselList.add(new HorizontalCarouselModel(R.color.introBackgroundColor1, R.drawable.ic_intro_icon1, R.color.introIconColor1, context.getString(R.string.intro_title1), context.getString(R.string.intro_description1)));
        horizontalCarouselList.add(new HorizontalCarouselModel(R.color.introBackgroundColor2, R.drawable.ic_intro_icon2, R.color.introIconColor2, context.getString(R.string.intro_title2), context.getString(R.string.intro_description2)));
        horizontalCarouselList.add(new HorizontalCarouselModel(R.color.introBackgroundColor3, R.drawable.ic_intro_icon3, R.color.introIconColor3, context.getString(R.string.intro_title3), context.getString(R.string.intro_description3)));
        horizontalCarouselList.add(new HorizontalCarouselModel(R.color.introBackgroundColor4, R.drawable.ic_intro_icon4, R.color.introIconColor4, context.getString(R.string.intro_title4), context.getString(R.string.intro_description4)));
        horizontalCarouselList.add(new HorizontalCarouselModel(R.color.introBackgroundColor5, R.drawable.ic_intro_icon5, R.color.introIconColor5, context.getString(R.string.intro_title5), context.getString(R.string.intro_description5)));
        return horizontalCarouselList;
    }

    /* ========================================================================================== */

    public static List<Integer> getVerticalCarouselData() {
        List<Integer> verticalCarouselList = new ArrayList<>();
        verticalCarouselList.add(R.drawable.vertical_carousel_sample_image1);
        verticalCarouselList.add(R.drawable.vertical_carousel_sample_image2);
        verticalCarouselList.add(R.drawable.vertical_carousel_sample_image3);
        verticalCarouselList.add(R.drawable.vertical_carousel_sample_image4);
        verticalCarouselList.add(R.drawable.vertical_carousel_sample_image5);
        verticalCarouselList.add(R.drawable.vertical_carousel_sample_image6);
        return verticalCarouselList;
    }

    /* ========================================================================================== */

    public static List<Integer> getSlideshowData() {
        List<Integer> slideshowList = new ArrayList<>();
        slideshowList.add(R.drawable.sample_slideshow_image1);
        slideshowList.add(R.drawable.sample_slideshow_image2);
        slideshowList.add(R.drawable.sample_slideshow_image3);
        slideshowList.add(R.drawable.sample_slideshow_image4);
        slideshowList.add(R.drawable.sample_slideshow_image5);
        slideshowList.add(R.drawable.sample_slideshow_image6);
        return slideshowList;
    }
    /* ========================================================================================== */

    public static List<Integer> getCatCarouselData() {
        List<Integer> carouselList = new ArrayList<>();
        carouselList.add(R.drawable.cat_image1);
        carouselList.add(R.drawable.cat_image2);
        carouselList.add(R.drawable.cat_image3);
        carouselList.add(R.drawable.cat_image4);
        carouselList.add(R.drawable.cat_image5);
        return carouselList;
    }
}
