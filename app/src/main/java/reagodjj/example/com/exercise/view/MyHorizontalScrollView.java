package reagodjj.example.com.exercise.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class MyHorizontalScrollView extends HorizontalScrollView {
    private LinearLayout mWapper;//横向水平滚动条中的布局
    private ViewGroup mMenu, mContent;//菜单栏和内容页
    private int mScreenWidth;//屏幕宽度
    private int mMenuWidth;//菜单栏的宽度
    private int mMenuRightPadding;//菜单栏和屏幕右侧的距离(dp)
    private boolean once = false;

    /**
     * 未使用自定义属性时调用
     *
     */
    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取窗口管理器
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //通过DisplayMetrics多包含的信息，获取屏幕的宽和高
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取应用程序显示区域描述大小和密度的度量值
        assert windowManager != null;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWidth = displayMetrics.widthPixels;

        //把单位dp转换为px
        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                50, context.getResources().getDisplayMetrics());
    }


    /**
     * 设置子view的宽和高，设置自己的宽和高
     *
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mWapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWapper.getChildAt(0);
            mContent = (ViewGroup) mWapper.getChildAt(1);
            mMenuWidth = mMenu.getLayoutParams().width = mScreenWidth - mMenuRightPadding;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 通过设置偏移量，将menu隐藏
     *
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.scrollTo(mMenuWidth, 0);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                //隐藏在左侧的宽度
                int scrollX = getScrollX();
                if (scrollX >= mMenuWidth / 2) {
                    this.smoothScrollTo(mMenuWidth, 0);
                } else {
                    this.smoothScrollTo(0, 0);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }
}
