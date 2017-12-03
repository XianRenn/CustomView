package defineview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by guchangyou on 2017/12/2.
 */

public class FatherView extends ViewGroup {
    public FatherView(Context context) {
        super(context);
    }

    public FatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FatherView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int childCount = getChildCount();
//        for (int x = 0; x < childCount; x++) {
//            View view = getChildAt(x);
//            measureChild(view,widthMeasureSpec,heightMeasureSpec);
//            setMeasuredDimension(view.getMeasuredWidth(),view.getMeasuredHeight());
//        }
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //测量并保存layout的宽高(使用getDefaultSize时，wrap_content和match_perent都是填充屏幕)
        //稍后会重新写这个方法，能达到wrap_content的效果
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        int hadUsedHorizontal = 0;//水平已经使用的距离
        int hadUsedVertical = 0;//垂直已经使用的距离
        int width = getMeasuredWidth();
//        int height = getMeasuredHeight();
        for (int x = 0; x < getChildCount(); x++) {
            View view = getChildAt(x);
            //判断是否已经超出宽度
            if (view.getMeasuredWidth() + hadUsedHorizontal > width) {
                //已经超出了宽度
                hadUsedVertical = hadUsedVertical + view.getMeasuredHeight() + 10;
                hadUsedHorizontal = 0;
            }
            view.layout(hadUsedHorizontal, hadUsedVertical, hadUsedHorizontal + view.getMeasuredWidth(), hadUsedVertical + view.getMeasuredHeight());
            hadUsedHorizontal = hadUsedHorizontal + 10 + view.getMeasuredWidth();
        }

    }
}
