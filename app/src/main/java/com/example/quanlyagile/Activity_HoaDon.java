package com.example.quanlyagile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.quanlyagile.Adapter.FragHoaDonAdapter;
import com.example.quanlyagile.Fragment.Frag_HDN_Entry;
import com.example.quanlyagile.Fragment.Frag_HDX_Outlet;
import com.google.android.material.tabs.TabLayout;

public class Activity_HoaDon extends AppCompatActivity  {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    TextView item1, item2,select;
    private Toolbar toolbar;
    private FragHoaDonAdapter fragHoaDonAdapter;
    ColorStateList def;
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_nhap);
        tabLayout =findViewById(R.id.tabLayout_HDN);
        viewPager2 =findViewById(R.id.viewPager_HD);
        toolbar = findViewById(R.id.toolbar_HDN);
        setSupportActionBar(toolbar);

//        item1 = findViewById(R.id.item1);
//        item2 = findViewById(R.id.item2);
//        select = findViewById(R.id.select);
//        item1.setOnClickListener(this);
//        item2.setOnClickListener(this);
//111
//        def = item2.getTextColors();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable drawable=getResources().getDrawable(R.drawable.ic_left);
        drawable.setColorFilter(Color.parseColor("#28BB8E"), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        tabLayout.addTab(tabLayout.newTab().setText("Entry"));
        tabLayout.addTab(tabLayout.newTab().setText("Outlet"));

        fm = getSupportFragmentManager();
        fragHoaDonAdapter = new FragHoaDonAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragHoaDonAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        return true;

    }

//    @Override
//    public void onClick(View view) {
//        if (view.getId() == R.id.item1){
//            select.animate().x(0).setDuration(100);
//            item1.setTextColor( Color.parseColor("#28BB8E"));
//            item2.setTextColor(def);
//            item1.setShadowLayer(10, 10, 10, Color.parseColor("#39D4A5"));
//
//        }else if (view.getId() == R.id.item2){
//            item1.setTextColor(def);
//            item2.setTextColor( Color.parseColor("#28BB8E"));
//            int size=item2.getWidth();
//            item2.setShadowLayer(6, 10, 10, Color.parseColor("#39D4A5"));
//            select.animate().x(size).setDuration(100);
//
//
//        }
//    }
}