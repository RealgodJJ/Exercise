package reagodjj.example.com.exercise.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import reagodjj.example.com.exercise.ui.fragment.TextFragment;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
//    private List<Fragment> fragments;
    private SparseArray<Fragment> fragments;     //固定为Int类型的HashMap

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
//        this.fragments = fragments;
        fragments = new SparseArray<>();
    }

    @Override
    public Fragment getItem(int position) {
//        return fragments.get(position);
//        return TextFragment.getTextFragment(String.valueOf(position));
        Fragment fragment = fragments.get(position);
        if (fragment == null) {
            fragment = TextFragment.getTextFragment(String.valueOf(position));
            fragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
//        return fragments.size();
        return 20;
    }
}
