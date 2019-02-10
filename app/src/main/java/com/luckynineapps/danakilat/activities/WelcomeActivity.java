package com.luckynineapps.danakilat.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.luckynineapps.danakilat.fragments.SliderFragment;
import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.models.ImageSliderModel;
import com.luckynineapps.danakilat.models.slider.Slider;
import com.luckynineapps.danakilat.models.slider.SliderResponse;
import com.luckynineapps.danakilat.views.SampleSlide;

import java.util.ArrayList;
import java.util.List;

import static com.luckynineapps.danakilat.data.Constant.SLIDER;
import static com.luckynineapps.danakilat.data.Constant.WEB_URL_IMAGE_SLIDER;

public class WelcomeActivity extends AppIntro2 {

    List<ImageSliderModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = (List<ImageSliderModel>) getIntent().getSerializableExtra("list");

        initSlider();

        showSkipButton(false);
    }

    private void initSlider() {
        Log.e("SIZE", "" + list.size());
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ImageSliderModel sliderModel = list.get(i);
                addSlide(SliderFragment.newInstance(sliderModel.getName(), sliderModel.getImage_drawable()));
            }
        }
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        open();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

    void open() {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
