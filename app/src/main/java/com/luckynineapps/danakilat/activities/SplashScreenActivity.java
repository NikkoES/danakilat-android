package com.luckynineapps.danakilat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.models.ImageSliderModel;
import com.luckynineapps.danakilat.models.slider.Slider;
import com.luckynineapps.danakilat.models.slider.SliderResponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.luckynineapps.danakilat.data.Constant.SLIDER;
import static com.luckynineapps.danakilat.data.Constant.WEB_URL_IMAGE_SLIDER;

public class SplashScreenActivity extends AppCompatActivity {

    List<ImageSliderModel> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadItems();
    }

    private void loadItems() {
        AndroidNetworking.get(SLIDER)
                .build()
                .getAsObject(SliderResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        if (response instanceof SliderResponse) {
                            SliderResponse response1 = ((SliderResponse) response);
                            if (response1.getStatus().equalsIgnoreCase("success") && (response1.getData().size() > 0)) {
                                for (int i = 0; i < response1.getData().size(); i++) {
                                    Slider slider = response1.getData().get(i);
                                    imageList.add(new ImageSliderModel(slider.getDeskripsi(), WEB_URL_IMAGE_SLIDER + slider.getImage()));
                                }
                                Intent i = new Intent(SplashScreenActivity.this, WelcomeActivity.class);
                                i.putExtra("list", (Serializable) imageList);
                                startActivity(i);

                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(SplashScreenActivity.this, "Kesalahan teknis : " + anError.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
