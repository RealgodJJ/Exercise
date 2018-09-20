package reagodjj.example.com.exercise.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import reagodjj.example.com.exercise.adapter.MyFragmentPagerAdapter;
import reagodjj.example.com.exercise.R;

public class FragmentViewPagerActivity extends AppCompatActivity {
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_view_pager);
        vpMain = findViewById(R.id.vp_main);

//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(new TextFragment());
//        fragments.add(new ImageFragment());

        MyFragmentPagerAdapter myFragmentPagerAdpter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(myFragmentPagerAdpter);
    }
}
