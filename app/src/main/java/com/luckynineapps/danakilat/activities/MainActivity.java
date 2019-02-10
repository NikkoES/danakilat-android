package com.luckynineapps.danakilat.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luckynineapps.danakilat.R;
import com.luckynineapps.danakilat.adapters.viewpager.VpAdapter;
import com.luckynineapps.danakilat.application.MyApp;
import com.luckynineapps.danakilat.fragments.PerbandinganFragment;
import com.luckynineapps.danakilat.fragments.PinjamanFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.image_title)
    TextView imageTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.view_pager_menu)
    ViewPager viewPagerMenu;
    @BindView(R.id.tab_layout_menu)
    TabLayout tabLayoutMenu;

    private VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        initView();
    }

    public void initView() {

        vpAdapter = new VpAdapter(getSupportFragmentManager());

        vpAdapter.addFragment(new PinjamanFragment(), "");
        vpAdapter.addFragment(new PerbandinganFragment(), "");

        viewPagerMenu.setAdapter(vpAdapter);
        viewPagerMenu.setOffscreenPageLimit(2);

        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setIcon(R.drawable.ic_money).setText("Pinjaman"));
        tabLayoutMenu.addTab(tabLayoutMenu.newTab().setIcon(R.drawable.ic_list).setText("Perbandingan"));

        tabLayoutMenu.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerMenu.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        tabLayoutMenu.setupWithViewPager(viewPagerMenu);
        inflateDivider();
    }

    private void inflateDivider() {
        for (int i = 0; i < tabLayoutMenu.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayoutMenu.getTabAt(i);
            RelativeLayout relativeLayout = (RelativeLayout)
                    LayoutInflater.from(this).inflate(R.layout.tab_layout, tabLayoutMenu, false);

            TextView tabTextView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.img_tab);
            tabTextView.setText(tab.getText());
            imageView.setImageDrawable(tab.getIcon());
            tab.setCustomView(relativeLayout);
//            tab.select();
        }
    }

    @OnClick({R.id.btn_information, R.id.btn_cart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_information:
                Toast.makeText(this, "Informasi", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cart:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Silahkan download aplikasi ini.\nDapatkan sekarang juga : http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();

                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Dana Kilat");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Dana Kilat"));
                break;
        }
    }
}
