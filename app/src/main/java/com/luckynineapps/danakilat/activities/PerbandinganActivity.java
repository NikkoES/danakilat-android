package com.luckynineapps.danakilat.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.models.pinjaman.Pinjaman;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerbandinganActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.layout_perbandingan)
    LinearLayout layoutPerbandingan;
    @BindView(R.id.ad_bottom)
    AdView bottomAds;

    List<Pinjaman> listOld = new ArrayList<>();
    List<Pinjaman> list = new ArrayList<>();

    int dp0, dp1, dp2, dp4, dp8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perbandingan);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        list = (List<Pinjaman>) getIntent().getSerializableExtra("list_pinjaman");

        initAd();
        initSize();
        initLayout();
    }

    private void initAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        bottomAds.loadAd(adRequest);
    }

    private void initSize() {
        dp0 = getResources().getDimensionPixelSize(R.dimen.dp_0);
        dp1 = getResources().getDimensionPixelSize(R.dimen.dp_1);
        dp2 = getResources().getDimensionPixelSize(R.dimen.dp_2);
        dp4 = getResources().getDimensionPixelSize(R.dimen.dp_4);
        dp8 = getResources().getDimensionPixelSize(R.dimen.dp_8);
    }

    private void initLayout() {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                LinearLayout tableRow = new LinearLayout(this);
                tableRow.setOrientation(LinearLayout.VERTICAL);
                tableRow.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtNamaPinjaman = new TextView(this);
                txtNamaPinjaman.setPadding(dp8, dp8, dp8, dp8);
                txtNamaPinjaman.setGravity(Gravity.CENTER);
                txtNamaPinjaman.setBackgroundResource(R.drawable.table_row_right_bg);
                txtNamaPinjaman.setTextColor(getResources().getColor(R.color.softBlack));
                txtNamaPinjaman.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtUmurPeminjam = new TextView(this);
                txtUmurPeminjam.setPadding(dp8, dp8, dp8, dp8);
                txtUmurPeminjam.setGravity(Gravity.CENTER);
                txtUmurPeminjam.setBackgroundResource(R.drawable.table_row_right_bg);
                txtUmurPeminjam.setTextColor(getResources().getColor(R.color.softBlack));
                txtUmurPeminjam.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtWargaNegara = new TextView(this);
                txtWargaNegara.setPadding(dp8, dp8, dp8, dp8);
                txtWargaNegara.setGravity(Gravity.CENTER);
                txtWargaNegara.setBackgroundResource(R.drawable.table_row_right_bg);
                txtWargaNegara.setTextColor(getResources().getColor(R.color.softBlack));
                txtWargaNegara.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtDokumen = new TextView(this);
                txtDokumen.setPadding(dp8, dp8, dp8, dp8);
                txtDokumen.setGravity(Gravity.CENTER);
                txtDokumen.setBackgroundResource(R.drawable.table_row_right_bg);
                txtDokumen.setTextColor(getResources().getColor(R.color.softBlack));
                txtDokumen.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtBank = new TextView(this);
                txtBank.setPadding(dp8, dp8, dp8, dp8);
                txtBank.setGravity(Gravity.CENTER);
                txtBank.setBackgroundResource(R.drawable.table_row_right_bg);
                txtBank.setTextColor(getResources().getColor(R.color.softBlack));
                txtBank.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtPenghasilanMinimum = new TextView(this);
                txtPenghasilanMinimum.setPadding(dp8, dp8, dp8, dp8);
                txtPenghasilanMinimum.setGravity(Gravity.CENTER);
                txtPenghasilanMinimum.setBackgroundResource(R.drawable.table_row_right_bg);
                txtPenghasilanMinimum.setTextColor(getResources().getColor(R.color.softBlack));
                txtPenghasilanMinimum.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtLimitPinjaman = new TextView(this);
                txtLimitPinjaman.setPadding(dp8, dp8, dp8, dp8);
                txtLimitPinjaman.setGravity(Gravity.CENTER);
                txtLimitPinjaman.setBackgroundResource(R.drawable.table_row_right_bg);
                txtLimitPinjaman.setTextColor(getResources().getColor(R.color.softBlack));
                txtLimitPinjaman.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtTenorPinjaman = new TextView(this);
                txtTenorPinjaman.setPadding(dp8, dp8, dp8, dp8);
                txtTenorPinjaman.setGravity(Gravity.CENTER);
                txtTenorPinjaman.setBackgroundResource(R.drawable.table_row_right_bg);
                txtTenorPinjaman.setTextColor(getResources().getColor(R.color.softBlack));
                txtTenorPinjaman.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtBunga = new TextView(this);
                txtBunga.setPadding(dp8, dp8, dp8, dp8);
                txtBunga.setGravity(Gravity.CENTER);
                txtBunga.setBackgroundResource(R.drawable.table_row_right_bg);
                txtBunga.setTextColor(getResources().getColor(R.color.softBlack));
                txtBunga.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtMaxKeterlambatan = new TextView(this);
                txtMaxKeterlambatan.setPadding(dp8, dp8, dp8, dp8);
                txtMaxKeterlambatan.setGravity(Gravity.CENTER);
                txtMaxKeterlambatan.setBackgroundResource(R.drawable.table_row_last_bg);
                txtMaxKeterlambatan.setTextColor(getResources().getColor(R.color.softBlack));
                txtMaxKeterlambatan.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtDomisili = new TextView(this);
                txtDomisili.setPadding(dp8, dp8, dp8, dp8);
                txtDomisili.setGravity(Gravity.CENTER);
                txtDomisili.setBackgroundResource(R.drawable.table_row_last_bg);
                txtDomisili.setTextColor(getResources().getColor(R.color.softBlack));
                txtDomisili.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtWaktuPersetujuan = new TextView(this);
                txtWaktuPersetujuan.setPadding(dp8, dp8, dp8, dp8);
                txtWaktuPersetujuan.setGravity(Gravity.CENTER);
                txtWaktuPersetujuan.setBackgroundResource(R.drawable.table_row_last_bg);
                txtWaktuPersetujuan.setTextColor(getResources().getColor(R.color.softBlack));
                txtWaktuPersetujuan.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                TextView txtLainlain = new TextView(this);
                txtLainlain.setPadding(dp8, dp8, dp8, dp8);
                txtLainlain.setGravity(Gravity.CENTER);
                txtLainlain.setBackgroundResource(R.drawable.table_row_last_bg);
                txtLainlain.setTextColor(getResources().getColor(R.color.softBlack));
                txtLainlain.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                //set data to text view
                Pinjaman pinjaman = list.get(i);
                txtNamaPinjaman.setText(pinjaman.getNamaPinjaman());
                txtUmurPeminjam.setText(pinjaman.getUmurPeminjam());
                txtWargaNegara.setText(pinjaman.getWargaNegara());
                txtDokumen.setText(pinjaman.getDokumen());
                txtBank.setText(pinjaman.getBank());
                txtPenghasilanMinimum.setText(pinjaman.getPenghasilanMinimum());
                txtLimitPinjaman.setText(pinjaman.getLimitPinjaman());
                txtTenorPinjaman.setText(pinjaman.getTenorPinjaman());
                txtBunga.setText(pinjaman.getBunga());
                txtMaxKeterlambatan.setText(pinjaman.getMaxKeterlambatan());
                txtDomisili.setText(pinjaman.getDomisiliPeminjam());
                txtWaktuPersetujuan.setText(pinjaman.getWaktuPersetujuan());
                txtLainlain.setText(pinjaman.getLainLain());

                //set text view to table row
                tableRow.addView(txtNamaPinjaman);
                tableRow.addView(txtUmurPeminjam);
                tableRow.addView(txtWargaNegara);
                tableRow.addView(txtDokumen);
                tableRow.addView(txtBank);
                tableRow.addView(txtPenghasilanMinimum);
                tableRow.addView(txtLimitPinjaman);
                tableRow.addView(txtTenorPinjaman);
                tableRow.addView(txtBunga);
                tableRow.addView(txtMaxKeterlambatan);
                tableRow.addView(txtDomisili);
                tableRow.addView(txtWaktuPersetujuan);
                tableRow.addView(txtLainlain);

                layoutPerbandingan.addView(tableRow);
            }
        } else {
            Toast.makeText(this, "Pinjaman belum ditambahkan !", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_share, R.id.btn_pinjaman})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Mau mendapatkan dana tunai dengan cepat.\nSilahkan download aplikasi ini, sekarang juga :\nhttp://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Dana Kilat");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Dana Kilat"));
                break;
            case R.id.btn_pinjaman:
                finish();
                break;
        }
    }
}
