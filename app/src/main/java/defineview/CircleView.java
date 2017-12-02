package defineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by xianren on 2017/12/2.
 */
public class CircleView extends View {
    Paint mPaint;
    int widthSize;
    int heightSize;

    public CircleView(Context context) {
        super(context);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        Log.e(TAG, "onMeasure--widthMode-->" + widthMode);
        switch (widthMode) {
            case MeasureSpec.EXACTLY:

                break;
            case MeasureSpec.AT_MOST:

                break;
            case MeasureSpec.UNSPECIFIED:

                break;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        // 动态获取子View实例
//        for (int i = 0, size = getChildCount(); i < size; i++) {
//            View view = getChildAt(i);
//            // 放置子View，宽高都是100
//            view.layout(l, t, l + 100, t + 100);
//            l += 100 + padding;
//        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int circleRadius = 200;
        mPaint.setAntiAlias(false);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(widthSize/2,heightSize/2, circleRadius, mPaint);
    }

    void init() {
        mPaint = new Paint();
    }
}
