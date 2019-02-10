package com.luckynineapps.danakilat.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.models.pinjaman.Pinjaman;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerbandinganFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.txt_title)
    TextView txtTitle;

    List<Pinjaman> listPinjamanChecked;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perbandingan, container, false);

        unbinder = ButterKnife.bind(this, view);
        listPinjamanChecked = new ArrayList<>();

        return view;
    }

    public void displayReceivedData(List<Pinjaman> list) {
        listPinjamanChecked = list;
        txtTitle.setText("Data received: " + listPinjamanChecked.size());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
