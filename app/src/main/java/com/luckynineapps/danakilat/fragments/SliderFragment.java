package com.luckynineapps.danakilat.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luckynineapps.danakilat.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SliderFragment extends Fragment {

    View view;
    Unbinder unbinder;

    String image, title;

    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.txt_title)
    TextView txtTitle;

    public static SliderFragment newInstance(String title, String image) {

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("image", image);

        SliderFragment fragment = new SliderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_slider, container, false);

        unbinder = ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        image = getArguments().getString("image");
        title = getArguments().getString("title");

        Picasso.get().load(image).into(imageView);
        txtTitle.setText(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
