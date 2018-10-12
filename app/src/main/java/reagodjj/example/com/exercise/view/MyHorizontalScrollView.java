package reagodjj.example.com.exercise.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewHelper;

import reagodjj.example.com.exercise.R;

public class MyHorizontalScrollView extends HorizontalScrollView {
    private LinearLayout mWapper;//横向水平滚动条中的布局
    private ViewGroup mMenu, mContent;//菜单栏和内容页
    private int mScreenWidth;//屏幕宽度
    private int mMenuWidth;//菜单栏的宽度
    private int mMenuRightPadding;//菜单栏和屏幕右侧的距离(dp)
    private boolean once;
    private boolean isOpen;

    /**
     * 未使用自定义属性时调用
     */
    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    /**
     * 当使用了自定义的属性时，会调用此构造方法
     */
    public MyHorizontalScrollView(Context context) {
        this(context, null);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取定义的属性
        @SuppressLint("Recycle")
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyHorizontalScrollView,
                defStyleAttr, 0);

        //遍历并判断自定义属性
        int attrNum = typedArray.getIndexCount();
        for (int i = 0; i < attrNum; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.MyHorizontalScrollView_rightPadding:
                    mMenuRightPadding = typedArray.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                    50, context.getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();

        //获取窗口管理器
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //通过DisplayMetrics多包含的信息，获取屏幕的宽和高
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取应用程序显示区域描述大小和密度的度量值
        assert windowManager != null;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWidth = displayMetrics.widthPixels;

//        //把单位dp转换为px
//        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
//                50, context.getResources().getDisplayMetrics());
    }

    /**
     * 设置子view的宽和高，设置自己的宽和高
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
                    isOpen = false;
                } else {
                    this.smoothScrollTo(0, 0);
                    isOpen = true;
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }


    /**
     * 打开菜单
     */
    public void openMenu() {
        if (isOpen)
            return;
        this.smoothScrollTo(0, 0);
        isOpen = true;
    }

    public void closeMenu() {
        if (!isOpen)
            return;
        this.smoothScrollTo(mMenuWidth, 0);
        isOpen = false;
    }

    public void toggle() {
        if (isOpen)
            closeMenu();
        else
            openMenu();
    }


    /**
     * 滚动发生时调用
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        //调用属性动画，设置TranslationX（为了实现抽屉式侧滑效果）
        float scale = l * 1.0f / mMenuWidth;

        /*
         * 区别1：内容区域1.0~0.7 缩放的效果 scale : 1.0~0.0 0.7 + 0.3 * scale
         *
         * 区别2：菜单的偏移量需要修改
         *
         * 区别3：菜单的显示时有缩放以及透明度变化 缩放：
         * 0.7 ~1.0 1.0 - scale * 0.3
         * 透明度 0.6 ~ 1.0 0.6+ 0.4 * (1- scale) ;
         *
         */

        float rightScale = 0.7f + 0.3f * scale;
        float leftScale = 1.0f - scale * 0.3f;
        float leftAlpha = 1.0f - scale * 0.4f;

        //设置Menu的动画效果
        ViewHelper.setTranslationX(mMenu, mMenuWidth * scale * 0.8f);
        ViewHelper.setScaleX(mMenu, leftScale);
        ViewHelper.setScaleY(mMenu, leftScale);
        ViewHelper.setAlpha(mMenu, leftAlpha);

        //设置Content缩放的中心点
        ViewHelper.setPivotX(mContent, 0);
        ViewHelper.setPivotY(mContent, mContent.getHeight() / 2);
        ViewHelper.setScaleX(mContent, rightScale);
        ViewHelper.setScaleY(mContent, rightScale);
    }
}
