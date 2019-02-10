package com.luckynineapps.danakilat.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.activities.DetailPinjamanActivity;
import com.luckynineapps.danakilat.adapters.PinjamanAdapter;
import com.luckynineapps.danakilat.adapters.viewpager.ImageSliderAdapter;
import com.luckynineapps.danakilat.models.ImageSliderModel;
import com.luckynineapps.danakilat.models.pinjaman.Pinjaman;
import com.luckynineapps.danakilat.models.pinjaman.PinjamanResponse;
import com.luckynineapps.danakilat.models.slider.Slider;
import com.luckynineapps.danakilat.models.slider.SliderResponse;
import com.luckynineapps.danakilat.utils.DialogUtils;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.luckynineapps.danakilat.data.Constant.FINTECH;
import static com.luckynineapps.danakilat.data.Constant.SLIDER;
import static com.luckynineapps.danakilat.data.Constant.WEB_URL_IMAGE_SLIDER;

public class PinjamanFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    View view;

    List<Pinjaman> listPinjaman;
    List<Pinjaman> listPinjamanChecked;

    PinjamanAdapter adapter;

    SendMessage SM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pinjaman, container, false);

        unbinder = ButterKnife.bind(this, view);

        initRecyclerView();

        return view;
    }

    public interface SendMessage {
        void sendData(List<Pinjaman> message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            SM = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }

    private void initRecyclerView() {
        listPinjaman = new ArrayList<>();
        listPinjamanChecked = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PinjamanAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PinjamanAdapter.OnItemClickListener() {
            @Override
            public void onClick(Pinjaman item) {
                Intent intent = new Intent(getActivity(), DetailPinjamanActivity.class);
                intent.putExtra("pinjaman", item);
                startActivity(intent);
            }
        });
        adapter.setOnItemCheckListener(new PinjamanAdapter.OnItemCheckListener() {
            @Override
            public void onItemCheck(Pinjaman item) {
                listPinjamanChecked.add(item);
                SM.sendData(listPinjamanChecked);
            }

            @Override
            public void onItemUncheck(Pinjaman item) {
                listPinjamanChecked.remove(item);
                SM.sendData(listPinjamanChecked);
            }
        });

        loadItems();
    }

    private void loadItems() {
        DialogUtils.openDialog(getActivity());

        AndroidNetworking.get(FINTECH)
                .build()
                .getAsObject(PinjamanResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        if (response instanceof PinjamanResponse) {
                            PinjamanResponse response1 = ((PinjamanResponse) response);
                            if (response1.getStatus().equalsIgnoreCase("success") && (response1.getData().size() > 0)) {
                                listPinjaman.addAll(response1.getData());
                                adapter.swap(listPinjaman);
                                DialogUtils.closeDialog();
                            } else {
                                DialogUtils.closeDialog();
                                Toast.makeText(getActivity(), "Data Tidak Ditemukan !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(getActivity(), "Kesalahan teknis : " + anError.toString(), Toast.LENGTH_SHORT).show();
                        DialogUtils.closeDialog();
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
