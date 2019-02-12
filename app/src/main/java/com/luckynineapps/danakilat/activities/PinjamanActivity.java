package com.luckynineapps.danakilat.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.adapters.PinjamanAdapter;
import com.luckynineapps.danakilat.models.pinjaman.Pinjaman;
import com.luckynineapps.danakilat.models.pinjaman.PinjamanResponse;
import com.luckynineapps.danakilat.utils.DialogUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.luckynineapps.danakilat.data.Constant.FINTECH;

public class PinjamanActivity extends AppCompatActivity {

    @BindView(R.id.image_title)
    TextView imageTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<Pinjaman> listPinjaman;
    List<Pinjaman> listPinjamanChecked;

    PinjamanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjaman);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initRecyclerView();
    }

    private void initRecyclerView() {
        listPinjaman = new ArrayList<>();
        listPinjamanChecked = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PinjamanAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PinjamanAdapter.OnItemClickListener() {
            @Override
            public void onClick(Pinjaman item) {
                Intent intent = new Intent(PinjamanActivity.this, DetailPinjamanActivity.class);
                intent.putExtra("pinjaman", item);
                startActivity(intent);
            }
        });
        adapter.setOnItemCheckListener(new PinjamanAdapter.OnItemCheckListener() {
            @Override
            public void onItemCheck(Pinjaman item) {
                listPinjamanChecked.add(item);
            }

            @Override
            public void onItemUncheck(Pinjaman item) {
                listPinjamanChecked.remove(item);
            }
        });

        loadItems();
    }

    private void loadItems() {
        DialogUtils.openDialog(this);

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
                                Toast.makeText(PinjamanActivity.this, "Data Tidak Ditemukan !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(PinjamanActivity.this, "Kesalahan teknis : " + anError.toString(), Toast.LENGTH_SHORT).show();
                        DialogUtils.closeDialog();
                    }
                });
    }

    @OnClick({R.id.btn_information, R.id.btn_share, R.id.btn_perbandingan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_information:
                Toast.makeText(this, "Informasi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Silahkan download aplikasi ini.\nDapatkan sekarang juga : http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Dana Kilat");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Dana Kilat"));
                break;
            case R.id.btn_perbandingan:
                Intent i = new Intent(this, PerbandinganActivity.class);
                i.putExtra("list_pinjaman", (Serializable) listPinjamanChecked);
                startActivity(i);
                break;
        }
    }
}
