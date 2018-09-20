package reagodjj.example.com.exercise.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<View> lViews;

    public MyPagerAdapter(List<View> lViews) {
        this.lViews = lViews;
    }

    @Override
    public int getCount() {
        return lViews.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    /**
     * @param container 封装View的容器（ViewPager也就是ViewGroup）
     * @param position 对应View的编号位置
     * @return 返回当前初始化的View
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = lViews.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(lViews.get(position));
    }
}
