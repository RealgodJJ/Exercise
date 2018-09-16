package reagodjj.example.com.exercise.ui;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import reagodjj.example.com.exercise.Adapter.MyPagerAdapter;
import reagodjj.example.com.exercise.R;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        vpMain = findViewById(R.id.vp_main);

        List<View> lViews = new ArrayList<>();
        @SuppressLint("InflateParams") View viewText = LayoutInflater.from(this).inflate(R.layout.view_text, null);
        @SuppressLint("InflateParams") View viewPic = LayoutInflater.from(this).inflate(R.layout.view_pic, null);
        @SuppressLint("InflateParams") View viewBg = LayoutInflater.from(this).inflate(R.layout.view_bg, null);
        lViews.add(viewText);
        lViews.add(viewPic);
        lViews.add(viewBg);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(lViews);
        vpMain.setAdapter(myPagerAdapter);

        vpMain.setCurrentItem(1);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
