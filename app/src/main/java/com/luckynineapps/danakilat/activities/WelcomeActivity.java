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
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.luckynineapps.danakilat.fragments.SliderFragment;
import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.models.ImageSliderModel;
import com.luckynineapps.danakilat.models.slider.Slider;
import com.luckynineapps.danakilat.models.slider.SliderResponse;
import com.luckynineapps.danakilat.views.SampleSlide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.luckynineapps.danakilat.data.Constant.SLIDER;
import static com.luckynineapps.danakilat.data.Constant.WEB_URL_IMAGE_SLIDER;

public class WelcomeActivity extends AppIntro {

    private InterstitialAd inters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initSlider();
        initAd();

        showSkipButton(false);
        setDoneText("GOT IT");
    }

    private void initAd() {
        inters = new InterstitialAd(this);
        inters.setAdUnitId(getString(R.string.ad_id_interstitial_tes));
        inters.loadAd(new AdRequest.Builder().build());
        inters.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                open();
            }
        });
    }

    private void initSlider() {
        addSlide(SliderFragment.newInstance(R.layout.fragment_slider_1));
        addSlide(SliderFragment.newInstance(R.layout.fragment_slider_2));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        if (inters != null && inters.isLoaded()) {
            inters.show();
        } else {
            open();
        }
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }

    void open() {
        Intent i = new Intent(this, PinjamanActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
